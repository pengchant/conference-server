package com.justcs.view;

/**
 * 查询上次会议所提议题
 */
public class ConfLastIssueView {

    private Integer collectid;

    private Integer issuelastid;

    private String maincontent;

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getIssuelastid() {
        return issuelastid;
    }

    public void setIssuelastid(Integer issuelastid) {
        this.issuelastid = issuelastid;
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent;
    }
}
