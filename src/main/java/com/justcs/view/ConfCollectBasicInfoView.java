package com.justcs.view;

/**
 * 查询会议议题采集表基本信息
 */
public class ConfCollectBasicInfoView {

    private String collegeleader;

    private Integer collectid;

    private Integer confid;

    private String colltime;

    private String termyear;

    private String meetweeks;

    public String getCollegeleader() {
        return collegeleader;
    }

    public void setCollegeleader(String collegeleader) {
        this.collegeleader = collegeleader;
    }

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public String getColltime() {
        return colltime;
    }

    public void setColltime(String colltime) {
        this.colltime = colltime;
    }

    public String getTermyear() {
        return termyear;
    }

    public void setTermyear(String termyear) {
        this.termyear = termyear;
    }

    public String getMeetweeks() {
        return meetweeks;
    }

    public void setMeetweeks(String meetweeks) {
        this.meetweeks = meetweeks;
    }
}
