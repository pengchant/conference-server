package com.justcs.form;


/**
 * 预定会议查询条件
 */
public class OrderedConf_c {

    private String workerid; // 人员工号

    private String confstatus; // 会议的状态

    private String confname; // 会议名称

    private String startime; // 开始时间

    private String endtime; // 结束时间

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public String getConfstatus() {
        return confstatus;
    }

    public void setConfstatus(String confstatus) {
        this.confstatus = confstatus;
    }

    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
