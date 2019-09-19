package com.justcs.view;

import com.justcs.entity.ConfTitle;

import java.util.List;

/**
 * 加载会议预约详细情况的视图
 */
public class RecordConfDetailView {

    // 会议的基本信息
    private BasicConfInfoView basicConfInfoView;

    // 会议列席人员
    private List<ListAttendersView> attendersViews;

    // 会议属性
    private List<ConfAttributesListView> confattrs;

    // 采集表基本信息
    private ConfCollectBasicInfoView confCollectBasicInfoView;

    // 上次会议所提议题
    private List<ConfLastIssueView> confLastIssueViewList;

    // 本次会议所提议题
    private List<ConfCurIssueView> confCurIssueViewsList;

    // 查询建议解决方案
    private List<ConfSuggestionView> confSuggestionViewList;

    // 查询会议议题的会话列表
    private List<ConfRecVoicDetailView> confRecVoicDetailViewList;

    // 新增=============>sb:议题的结论
    private List<ConfTitle> confTitleViewList;

    public BasicConfInfoView getBasicConfInfoView() {
        return basicConfInfoView;
    }

    public void setBasicConfInfoView(BasicConfInfoView basicConfInfoView) {
        this.basicConfInfoView = basicConfInfoView;
    }

    public List<ListAttendersView> getAttendersViews() {
        return attendersViews;
    }

    public void setAttendersViews(List<ListAttendersView> attendersViews) {
        this.attendersViews = attendersViews;
    }

    public List<ConfAttributesListView> getConfattrs() {
        return confattrs;
    }

    public void setConfattrs(List<ConfAttributesListView> confattrs) {
        this.confattrs = confattrs;
    }

    public ConfCollectBasicInfoView getConfCollectBasicInfoView() {
        return confCollectBasicInfoView;
    }

    public void setConfCollectBasicInfoView(ConfCollectBasicInfoView confCollectBasicInfoView) {
        this.confCollectBasicInfoView = confCollectBasicInfoView;
    }

    public List<ConfLastIssueView> getConfLastIssueViewList() {
        return confLastIssueViewList;
    }

    public void setConfLastIssueViewList(List<ConfLastIssueView> confLastIssueViewList) {
        this.confLastIssueViewList = confLastIssueViewList;
    }

    public List<ConfCurIssueView> getConfCurIssueViewsList() {
        return confCurIssueViewsList;
    }

    public void setConfCurIssueViewsList(List<ConfCurIssueView> confCurIssueViewsList) {
        this.confCurIssueViewsList = confCurIssueViewsList;
    }

    public List<ConfSuggestionView> getConfSuggestionViewList() {
        return confSuggestionViewList;
    }

    public void setConfSuggestionViewList(List<ConfSuggestionView> confSuggestionViewList) {
        this.confSuggestionViewList = confSuggestionViewList;
    }

    public List<ConfRecVoicDetailView> getConfRecVoicDetailViewList() {
        return confRecVoicDetailViewList;
    }

    public void setConfRecVoicDetailViewList(List<ConfRecVoicDetailView> confRecVoicDetailViewList) {
        this.confRecVoicDetailViewList = confRecVoicDetailViewList;
    }

    public List<ConfTitle> getConfTitleViewList() {
        return confTitleViewList;
    }

    public void setConfTitleViewList(List<ConfTitle> confTitleViewList) {
        this.confTitleViewList = confTitleViewList;
    }
}
