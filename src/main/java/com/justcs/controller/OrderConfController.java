package com.justcs.controller;


import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.justcs.entity.*;
import com.justcs.form.*;
import com.justcs.mapper.ConfMeetingRoomMapper;
import com.justcs.mapper.ConferenceMapper;
import com.justcs.service.ConfOrderService;
import com.justcs.utils.JSONResult;
import com.justcs.view.ConfOrderView;
import com.justcs.view.MeetingRoomView;
import com.justcs.view.OrderConfView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 预定会议控制层
 */
@RequestMapping("/order")
@RestController
@Api(value = "预定会议", description = "预定会议接口")
public class OrderConfController {

    private static final Logger logger = LoggerFactory.getLogger(OrderConfController.class);


    /**
     * 会议占用mapper
     */
    @Autowired
    private ConfMeetingRoomMapper confMeetingRoomMapper;

    @Autowired
    private ConferenceMapper conferenceMapper;


    /**
     * 预定会议的服务类
     */
    @Autowired
    private ConfOrderService confOrderService;

    /**
     * 分页查询所会议室
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "分页查询所会议室")
    @PostMapping("/queryrooms")
    public JSONResult queryMeetingRooms(@RequestBody @Valid PagedQueryForm<MeetingRoom_c> param) {
        try {
            PageInfo<MeetingRoomView> result = confOrderService.queryPagedMeetingRoom(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 查询会议安排
     *
     * @param roomid
     * @return
     */
    @ApiOperation(value = "查询会议安排")
    @PostMapping("/queryconfroom/{roomid}")
    public JSONResult queryConfRoom(@PathVariable("roomid") int roomid) {
        return JSONResult.ok(confMeetingRoomMapper.selectCofArrange(roomid));
    }


    /**
     * 分页查询人员信息
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "分页查询人员信息")
    @PostMapping("/querypeoples")
    public JSONResult querypeoples(@RequestBody @Valid PagedQueryForm<UserSelectView_c> param) {
        try {
            PageInfo<UserSelectView> result = confOrderService.queryUserSelect(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    /**
     * 查询所有待选择的用户信息
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询人员信息")
    @PostMapping("/queryattends")
    public JSONResult queryattends(@RequestBody UserSelectView_c param) {
        return JSONResult.ok(confOrderService.queryAllUsrSelect(param));
    }


    /**
     * 提交会议预约
     *
     * @param orderConfForm
     * @return
     */
    @ApiOperation(value = "预约会议")
    @PostMapping("/sureSubOrder")
    public JSONResult sureSubOrder(@RequestBody @Valid OrderConfForm orderConfForm) throws ParseException {
        logger.info(new Gson().toJson(orderConfForm));
        try {
            ConfOrderView confOrderView = new ConfOrderView();
            // 1.封装会议议题采集表
            MeetingCollect meetingCollect = new MeetingCollect();
            meetingCollect.setCollegeleader(orderConfForm.getLeadername());
            meetingCollect.setColltime(new Date(System.currentTimeMillis()));
            meetingCollect.setTermyear(orderConfForm.getYears());
            meetingCollect.setMeetsemesters(String.valueOf(orderConfForm.getSemesterid()));
            meetingCollect.setMeetweeks(orderConfForm.getWeeksno());
            confOrderView.setMeetingCollect(meetingCollect);

            // 2.封装上次会议所提议题
            List<IssueLastmeet> issueLastmeetList = new ArrayList<>();
            for (String element : orderConfForm.getLastquestions()) {
                IssueLastmeet e = new IssueLastmeet();
                e.setMaincontent(element);
                issueLastmeetList.add(e);
            }
            confOrderView.setIssueLastmeetList(issueLastmeetList);

            // 3.本次会议需要解决的问题
            List<IssueCurmeet> issueCurmeetList = new ArrayList<>();
            for (String element : orderConfForm.getCurquesttions()) {
                IssueCurmeet e = new IssueCurmeet();
                e.setMainconent(element);
                issueCurmeetList.add(e);
            }
            confOrderView.setIssueCurmeetList(issueCurmeetList);

            // 4.建议解决方案
            List<Suggestion> suggestionList = new ArrayList<>();
            for (String element : orderConfForm.getSuggestions()) {
                Suggestion e = new Suggestion();
                e.setMaincontent(element);
                suggestionList.add(e);
            }
            confOrderView.setSuggestionList(suggestionList);

            // 5.会议
            ConferenceWithBLOBs conference = new ConferenceWithBLOBs();
            conference.setConfname(orderConfForm.getConfname());
            conference.setSemesterid(orderConfForm.getSemesterid());
            conference.setConflevelid(orderConfForm.getConflevel());
            conference.setConfstatusid(1);// 会议状态
            conference.setRecorderid(orderConfForm.getRecorderid());
            conference.setRecorder(orderConfForm.getRecorder());
            // 设置会议主持人=>会议审核人员(编号)
            conference.setHosterid(orderConfForm.getLeadername());
            confOrderView.setConference(conference);

            // 6.会议属性
            List<ConfAttributes> confAttributesList = new ArrayList<>();
            for (Integer attr : orderConfForm.getConfattrs()) {
                ConfAttributes confAttributes = new ConfAttributes();
                confAttributes.setId(attr);
                confAttributesList.add(confAttributes);
            }
            confOrderView.setConfAttributesList(confAttributesList);

            // 7.封装列席人员
            List<Attendes> attendesList = new ArrayList<>();
            for (String a : orderConfForm.getSelectAttenders()) {
                Attendes attendes = new Attendes();
                attendes.setHasattend((short) 0);
                attendes.setWorkerid(a);
                attendesList.add(attendes);
            }
            confOrderView.setAttendesList(attendesList);

            // 8.会议室占用表
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            ConfMeetingRoom confMeetingRoom = new ConfMeetingRoom();
            confMeetingRoom.setMeetroomid(orderConfForm.getSelectedroomid());// 选中会议室编号
            confMeetingRoom.setStarttime(simpleDateFormat.parse(orderConfForm.getWeeksno() + " " + orderConfForm.getStarttime()));
            confMeetingRoom.setEndtime(simpleDateFormat.parse(orderConfForm.getWeeksno() + " " + orderConfForm.getEndtime()));
            confOrderView.setConfMeetingRoom(confMeetingRoom);

            // 执行预定会议操作
            return confOrderService.addConfOrderInfo(confOrderView) ? JSONResult.ok("预定成功!") : JSONResult.errorMsg("对不起添加失败");
        } catch (ParseException e) {
            logger.error("会议预定失败!");
            throw e;
        }
    }


