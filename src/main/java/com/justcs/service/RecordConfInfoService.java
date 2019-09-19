package com.justcs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.OrderedConf_c;
import com.justcs.form.PagedQueryForm;
import com.justcs.mapper.*;
import com.justcs.view.*;
import com.mongodb.WriteResult;
import com.mongodb.client.gridfs.GridFSBucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 记录会议服务
 */
@Service
public class RecordConfInfoService {

    private static final Logger logger = LoggerFactory.getLogger(RecordConfInfoService.class);

    @Resource
    private ConferenceMapper conferenceMapper;

    @Resource
    private ConfTitleMapper confTitleMapper;

    @Resource
    private MeetingRoomMapper meetingRoomMapper;

    @Resource
    private ConfTitleRecordMapper confTitleRecordMapper;

    @Resource
    private VoiceRecordMapper voiceRecordMapper;


    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Resource
    private IssueCurmeetMapper issueCurmeetMapper;

    @Resource
    private DirectConfMapper directConfMapper;


    /**
     * 查询待开始会议的详细信息
     *
     * @param workerid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RecordConfDetailView queryConfDetail(String workerid) {
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

            // 查询会话记录(所有议题->所有会话->语音列表)
            List<ConfRecVoicDetailView> confRecVoicDetailViews = conferenceMapper.selectConfRecVoic(workerid);
            recordConfDetailView.setConfRecVoicDetailViewList(confRecVoicDetailViews);

            // 查询建议解决方案
            List<ConfSuggestionView> confSuggestionViewList = conferenceMapper.selectSuggesList(workerid);
            recordConfDetailView.setConfSuggestionViewList(confSuggestionViewList);

            // TODO: 查询conftitle的详细信息
            List<ConfTitle> confTitles = confTitleMapper.selectCfTitlesByConfId(String.valueOf(basicConfInfoView.getConfid()));
            recordConfDetailView.setConfTitleViewList(confTitles);

            return recordConfDetailView;
        }
        return null;
    }

    /**
     * 查询会议记录材料
     *
     * @param workerid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public RecordConfDetailView queryRecordConfDetail(String workerid) {
        if (workerid != null) {
            RecordConfDetailView recordMaterial = new RecordConfDetailView();
            // 查询会议基本信息
            BasicConfInfoView basicConfInfoView = conferenceMapper.selectbasicconf(workerid);
            recordMaterial.setBasicConfInfoView(basicConfInfoView);

            // 查询会议的列席人员
            List<ListAttendersView> attendersViewsList = conferenceMapper.selectAttendsList(workerid);
            recordMaterial.setAttendersViews(attendersViewsList);

            // 查询会议属性
            List<ConfAttributesListView> confAttributesList = conferenceMapper.selectConfAttrList(workerid);
            recordMaterial.setConfattrs(confAttributesList);

            // 查询会话记录(所有议题->所有会话->语音列表)
            List<ConfRecVoicDetailView> confRecVoicDetailViews = conferenceMapper.selectConfRecVoic(workerid);
            recordMaterial.setConfRecVoicDetailViewList(confRecVoicDetailViews);

            return recordMaterial;
        }
        return null;
    }


    /**
     * 查询本次会议需要解决的问题
     *
     * @param workerid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ConfCurIssueView> queryconfCurIssue(String workerid) {
        return conferenceMapper.selectCurIssueList(workerid);
    }

    /**
     * 查询采集表的信息
     *
     * @param workerid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public ModelCollectInfoView queryModelCollect(String workerid) {
        if (workerid != null) {
            ModelCollectInfoView modelCollectInfoView = new ModelCollectInfoView();
            // 查询会议基本信息
            BasicConfInfoView basicConfInfoView = conferenceMapper.selectbasicconf(workerid);
            modelCollectInfoView.setBasicConfInfoView(basicConfInfoView);

            // 会议议题搜集的基本信息
            ConfCollectBasicInfoView confCollectBasicInfoView = conferenceMapper.selectCollectView(workerid);
            modelCollectInfoView.setConfCollectBasicInfoView(confCollectBasicInfoView);

            // 查询上次会议所提议题
            List<ConfLastIssueView> confLastIssueViewList = conferenceMapper.selectLastIssueList(workerid);
            modelCollectInfoView.setConfLastIssueViewList(confLastIssueViewList);

            // 查询本次会议需要解决的问题
            List<ConfCurIssueView> confCurIssueViewList = conferenceMapper.selectCurIssueList(workerid);
            modelCollectInfoView.setConfCurIssueViewList(confCurIssueViewList);

            // 查询建议解决方案
            List<ConfSuggestionView> confSuggestionViewList = conferenceMapper.selectSuggesList(workerid);
            modelCollectInfoView.setConfSuggestionViewList(confSuggestionViewList);

            return modelCollectInfoView;
        }
        return null;
    }

    /**
     * 查询列席人员
     *
     * @param confid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ListAttendersView> queryAttenders(String confid) {
        if (confid != null) {
            return conferenceMapper.selectAttendsList(confid);
        }
        return null;
    }


    /**
     * 添加会议议题
     *
     * @param param
     * @return
     */
    @Transactional
    public ConfTitle addConfSpeechItem(ConfTitle param) {
        if (param != null) {
            confTitleMapper.insertSelective(param);
            return param;
        }
        return null;
    }

