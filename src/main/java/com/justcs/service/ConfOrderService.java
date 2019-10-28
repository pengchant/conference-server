package com.justcs.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.*;
import com.justcs.mapper.*;
import com.justcs.view.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.StringValueExp;
import java.util.List;


/**
 * 会议预定相关服务
 */
@Service
public class ConfOrderService {

    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private MeetingCollectMapper meetingCollectMapper;

    @Autowired
    private IssueLastmeetMapper issueLastmeetMapper;

    @Autowired
    private IssueCurmeetMapper issueCurmeetMapper;

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Autowired
    private ConferenceMapper conferenceMapper;

    @Autowired
    private ConfAttrMapper confAttrMapper;

    @Autowired
    private AttendesMapper attendesMapper;

    @Autowired
    private ConfMeetingRoomMapper confMeetingRoomMapper;

    /**
     * 分页查询会议室相关信息
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<MeetingRoomView> queryPagedMeetingRoom(PagedQueryForm<MeetingRoom_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<MeetingRoomView> meetingRoomPageInfo = new PageInfo<>(
                    meetingRoomMapper.queryAllMeetingRoom(
                            query.getSearch(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
            return meetingRoomPageInfo;
        }
        return null;
    }


    /**
     * 分页查询用户信息
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<UserSelectView> queryUserSelect(PagedQueryForm<UserSelectView_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<UserSelectView> userSelectViewPageInfo = new PageInfo<>(
                    userinfoMapper.selectUsrSelect(
                            query.getSearch().getDepid(),
                            query.getSearch().getPositionid(),
                            query.getSearch().getDutyid(),
                            query.getSearch().getUsrname()
                    )
            );
            return userSelectViewPageInfo;
        }
        return null;
    }


    /**
     * 查询待选择用户的信息
     *
     * @param param
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserSelectView> queryAllUsrSelect(UserSelectView_c param) {
        if (param != null) {
            return userinfoMapper.selectUsrSelect(param.getDepid(), param.getPositionid(), param.getDutyid(), param.getUsrname());
        }
        return null;
    }

    /**
     * 会议预约表单录入
     *
     * @param param
     * @return
     */
    @Transactional
    public boolean addConfOrderInfo(ConfOrderView param) {
        if (param != null) {
            // 1.录入会议议题
            MeetingCollect meetingCollect = param.getMeetingCollect();
            meetingCollectMapper.insertSelective(meetingCollect);

            // 2. 录入上次上次会议议题
            issueLastmeetMapper.batchInsert(param.getIssueLastmeetList(), meetingCollect.getId());

            // 3. 本次会议议题
            issueCurmeetMapper.batchInsert(param.getIssueCurmeetList(), meetingCollect.getId());

            // 4.建议解决方案
            suggestionMapper.batchInsert(param.getSuggestionList(), meetingCollect.getId());

            // 5.录入会议
            ConferenceWithBLOBs conference = param.getConference();
            conference.setMeetcollectid(meetingCollect.getId());
            conferenceMapper.insertSelective(conference);

            // 6.录入会议的属性
            confAttrMapper.batchInsert(param.getConfAttributesList(), conference.getId());

            // 7.列席人员
            attendesMapper.batchInsert(param.getAttendesList(), conference.getId());

            // 8.会议室占用表
            ConfMeetingRoom confMeetingRoom = param.getConfMeetingRoom();
            confMeetingRoom.setConfid(conference.getId());
            confMeetingRoomMapper.insertSelective(param.getConfMeetingRoom());

            return true;
        }
        return false;
    }


    /**
     * 新增会议室
     *
     * @param meetingRoom
     * @return
     */
    @Transactional
    public MeetingRoom addMeetingRoom(MeetingRoom meetingRoom) {
        if (meetingRoom != null) {
            meetingRoomMapper.insertSelective(meetingRoom);
            return meetingRoom;
        }
        return null;
    }

    /**
     * 修改会议室
     *
     * @param meetingRoom
     * @return
     */
    @Transactional
    public int modifyMeetingRoom(MeetingRoom meetingRoom) {
        if (meetingRoom != null) {
            return meetingRoomMapper.updateByPrimaryKeySelective(meetingRoom);
        }
        return 0;
    }

    /**
     * 删除会议室
     *
     * @param meetingRoom
     * @return
     */
    @Transactional
    public int removeConfRoom(MeetingRoom meetingRoom) {
        if (meetingRoom != null) {
            return meetingRoomMapper.deleteByPrimaryKey(meetingRoom.getId());
        }
        return 0;
    }


