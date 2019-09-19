package com.justcs.view;

/**
 * 直接开会会议记录视图
 */
public class DirectConfDetailView {

    private String confid;

    private String confname;

    private String semester; // 学期 -

    private String confattrs;

    private String[] confattrsArray; // 会议属性

    private String conftype; // 会议类别 -

    private String hoster; // 会议主持人 -

    private String recorder; // 会议记录人 -

    private String confaddress;

    private String starttime;

    private String endtime;

    private String attenders;

    private String[] attendersArray; // 会议参与人员

    private String conftext;

    private String conclusion;

    public String getConfid() {
        return confid;
    }

    public void setConfid(String confid) {
        this.confid = confid;
    }

    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getConfattrs() {
        return confattrs;
    }

    public void setConfattrs(String confattrs) {
        this.confattrs = confattrs;
    }

    public String[] getConfattrsArray() {
        return confattrsArray;
    }

    public void setConfattrsArray(String[] confattrsArray) {
        this.confattrsArray = confattrsArray;
    }

    public String getConftype() {
        return conftype;
    }

    public void setConftype(String conftype) {
        this.conftype = conftype;
    }

    public String getHoster() {
        return hoster;
    }

    public void setHoster(String hoster) {
        this.hoster = hoster;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getConfaddress() {
        return confaddress;
    }

    public void setConfaddress(String confaddress) {
        this.confaddress = confaddress;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getAttenders() {
        return attenders;
    }

    public void setAttenders(String attenders) {
        this.attenders = attenders;
    }

    public String[] getAttendersArray() {
        return attendersArray;
    }

    public void setAttendersArray(String[] attendersArray) {
        this.attendersArray = attendersArray;
    }

    public String getConftext() {
        return conftext;
    }

    public void setConftext(String conftext) {
        this.conftext = conftext;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