    /**
     * 查询我的预约
     */
    @ApiOperation(value = "查询我的预约")
    @PostMapping("/{workerid}/allmyorder")
    public JSONResult allMyOrder(@PathVariable("workerid") String workerid) {
        if (workerid != null) {
            return JSONResult.ok(conferenceMapper.selectAllMyOrders(workerid));
        }
        return JSONResult.errorMsg("查询我的预约失败");
    }

    /**
     * 查询即将开始的会议
     */
    @ApiOperation(value = "查询即将开始的会议")
    @PostMapping("/{workerid}/commingConf")
    public JSONResult commingConf(@PathVariable("workerid") String workerid) {
        if (workerid != null) {
            return JSONResult.ok(conferenceMapper.selectAllCommingOrders(workerid));
        }
        return JSONResult.errorMsg("查询即将开始的会议失败");
    }

    /**
     * 新增会议室
     *
     * @param newRoomForm
     * @return
     */
    @ApiOperation(value = "新增会议室")
    @PostMapping("/addNewRoom")
    public JSONResult addNewRoom(@RequestBody @Valid NewRoomForm newRoomForm) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setDepartment(newRoomForm.getDepartment());
        meetingRoom.setRoomname(newRoomForm.getName());
        meetingRoom.setMaxcontain(newRoomForm.getSeats());
        // 下面遍历硬件条件
        for (String condition : newRoomForm.getHardcondition()) {
            switch (condition) {
                case "空调":
                    meetingRoom.setAircondition((short) 1);
                    break;
                case "投影仪":
                    meetingRoom.setProjector((short) 1);
                    break;
                case "麦克风":
                    meetingRoom.setMicrophone((short) 1);
                    break;
                case "音响":
                    meetingRoom.setStereo((short) 1);
                    break;
                case "演讲台":
                    meetingRoom.setPodium((short) 1);
                    break;
                case "照明设备":
                    meetingRoom.setLightequ((short) 1);
                    break;
                default:
                    break;
            }
        }
        // 调用录入会议室的方法
        confOrderService.addMeetingRoom(meetingRoom);
        if (meetingRoom != null) {
            return JSONResult.ok(meetingRoom);
        }
        return JSONResult.errorMsg("对不起会议室录入失败!");
    }

    /**
     * 修改会议室
     * @param newRoomForm
     * @return
     */
    @ApiOperation(value = "新增会议室")
    @PostMapping("/modifyRoom")
    public JSONResult modifyRoom(@RequestBody @Valid ModifyRoomForm newRoomForm) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(Integer.valueOf(newRoomForm.getRoomid()));
        meetingRoom.setDepartment(newRoomForm.getDepartment());
        meetingRoom.setRoomname(newRoomForm.getName());
        meetingRoom.setMaxcontain(newRoomForm.getSeats());
        // 下面遍历硬件条件
        for (String condition : newRoomForm.getHardcondition()) {
            switch (condition) {
                case "空调":
                    meetingRoom.setAircondition((short) 1);
                    break;
                case "投影仪":
                    meetingRoom.setProjector((short) 1);
                    break;
                case "麦克风":
                    meetingRoom.setMicrophone((short) 1);
                    break;
                case "音响":
                    meetingRoom.setStereo((short) 1);
                    break;
                case "演讲台":
                    meetingRoom.setPodium((short) 1);
                    break;
                case "照明设备":
                    meetingRoom.setLightequ((short) 1);
                    break;
                default:
                    break;
            }
        }
        // 调用录入会议室的方法
        int flag = confOrderService.modifyMeetingRoom(meetingRoom);
        return flag>0?JSONResult.ok("修改会议室成功"):JSONResult.errorMsg("对不起修改会议室失败!");
    }


    /**
     * 删除会议室
     * @return
     */
    @ApiOperation(value = "删除会议室")
    @PostMapping("/{roomid}/removeConfRoom")
    public JSONResult removeConfRoom (@PathVariable(required = true, name = "roomid")Integer roomid) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(roomid);
        int flag = confOrderService.removeConfRoom(meetingRoom);
        return flag>0?JSONResult.ok("删除会议室成功"):JSONResult.errorMsg("删除会议室失败!");
    }


    /**
     * 查询已经预约的会议
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询已经预约的会议")
    @PostMapping("/queryorderedconf")
    public JSONResult queryOrderedConf(@RequestBody @Valid PagedQueryForm<OrderedConf_c> param) {
        try {
            PageInfo<OrderConfView> pagedQueryForm = confOrderService.queryOrderedConfView(param);
            return JSONResult.ok(pagedQueryForm);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 查询待审核的会议
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "查询待审核的会议")
    @PostMapping("/queryvaliconf")
    public JSONResult queryvaliConf(@RequestBody @Valid PagedQueryForm<OrderedConf_c> param) {
        try {
            PageInfo<OrderConfView> pagedValidatingConf = confOrderService.queryValidatingConf(param);
            return JSONResult.ok(pagedValidatingConf);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 请求查看预约的会议详情
     *
     * @param confid
     * @return
     */
    @ApiOperation(value = "请求查看预约的会议详情")
    @PostMapping("/{confid}/queryorderdetail")
    public JSONResult queryConfInfo(@PathVariable(value = "confid", required = true) String confid) {
        return JSONResult.ok(confOrderService.queryRecordConfDetail(confid));
    }

    /**
     * 通过会议
     *
     * @param confid
     * @return
     */
    @ApiOperation(value = "通过会议")
    @PostMapping("/{confid}/passOrderConf")
    public JSONResult passOrderConf(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = confOrderService.passOrderConf(confid);
        return flag > 0 ? JSONResult.ok("通过会议成功") : JSONResult.errorMsg("通过会议失败");
    }

    /**
     * 不通过会议
     *
     * @param confid
     * @return
     */
    @ApiOperation(value = "不通过会议")
    @PostMapping("/{confid}/unpassOrderConf")
    public JSONResult unpassOrderConf(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = confOrderService.unpassOrderConf(confid);
        return flag > 0 ? JSONResult.ok("不通过会议成功") : JSONResult.errorMsg("不通过会议失败");
    }


    /**
     * 结束会议
     * @param confid
     * @return
     */
    @ApiOperation(value = "结束会议记录")
    @PostMapping("/{confid}/endRecConf")
    public JSONResult endRecConf(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = confOrderService.endRecordConf(confid);
        return flag > 0 ? JSONResult.ok("结束会议记录成功!") : JSONResult.errorMsg("操作失败!");
    }


    /**
     * 删除会议预约记录
     * @param confid
     * @return
     */
    @ApiOperation(value = "删除会议预约记录")
    @PostMapping("/{confid}/removeOrderConf")
    public JSONResult removeOrderConf(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = confOrderService.deleteOrderConference(confid);
        return flag > 0 ? JSONResult.ok("删除该记录成功!"): JSONResult.errorMsg("操作失败!");
    }


}