    /**
     * 查询已经预约的会议
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<OrderConfView> queryOrderedConfView(PagedQueryForm<OrderedConf_c> query) {
        if (query != null) {
            // 分页查询已经预约的会议
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<OrderConfView> orderedconfview = new PageInfo<>(
                    conferenceMapper.selectOrderdConfView(
                            query.getSearch().getWorkerid(),
                            query.getSearch().getConfstatus(),
                            query.getSearch().getConfname(),
                            query.getSearch().getStartime(),
                            query.getSearch().getEndtime(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
            return orderedconfview;
        }
        return null;
    }


    /**
     * 查询待审核的会议
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<OrderConfView> queryValidatingConf(PagedQueryForm<OrderedConf_c> query) {
        PageInfo<OrderConfView> result = null;
        if (query != null) {
            // 分页查询已经预约的会议
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<OrderConfView> orderedconfview = new PageInfo<>(
                    conferenceMapper.selectValidatingView(
                            query.getSearch().getWorkerid(),
                            query.getSearch().getConfname(),
                            query.getSearch().getStartime(),
                            query.getSearch().getEndtime(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
            return orderedconfview;
        }
        return result;
    }


    /**
     * 查询请求的会议预约信息
     *
     * @param workerid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RecordConfDetailView queryRecordConfDetail(String workerid) {
        if (workerid != null) {
            RecordConfDetailView recordConfDetailView = new RecordConfDetailView();
            // 查询会议基本信息
            BasicConfInfoView basicConfInfoView = conferenceMapper.selectbasicconf(workerid);
            recordConfDetailView.setBasicConfInfoView(basicConfInfoView);

            // 查询会议的列席人员
            List<ListAttendersView> attendersViewsList = conferenceMapper.selectAttendsList(workerid);
            recordConfDetailView.setAttendersViews(attendersViewsList);

            // 查询会议属性
            List<ConfAttributesListView> confAttributesList = conferenceMapper.selectConfAttrList(workerid);
            recordConfDetailView.setConfattrs(confAttributesList);

            // 查询会议采集表的基本信息
            ConfCollectBasicInfoView confCollectBasicInfoView = conferenceMapper.selectCollectView(workerid);
            recordConfDetailView.setConfCollectBasicInfoView(confCollectBasicInfoView);

            // 查询上次会议所提议题
            List<ConfLastIssueView> confLastIssueViewList = conferenceMapper.selectLastIssueList(workerid);
            recordConfDetailView.setConfLastIssueViewList(confLastIssueViewList);

            // 查询本次会议需要解决的问题
            List<ConfCurIssueView> confCurIssueViewList = conferenceMapper.selectCurIssueList(workerid);
            recordConfDetailView.setConfCurIssueViewsList(confCurIssueViewList);

            // 查询建议解决方案
            List<ConfSuggestionView> confSuggestionViewList = conferenceMapper.selectSuggesList(workerid);
            recordConfDetailView.setConfSuggestionViewList(confSuggestionViewList);

            return recordConfDetailView;
        }
        return null;
    }

    /**
     * 通过会议
     *
     * @return
     */
    @Transactional
    public int passOrderConf(Integer confid) {
        if (confid != null) {
            Conference conference = conferenceMapper.selectByPrimaryKey(confid);
            if (conference != null) {
                conference.setConfstatusid(2);
                return conferenceMapper.updateByPrimaryKey(conference);
            }
        }
        return 0;
    }

    /**
     * 不通过会议
     *
     * @return
     */
    @Transactional
    public int unpassOrderConf(Integer confid) {
        if (confid != null) {
            Conference conference = conferenceMapper.selectByPrimaryKey(confid);
            if (conference != null) {
                conference.setConfstatusid(101);
                return conferenceMapper.updateByPrimaryKey(conference);
            }
        }
        return 0;
    }


    /**
     * 结束录入会议记录
     *
     * @param confid
     * @return
     */
    @Transactional
    public int endRecordConf(Integer confid) {
        if (confid != null) {
            Conference conference = conferenceMapper.selectByPrimaryKey(confid);
            if (conference != null) {
                conference.setConfstatusid(4);
                return conferenceMapper.updateByPrimaryKey(conference);
            }
        }
        return 0;
    }

    /**
     * 查询用户本部门下的所有的用户
     *
     * @param accid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CurDepUsrView> queryCurDepUsrViews(Integer accid) {
        if (accid != null) {
            return userinfoMapper.selectCurDepUsr(String.valueOf(accid));
        }
        return null;
    }


    /**
     * 删除会议预约记录
     *
     * @param confid
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOrderConference(Integer confid) {
        if (confid != null) {
            return conferenceMapper.deleteByPrimaryKey(confid);
        }
        return 0;
    }


    /**
     * 标记会议正在进行中
     *
     * @param confid
     * @return
     */
    @Transactional
    public int updateConfIn(Integer confid) {
        if (confid != null) {
            ConferenceWithBLOBs conference = conferenceMapper.selectByPrimaryKey(confid);
            conference.setConfstatusid(3); // 设置进行中
            return conferenceMapper.updateByPrimaryKeySelective(conference);
        }
        return 0;
    }

}
