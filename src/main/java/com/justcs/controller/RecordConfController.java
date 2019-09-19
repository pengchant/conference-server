package com.justcs.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.DynamicTableRenderPolicy;
import com.deepoove.poi.policy.MiniTableRenderPolicy;
import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.*;
import com.justcs.mapper.ConfTitleMapper;
import com.justcs.service.RecordConfInfoService;
import com.justcs.utils.FileUtil;
import com.justcs.utils.JSONResult;
import com.justcs.utils.RandomUtils;
import com.justcs.view.*;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(value = "会议记录内容", description = "记录会议的详细内容")
@RestController
@RequestMapping("/record")
public class RecordConfController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;


    @Autowired
    private RecordConfInfoService recordConfInfoService;

    @Autowired
    private ConfTitleMapper confTitleMapper;

    /**
     * 查询会议基本信息
     *
     * @param workerid
     * @return
     */
    @PostMapping("/{workerid}/loadconf")
    @ApiOperation(value = "查询会议的基本信息")
    public JSONResult queryConfInfo(@PathVariable(value = "workerid", required = true) String workerid) {
        return JSONResult.ok(recordConfInfoService.queryConfDetail(workerid));
    }

    /**
     * 查询当前会议的本次会议需要解决的问题
     *
     * @param workerid
     * @return
     */
    @PostMapping("/{workerid}/loadCurIssue")
    public JSONResult queryCurISSUE(@PathVariable(value = "workerid", required = true) String workerid) {
        return JSONResult.ok(recordConfInfoService.queryconfCurIssue(workerid));
    }

    /**
     * 下载会议采集表模板
     *
     * @param request
     * @param response
     * @param confid
     * @return
     */
    @RequestMapping(value = "/{confid}/exportconfcoll", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "下载会议采集表模板")
    public void exportconfcoll(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "confid", required = true) String confid) throws IOException, ParseException {
        // 先获取数据
        ModelCollectInfoView result = recordConfInfoService.queryModelCollect(confid);
        if (result != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
            Map<String, Object> resource = new HashMap<>();
            resource.put("confname", result.getBasicConfInfoView().getConfname());
            resource.put("years", result.getConfCollectBasicInfoView().getTermyear());
            resource.put("semester", result.getBasicConfInfoView().getSemestername());
            resource.put("weeksno", result.getConfCollectBasicInfoView().getMeetweeks());
            resource.put("leadername", result.getConfCollectBasicInfoView().getCollegeleader());
            String timestr = result.getConfCollectBasicInfoView().getColltime();
            resource.put("cfdatetime", sdf2.format(sdf.parse(timestr)));
            // 上次会议
            List<RowRenderData> issueLastmeetList = new ArrayList<>();
            int index = 0;
            for (ConfLastIssueView l : result.getConfLastIssueViewList()) {
                index++;
                RowRenderData rowdata = RowRenderData.build(new TextRenderData(String.valueOf(index)), new TextRenderData(
                        l.getMaincontent(),
                        new Style(
                                "华文仿宋",
                                10
                        )
                ));
                issueLastmeetList.add(rowdata);
            }
            // 本次会议
            index = 0;
            List<RowRenderData> issueCurmeetList = new ArrayList<>();
            for (ConfCurIssueView c : result.getConfCurIssueViewList()) {
                index++;
                RowRenderData rowdata = RowRenderData.build(new TextRenderData(String.valueOf(index)), new TextRenderData(
                        c.getMainconent(),
                        new Style(
                                "华文仿宋",
                                10
                        )
                ));
                issueCurmeetList.add(rowdata);
            }
            // 建议解决方案
            index = 0;
            List<RowRenderData> suggestionList = new ArrayList<>();
            for (ConfSuggestionView s : result.getConfSuggestionViewList()) {
                index++;
                RowRenderData rowdata = RowRenderData.build(new TextRenderData(String.valueOf(index)), new TextRenderData(
                        s.getMaincontent(),
                        new Style(
                                "华文仿宋",
                                10
                        )
                ));
                suggestionList.add(rowdata);
            }
            DetailTable detailTable = new DetailTable();
            detailTable.setIssueLast(issueLastmeetList);
            detailTable.setIssuecur(issueCurmeetList);
            detailTable.setSuggestion(suggestionList);
            resource.put("detail_table", detailTable);
            // 这里渲染模板来发送给客户端下载
            Configure config = Configure.newBuilder().customPolicy("detail_table", new DetailTablePolicy()).build();

            String filePath = ResourceUtils.getURL("classpath:").getPath() + "template/template.docx" ;
            logger.info("---->打包文件地址:" + filePath + ".");

            XWPFTemplate template = XWPFTemplate.compile(
                    filePath,
                    config).render(resource);

            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=\""
                    + URLEncoder.encode(result.getBasicConfInfoView().getConfname() + ".docx", "UTF-8") + "\"");
            OutputStream outputStream = response.getOutputStream();
            template.write(outputStream);
            outputStream.flush();
            outputStream.close();
            template.close();
        }
    }


    /**
     * 查询参会人员的状态
     *
     * @return
     */
    @PostMapping("/{confid}/getAttendursts")
    public JSONResult getAttendursts(@PathVariable(value = "confid", required = true) String confid) {
        List<ListAttendersView> result = recordConfInfoService.queryAttenders(confid);
        if (result != null) {
            return JSONResult.ok(result);
        }
        return JSONResult.errorMsg("查询失败");
    }


    /**
     * 添加会议议题
     *
     * @return
     */
    @PostMapping("/addSpeechItem")
    public JSONResult addSpeechItem(@RequestBody @Valid AddMeetingCollectForm addMeetingCollectForm) {
        ConfTitle confTitle = new ConfTitle();
        confTitle.setConftitlecnt(addMeetingCollectForm.getSpeechitem());
        confTitle.setConfid(addMeetingCollectForm.getConfid());
        ConfTitle result = recordConfInfoService.addConfSpeechItem(confTitle);
        return result != null ? JSONResult.ok(result) : JSONResult.errorMsg("对不起添加议题失败!");
    }

    /**
     * 添加当前会议的新议题(临时添加)
     *
     * @param curIssueForm
     * @return
     */
    @PostMapping("/addNewCurContTitle")
    public JSONResult addNewCurContTitle(@RequestBody @Valid CurIssueForm curIssueForm) {
        IssueCurmeet issueCurmeet = new IssueCurmeet();
        issueCurmeet.setMeetcollid(Integer.valueOf(curIssueForm.getConftitleid()));
        issueCurmeet.setMainconent(curIssueForm.getContent());
        IssueCurmeet result = recordConfInfoService.addIssueCurmeet(issueCurmeet);
        // todo：向conftitle添加数据

        return result != null ? JSONResult.ok(result) : JSONResult.errorMsg("对不起添加新议题失败!");
    }


    /**
     * 添加用户发言
     *
     * @return
     */
    @PostMapping("/addUsrSepach")
    public JSONResult addUsrSpeach(@RequestBody @Valid UsrSpeachForm usrSpeachForm) {
        ConfTitle confTitle = new ConfTitle();
        ConfTitleRecord confTitleRecord = new ConfTitleRecord();

        confTitle.setConfid(Integer.valueOf(usrSpeachForm.getConfid()));
        confTitle.setConftitlecnt(usrSpeachForm.getConftitle());

        confTitleRecord.setSpeakerid(usrSpeachForm.getSpeakerid());
        confTitleRecord.setSpeakername(usrSpeachForm.getSpeakername());
        confTitleRecord.setSpeaking(usrSpeachForm.getContent());
        confTitleRecord.setSpeaktime(new Date(System.currentTimeMillis()));
        ConfTitleRecord result = recordConfInfoService.recordUsrSpeach(confTitle, confTitleRecord);
        return result != null ? JSONResult.ok(result) : JSONResult.errorMsg("对不起操作失败!");
    }

    /**
     * 修改用户发言内容
     *
     * @return
     */
    @PostMapping("/modifyUsrSpeach")
    public JSONResult modifyUsrSpeach(@RequestBody Map<String, String> usrspform) {
        String recorid = usrspform.get("recorid");
        String content = usrspform.get("content");
        if (StringUtils.isNotBlank(recorid) && StringUtils.isNotBlank(content)) {
            try {
                ConfTitleRecord confTitleRecord = new ConfTitleRecord();
                confTitleRecord.setId(Integer.valueOf(recorid));
                confTitleRecord.setSpeaking(content);
                confTitleRecord.setSpeaktime(new Date(System.currentTimeMillis()));
                // 修改会议议题发言表内容
                int flag = recordConfInfoService.modifyUsrSpeach(confTitleRecord);
                return flag > 0 ? JSONResult.ok() : JSONResult.errorMsg("对不起修改发言内容失败!");
            } catch (NumberFormatException e) {
                logger.error("产生异常");
                return JSONResult.errorMsg("修改发言内容失败!");

            }
        }
        return JSONResult.errorMsg("对不起您的字段提交不完整!");

    }


    /**
     * 上传用户录音
     *
     * @param voice
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @ApiOperation(value = "上传用户录音", notes = "上传用户录音功能")
    @PostMapping("/{confrecid}/uploadUsrVoice")
    @ResponseBody
    public JSONResult uploadUsrVoice(@RequestParam("voice") MultipartFile voice,
                                     @PathVariable(value = "confrecid", required = true) String confrecid) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(RandomUtils.getRandomStr(20));
        // 获得提交的文件名
        String fileName = stringBuilder.append(".wav").toString();
        // 获取文件输入流
        InputStream ins = voice.getInputStream();
        // 获取文件类型
        String contentType = voice.getContentType();
        // 将文件存储到mongodb中
        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
        logger.info("objectId:" + objectId, ",confrecorid:" + confrecid);
        // 保存到数据中
        VoiceRecord result = recordConfInfoService.uploadUsrVoice(confrecid, String.valueOf(objectId));
        // 释放流
        ins.close();
        return result != null ? JSONResult.ok(result) : JSONResult.errorMsg("对不起上传失败");
    }


    /**
     * 删除用户的发言：如果有，就在数据库中删除
     *
     * @return
     */
    @PostMapping("/{speachid}/removeUsrSpeach")
    public JSONResult removeUsrSpeach(@PathVariable(name = "speachid", required = true) String speachid) {
        ConfTitleRecord confTitleRecord = new ConfTitleRecord();
        confTitleRecord.setId(Integer.valueOf(speachid));
        int affected = recordConfInfoService.removeUsrSpeach(confTitleRecord);
        return affected > 0 ? JSONResult.ok("删除用户发言成功!") : JSONResult.errorMsg("删除用户发言失败");
    }


    /**
     * 删除用户的录音
     */
    @PostMapping("/{voiceRecId}/deleteUsrRecords")
    public JSONResult deleteUsrRecords(@PathVariable(value = "voiceRecId", required = true) Integer voiceRecId) {
        VoiceRecord result = recordConfInfoService.removeAudioRecord(voiceRecId);
        // 删除mongodb中的文件
        logger.info("准备删除monggodb文件：_id" + result.getVoiceurl());
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(result.getVoiceurl())));
        return result != null ? JSONResult.ok("删除录音成功!") : JSONResult.errorMsg("删除失败，请稍后重试!");
    }

    /**
     * 保存会议结论
     *
     * @return
     */
    @PostMapping("/saveConfConclusion")
    public JSONResult saveConfConclusion(@RequestBody @Valid SubConclusionForm subConclusionForm) {
        ConferenceWithBLOBs conference = new ConferenceWithBLOBs();
        conference.setId(Integer.valueOf(subConclusionForm.getConfid()));
        conference.setConclusion(subConclusionForm.getConsolusion());
        // 更新结论
        int flag = recordConfInfoService.modifyConfConclusion(conference);
        return flag > 0 ? JSONResult.ok("保存会议结论成功!") : JSONResult.errorMsg("对不起保存会议结论失败!");
    }


    /**
     * 获取音频
     *
     * @param fileId
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/getUsrVoice", method = {RequestMethod.GET, RequestMethod.POST})
    public void downloadFile(@RequestParam(name = "file_id") String fileId,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        logger.info("准备下载文件....");
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile == null) {
            return;
        }

        String fileName = gridFSFile.getFilename().replace(",", "");
        String contentType = gridFSFile.getMetadata().get("_contentType").toString();

        // 通知浏览器进行文件下载
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        GridFsResource resource = new GridFsResource(gridFSFile, gridFSDownloadStream);

        OutputStream outputStream = response.getOutputStream();
        InputStream inputStream = resource.getInputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }


    /**
     * 修改主持人
     *
     * @param params
     * @return
     */
    @PostMapping("/modifyHolder")
    public JSONResult modifyHolder(@RequestBody Map<String, String> params) {
        String confid = params.get("confid");
        String holderid = params.get("holderid");
        if (StringUtils.isNotBlank(confid)
                && StringUtils.isNotBlank(holderid)
        ) {
            try {
                int flag = 0;
                ConferenceWithBLOBs conferenceWithBLOBs = new ConferenceWithBLOBs();
                conferenceWithBLOBs.setId(Integer.valueOf(confid));
                conferenceWithBLOBs.setHosterid(holderid);
                flag = recordConfInfoService.modifyConfHolders(conferenceWithBLOBs);
                return flag == 0 ? JSONResult.errorMsg("修改失败!") : JSONResult.ok();
            } catch (NumberFormatException e) {
                logger.error("修改主持人失败!");
                return JSONResult.errorMsg("对不起修改失败!");
            }
        } else {
            return JSONResult.errorMsg("对不起，修改主持人失败!");
        }
    }


    /**
     * 查询审核中的会议
     *
     * @param param
     * @return
     */
    @PostMapping("/getvaliRecord")
    public JSONResult getvaliRecord(@RequestBody @Valid PagedQueryForm<OrderedConf_c> param) {
        try {
            PageInfo<OrderConfView> result = recordConfInfoService.queryValidatingRecord(param, "0");
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 分页查询我需要审核的会议记录
     * @param param
     * @return
     */
    @PostMapping("/getmyvaliRecord")
    public JSONResult getmyvaliRecord(@RequestBody @Valid PagedQueryForm<OrderedConf_c> param) {
        try {
            PageInfo<OrderConfView> result = recordConfInfoService.queryValidatingRecord(param, "1");
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }




    /**
     * 查询已经验证过的会议
     *
     * @param param
     * @return
     */
    @PostMapping("/getpassedRecord")
    public JSONResult getpassedRecord(@RequestBody @Valid PagedQueryForm<OrderedConf_c> param) {
        try {
            PageInfo<OrderConfView> result = recordConfInfoService.queryValiedRecord(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 会议归档
     *
     * @param confid
     * @return
     */
    @PostMapping("/{confid}/passRecord")
    public JSONResult passRecord(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = recordConfInfoService.passRecordConf(confid);
        return flag > 0 ? JSONResult.ok("会议材料已经归档") : JSONResult.errorMsg("操作失败!");
    }

    /**
     * 会议不归档
     *
     * @param confid
     * @return
     */
    @PostMapping("{confid}/unpassRecord")
    public JSONResult unpassRecord(@PathVariable(value = "confid", required = true) Integer confid) {
        int flag = recordConfInfoService.unpassRecordConf(confid);
        return flag > 0 ? JSONResult.ok("会议材料不通过!") : JSONResult.errorMsg("操作失败!");
    }

    /**
     * 导出会议记录内容
     *
     * @param confid
     * @param request
     * @param response
     */
    @RequestMapping(value = "/{confid}/exportconfrecord", method = {RequestMethod.GET, RequestMethod.POST})
    public void downloadConfRecordFile(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "confid", required = true) String confid) throws IOException {
        // 先获取数据
        RecordConfDetailView result = recordConfInfoService.queryRecordConfDetail(confid);
        if (result != null) {
            Map<String, Object> resource = new HashMap<>();
            BasicConfInfoView basicConfInfoView = result.getBasicConfInfoView();
            // 会议名称
            String confname = basicConfInfoView.getConfname();
            resource.put("confname", confname);
            // 获取学期名称
            String semestername = basicConfInfoView.getSemestername();
            resource.put("semester", semestername);
            // 会议级别
            String conflevel = basicConfInfoView.getLevelname();
            resource.put("conflevel", conflevel);

            // 主持人
            String holder = basicConfInfoView.getHoster();
            resource.put("holder", holder);

            // 录入人
            String recorder = basicConfInfoView.getRecorder();
            resource.put("recorder", recorder);

            // 会议地点
            String address = basicConfInfoView.getRoomname();
            resource.put("address", address);

            // 开始
            String starttime = basicConfInfoView.getStarttime();
            resource.put("starttime", starttime);

            // 结束
            String endtime = basicConfInfoView.getEndtime();
            resource.put("endtime", endtime);

            // 会议属性
            List<ConfAttributesListView> attrs = result.getConfattrs();
            StringBuilder strbuild = new StringBuilder("");
            for (ConfAttributesListView e : attrs) {
                strbuild.append(" " + e.getAttrdes());
            }
            String confattrs = strbuild.toString();
            resource.put("confattrs", confattrs);

            // 参会人员
            strbuild.delete(0, strbuild.length());
            List<ListAttendersView> listAttendersViews = result.getAttendersViews();
            for (ListAttendersView e : listAttendersViews) {
                strbuild.append(" " + e.getUsrname());
                if (!StringUtils.equals(e.getHasattend(), "1")) {
                    strbuild.append("(缺席)");
                }
            }
            String attenders = strbuild.toString();
            resource.put("attenders", attenders);

            // 会议记录
            List<ConfRecVoicDetailView> confRecVoicDetailViews = result.getConfRecVoicDetailViewList();
            strbuild.delete(0, strbuild.length());
            for(ConfRecVoicDetailView element: confRecVoicDetailViews) {
                strbuild.append("【"+ element.getTitlename()+"】");
                strbuild.append("," + element.getSpeakername());
                strbuild.append(":");
                strbuild.append(element.getSpeaking());
                strbuild.append("/r/n");
            }
            resource.put("confrecords", strbuild.toString());

            // 会议结论
            String conclusion =result.getBasicConfInfoView().getConclusion();
            resource.put("conclusions", FileUtil.Html2Text(conclusion));

            // 这里渲染模板来发送给客户端下载
            XWPFTemplate template = XWPFTemplate.compile(
                    this.getClass().getResource("/template/material-template.docx"
                    ).getPath()).render(resource);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;filename=\""
                    + URLEncoder.encode(result.getBasicConfInfoView().getConfname() + ".docx", "UTF-8") + "\"");
            OutputStream outputStream = response.getOutputStream();
            template.write(outputStream);
            outputStream.flush();
            outputStream.close();
            template.close();
        }


    }


    /**
     * 更新会议议题结论
     * @param conclusionView
     * @return
     */
    @PostMapping(value = "/modifyConclusion")
    public JSONResult modifyConfConclusion(@RequestBody @Valid UpdateConclusionView conclusionView) {
        ConfTitle confTitle = new ConfTitle();
        confTitle.setId(Integer.valueOf(conclusionView.getConftitleid()));
        confTitle.setConclusion(conclusionView.getConclusion());
        int flag = recordConfInfoService.updateConfTitleCon(confTitle);
        return flag > 0 ? JSONResult.ok("修改议题结论成功"): JSONResult.errorMsg("修改议题结论失败!");
    }

    /**
     * 查询会议的议题
     * @return
     */
    @PostMapping(value = "/{confid}/queryConftitles")
    public JSONResult queryConftitles(@PathVariable(required = true) String confid) {
        return JSONResult.ok(confTitleMapper.selectCfTitlesByConfId(confid));
    }


    /**
     * 直接开会
     * @param directConfForm
     * @return
     */
    @PostMapping(value = "/directrecord")
    public JSONResult directrecord(@RequestBody @Valid DirectConfForm directConfForm) throws ParseException {
        try {
            Date current = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateParser = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateParser.format(current);
            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm");

            // 封装开会实体
            DirectConfWithBLOBs directConfWithBLOBs = new DirectConfWithBLOBs();
            directConfWithBLOBs.setConfname(directConfForm.getConfname());
            directConfWithBLOBs.setSemesterid(directConfForm.getSemester());
            directConfWithBLOBs.setConfattrs(StringUtils.join(directConfForm.getConfattr(), ","));
            directConfWithBLOBs.setConftypeid(directConfForm.getConftype());
            directConfWithBLOBs.setHosterid(directConfForm.getHosterid());
            directConfWithBLOBs.setRecorderid(directConfForm.getRecorderid());
            directConfWithBLOBs.setConfaddress(directConfForm.getConfaddress());
            directConfWithBLOBs.setConfstarttime(
                    simpleDateFormat.parse(dateStr + " " + directConfForm.getStarttime())
            );
            directConfWithBLOBs.setConfendtime(
                    simpleDateFormat.parse(dateStr + " " + directConfForm.getEndtime())
            );
            directConfWithBLOBs.setAttenders(StringUtils.join(directConfForm.getAttenders(), ","));
            directConfWithBLOBs.setMaincontent(directConfForm.getMaincontent());
            directConfWithBLOBs.setConclusion(directConfForm.getConclusion());
            // 设置会议状态
            directConfWithBLOBs.setConfstatus("4"); // 已结束 会议结束，录入人员提交过程材料
            // 提交时间
            directConfWithBLOBs.setSubtime(current);
            // TODO:录入临时会议内容
            int flag = recordConfInfoService.addDirectConf(directConfWithBLOBs);
            return flag > 0? JSONResult.ok("录入会议成功") : JSONResult.errorMsg("对不起，录入会议内容失败，请稍后重试!");
        } catch (ParseException e) {
             logger.error("录入直接会议失败," + e.getMessage());
        }
        return JSONResult.errorMsg("对不起，录入会议记录失败，请稍后重试!");
    }


    /**
     * 获取会议的编号
     * @param confid
     * @return
     */
    @PostMapping(value = "/{confid}/querydirectconf")
    public JSONResult queryDirectConf(@PathVariable(value = "confid") String confid) {
        DirectConfDetailView records = recordConfInfoService.queryDirectConfRecord(confid);
        return records!=null?JSONResult.ok(records):JSONResult.errorMsg("对不起查询会议详情失败!");
    }

    /**
     * 封装的表格具体内容的实体
     */
    class DetailTable {
        List<RowRenderData> issueLast;

        List<RowRenderData> issuecur;

        List<RowRenderData> suggestion;

        public List<RowRenderData> getIssueLast() {
            return issueLast;
        }

        public void setIssueLast(List<RowRenderData> issueLast) {
            this.issueLast = issueLast;
        }

        public List<RowRenderData> getIssuecur() {
            return issuecur;
        }

        public void setIssuecur(List<RowRenderData> issuecur) {
            this.issuecur = issuecur;
        }

        public List<RowRenderData> getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(List<RowRenderData> suggestion) {
            this.suggestion = suggestion;
        }
    }

    /**
     * 导出会议预约
     */
    class DetailTablePolicy extends DynamicTableRenderPolicy {

        private static final int lastissue = 2;

        @Override
        public void render(XWPFTable xwpfTable, Object data) {
            if (null == data) return;
            DetailTable detailData = (DetailTable) data;

            List<RowRenderData> issueLastmeetList = (List<RowRenderData>) detailData.getIssueLast();
            List<RowRenderData> issueCurmeets = (List<RowRenderData>) detailData.getIssuecur();
            List<RowRenderData> suggestionList = (List<RowRenderData>) detailData.getSuggestion();
            // 上次
            if (issueLastmeetList != null && issueLastmeetList.size() > 0) {
                xwpfTable.removeRow(lastissue);
                for (int i = issueLastmeetList.size() - 1; i >= 0; i--) {
                    XWPFTableRow insertNewTableRow = xwpfTable.insertNewTableRow(lastissue);
                    for (int j = 0; j < 2; j++) {
                        insertNewTableRow.createCell();
                    }
                    // 渲染单行获取明细数据
                    MiniTableRenderPolicy.renderRow(xwpfTable, lastissue, issueLastmeetList.get(i));
                }
            }

            // 本次
            if (issueCurmeets != null && issueCurmeets.size() > 0) {
                int currowindex = issueLastmeetList.size() + 3;
                xwpfTable.removeRow(currowindex);
                for (int i = issueCurmeets.size() - 1; i >= 0; i--) {
                    XWPFTableRow insertNewTableRow = xwpfTable.insertNewTableRow(currowindex);
                    for (int j = 0; j < 2; j++) {
                        insertNewTableRow.createCell();
                    }
                    // 渲染单行获取明细数据
                    MiniTableRenderPolicy.renderRow(xwpfTable, currowindex, issueCurmeets.get(i));
                }
            }

            // 建议
            if (suggestionList != null && suggestionList.size() > 0) {
                int sugindex = issueLastmeetList.size() + issueCurmeets.size() + 4;
                xwpfTable.removeRow(sugindex);
                for (int i = suggestionList.size() - 1; i >= 0; i--) {
                    XWPFTableRow insertNewTableRow = xwpfTable.insertNewTableRow(sugindex);
                    for (int j = 0; j < 2; j++) {
                        insertNewTableRow.createCell();
                    }
                    // 渲染单行获取明细数据
                    MiniTableRenderPolicy.renderRow(xwpfTable, sugindex, suggestionList.get(i));
                }
            }
        }
    }

}