    /**
     * 添加当前会议内容
     *
     * @param issueCurmeet
     * @return
     */
    @Transactional
    public IssueCurmeet addIssueCurmeet(IssueCurmeet issueCurmeet) {
        if (issueCurmeet != null) {
            issueCurmeetMapper.insertSelective(issueCurmeet);
            return issueCurmeet;
        }
        return null;
    }

    /**
     * 添加发言人发言记录
     * 1.首先查询该议题有没有被录入
     * 1a.如果被录入继续
     * 1b.如果没有被录入则录入会议议题，继续
     * 2.获取到conftitle的id
     * 3.录入会议发言记录
     * 4.返回
     *
     * @param confTitle
     * @param record
     * @return
     */
    @Transactional
    public ConfTitleRecord recordUsrSpeach(ConfTitle confTitle, ConfTitleRecord record) {
        ConfTitleRecord confTitleRecord = null;
        if (confTitle != null && record != null) {
            // 1.查询有没有录入议题
            ConfTitle savedtitle = confTitleMapper.selectContians(String.valueOf(confTitle.getConfid()),
                    confTitle.getConftitlecnt());
            if (savedtitle == null) {
                // 录入议题
                confTitleMapper.insertSelective(confTitle);
            } else {
                confTitle = savedtitle;
            }
            // 2.录入会议发言记录
            record.setConftitleid(confTitle.getId());
            confTitleRecordMapper.insertSelective(record);
            confTitleRecord = record;
        }
        return confTitleRecord;
    }


    /**
     * 保存用户的上传的文件
     *
     * @param confrecid
     * @param blobid
     * @return
     */
    @Transactional
    public VoiceRecord uploadUsrVoice(String confrecid, String blobid) {
        if (confrecid != null) {
            VoiceRecord result = new VoiceRecord();
            result.setVoiceurl(blobid);
            result.setConftitlerecordid(Integer.valueOf(confrecid));
            result.setVoicedes(String.valueOf(new Date(System.currentTimeMillis())));
            voiceRecordMapper.insertSelective(result);
            return result;
        }
        return null;
    }

    /**
     * 移除用户的记录
     *
     * @param record
     * @return
     */
    @Transactional
    public int removeUsrSpeach(ConfTitleRecord record) {
        int affected = 0;
        if (record != null) {
            // 查询该用户发言记录下面的所有录音文件
            List<VoiceRecord> voiceRecords = voiceRecordMapper.queryAllVoice(String.valueOf(record.getId()));
            // 删除mongodb中的录音文件
            int len = 0;
            if (voiceRecords != null && (len = voiceRecords.size()) > 0) {
                String[] filesId = new String[len];
                for (int i = 0; i < len; i++) {
                    filesId[i] = voiceRecords.get(i).getVoiceurl(); // 获取其中的id
                }
                Object[] filesMongoId = filesId;
                Query query = Query.query(Criteria.where("_id").in(filesMongoId));
                gridFsTemplate.delete(query); // 批量删除mongodb文件
            }
            // 批量删除记录
            affected = confTitleRecordMapper.deleteByPrimaryKey(record.getId());
        }
        return affected;
    }

    /**
     * 删除录音，返回原始数据
     *
     * @param audioRecid
     * @return
     */
    @Transactional
    public VoiceRecord removeAudioRecord(Integer audioRecid) {
        VoiceRecord result = null;
        if (audioRecid != null) {
            // 查询录音
            result = voiceRecordMapper.selectByPrimaryKey(audioRecid);
            if (result != null) {
                // 执行删除操作
                int flag = voiceRecordMapper.deleteByPrimaryKey(audioRecid);
                return flag > 0 ? result : null;
            }
        }
        return result;
    }


    /**
     * 修改用户发言内容
     *
     * @param record
     * @return
     */
    @Transactional
    public int modifyUsrSpeach(ConfTitleRecord record) {
        int flag = 0;
        flag = confTitleRecordMapper.updateByPrimaryKeyWithBLOBs(record);
        return flag;
    }

    /**
     * 更新conference结论数据
     *
     * @param conference
     * @return
     */
    @Transactional
    public int modifyConfConclusion(ConferenceWithBLOBs conference) {
        int flag = 0;
        if (conference != null) {
            flag = conferenceMapper.updateByPrimaryKeySelective(conference);
        }
        return flag;
    }

