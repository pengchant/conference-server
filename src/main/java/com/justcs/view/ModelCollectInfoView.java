package com.justcs.view;

import java.util.List;

/**
 * 下载模板的实体类封装
 */
public class ModelCollectInfoView {

    // 会议基本信息
    private BasicConfInfoView basicConfInfoView;

    // 基本信息
    private ConfCollectBasicInfoView confCollectBasicInfoView;

    // 上次会议议题
    private List<ConfLastIssueView> confLastIssueViewList;

    // 本次会议议题
    private List<ConfCurIssueView> confCurIssueViewList;

    // 建议解决方案
    private List<ConfSuggestionView> confSuggestionViewList;

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

    public List<ConfCurIssueView> getConfCurIssueViewList() {
        return confCurIssueViewList;
    }

    public void setConfCurIssueViewList(List<ConfCurIssueView> confCurIssueViewList) {
        this.confCurIssueViewList = confCurIssueViewList;
    }

    public List<ConfSuggestionView> getConfSuggestionViewList() {
        return confSuggestionViewList;
    }

    public void setConfSuggestionViewList(List<ConfSuggestionView> confSuggestionViewList) {
        this.confSuggestionViewList = confSuggestionViewList;
    }

    public BasicConfInfoView getBasicConfInfoView() {
        return basicConfInfoView;
    }

    public void setBasicConfInfoView(BasicConfInfoView basicConfInfoView) {
        this.basicConfInfoView = basicConfInfoView;
    }
}
