package com.justcs.view;

/**
 * 查询本次会议需要解决的议题
 */
public class ConfCurIssueView {

    private Integer collectid;

    private Integer issuecurrent;

    private String mainconent;

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getIssuecurrent() {
        return issuecurrent;
    }

    public void setIssuecurrent(Integer issuecurrent) {
        this.issuecurrent = issuecurrent;
    }

    public String getMainconent() {
        return mainconent;
    }

    public void setMainconent(String mainconent) {
        this.mainconent = mainconent;
    }
}