    /**
     * 修改主持人
     *
     * @param conference
     * @return
     */
    @Transactional
    public int modifyConfHolders(ConferenceWithBLOBs conference) {
        if (conference != null) {
            int affected = conferenceMapper.updateByPrimaryKeySelective(conference);
            return affected;
        }
        return 0;
    }

    /**
     * 查询待审核的会议材料
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<OrderConfView> queryValidatingRecord(PagedQueryForm<OrderedConf_c> query, String flag) {
        PageInfo<OrderConfView> result = null;
        if (query != null) {
            // 分页查询已经预约的会议
            PageHelper.startPage(query.getPage(), query.getPagesize());
            if(flag == "1") {
                result = new PageInfo<>(
                        conferenceMapper.selectMyConfRecordValidating(
                                query.getSearch().getWorkerid(),
                                query.getSearch().getConfname(),
                                query.getSearch().getStartime(),
                                query.getSearch().getEndtime(),
                                query.getSort(),
                                query.getOrder()
                        )
                );
            } else {
                result = new PageInfo<>(
                        conferenceMapper.selectConfRecordValidating(
                                query.getSearch().getWorkerid(),
                                query.getSearch().getConfname(),
                                query.getSearch().getStartime(),
                                query.getSearch().getEndtime(),
                                query.getSort(),
                                query.getOrder()
                        )
                );
            }

        }
        return result;
    }


    /**
     * 查询审核通过的会议材料
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<OrderConfView> queryValiedRecord(PagedQueryForm<OrderedConf_c> query) {
        PageInfo<OrderConfView> result = null;
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            result = new PageInfo<>(
                    conferenceMapper.selectConfRecordPassed(
                            query.getSearch().getWorkerid(),
                            query.getSearch().getConfname(),
                            query.getSearch().getStartime(),
                            query.getSearch().getEndtime(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
        }
        return result;
    }


    /**
     * 材料已经归档
     *
     * @param confid
     * @return
     */
    @Transactional
    public int passRecordConf(Integer confid) {
        if (confid != null) {
            Conference conference = conferenceMapper.selectByPrimaryKey(confid);
            if (conference != null) {
                conference.setConfstatusid(5);
                return conferenceMapper.updateByPrimaryKey(conference);
            }
        }
        return 0;
    }

    /**
     * 不通过通过材料
     *
     * @param confid
     * @return
     */
    @Transactional
    public int unpassRecordConf(Integer confid) {
        if (confid != null) {
            Conference conference = conferenceMapper.selectByPrimaryKey(confid);
            if (conference != null) {
                conference.setConfstatusid(102);
                return conferenceMapper.updateByPrimaryKey(conference);
            }
        }
        return 0;
    }

    /**
     * 更新用户的结论
     *
     * @param confTitle
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public int updateConfTitleCon(ConfTitle confTitle) {
        if (confTitle != null) {
            int flag = confTitleMapper.updateByPrimaryKeySelective(confTitle);
            return flag;
        }
        return 0;
    }

    /**
     * 添加直接开会会议内容
     *
     * @param directConfWithBLOBs
     * @return
     */
    @Transactional
    public int addDirectConf(DirectConfWithBLOBs directConfWithBLOBs) {
        if (directConfWithBLOBs != null) {
            int flag = directConfMapper.insertSelective(directConfWithBLOBs);
            return flag;
        }
        return 0;
    }

    /**
     * 查询直接会议内容
     *
     * @param confid
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public DirectConfDetailView queryDirectConfRecord(String confid) {
        // 查询 基本信息
        DirectConfDetailView directConfDetailView = directConfMapper.selectDirectConf(confid);
        if (directConfDetailView == null) {
            return null;
        }
        try {
            // 查询会议属性
            String confattrsStr = directConfDetailView.getConfattrs();
            String[] confattrs = confattrsStr.split(",");
            String[] _confattrs = new String[confattrs.length];
            List<ConfAttributes> confAttributes = directConfMapper.selectConfAttrs(confattrs);
            for (int i = 0; i < confAttributes.size(); i++) {
                _confattrs[i] = confAttributes.get(i).getAttrdes();
            }
            directConfDetailView.setConfattrsArray(_confattrs);

            // 查询会议参与人员
            String attendersStr = directConfDetailView.getAttenders();
            String[] attenders = attendersStr.split(",");
            String[] _attenders = new String[attenders.length];
            List<Userinfo> confattenders = directConfMapper.selectUserinfos(attenders);
            for (int i = 0; i < confattenders.size(); i++) {
                _attenders[i] = confattenders.get(i).getUsrname();
            }
            directConfDetailView.setAttendersArray(_attenders);

            return directConfDetailView;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }


}
