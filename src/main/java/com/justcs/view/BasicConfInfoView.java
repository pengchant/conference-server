package com.justcs.view;

/**
 * 查询会议的基本信息(名称-学期-会议级别-主持人-录入人)
 */
public class BasicConfInfoView {

    private Integer confid;

    private String confname;

    private String semestername;

    private String levelname;

    private String hosterid;

    private String hoster;

    private String recorderid;

    private String recorder;

    private String starttime;

    private String endtime;

    private String roomid;

    private String roomname;

    // 结论
    private String conclusion;

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getHosterid() {
        return hosterid;
    }

    public void setHosterid(String hosterid) {
        this.hosterid = hosterid;
    }

    public String getHoster() {
        return hoster;
    }

    public void setHoster(String hoster) {
        this.hoster = hoster;
    }

    public String getRecorderid() {
        return recorderid;
    }

    public void setRecorderid(String recorderid) {
        this.recorderid = recorderid;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
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

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
