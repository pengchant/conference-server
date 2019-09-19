package com.justcs.entity;

public class Conference {
    private Integer id;

    private String confname;

    private Integer semesterid;

    private Integer conflevelid;

    private Integer confstatusid;

    private String hosterid;

    private String hoster;

    private String recorderid;

    private String recorder;

    private String confqrcodeurl;

    private Integer meetcollectid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname == null ? null : confname.trim();
    }

    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public Integer getConflevelid() {
        return conflevelid;
    }

    public void setConflevelid(Integer conflevelid) {
        this.conflevelid = conflevelid;
    }

    public Integer getConfstatusid() {
        return confstatusid;
    }

    public void setConfstatusid(Integer confstatusid) {
        this.confstatusid = confstatusid;
    }

    public String getHosterid() {
        return hosterid;
    }

    public void setHosterid(String hosterid) {
        this.hosterid = hosterid == null ? null : hosterid.trim();
    }

    public String getHoster() {
        return hoster;
    }

    public void setHoster(String hoster) {
        this.hoster = hoster == null ? null : hoster.trim();
    }

    public String getRecorderid() {
        return recorderid;
    }

    public void setRecorderid(String recorderid) {
        this.recorderid = recorderid == null ? null : recorderid.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getConfqrcodeurl() {
        return confqrcodeurl;
    }

    public void setConfqrcodeurl(String confqrcodeurl) {
        this.confqrcodeurl = confqrcodeurl == null ? null : confqrcodeurl.trim();
    }

    public Integer getMeetcollectid() {
        return meetcollectid;
    }

    public void setMeetcollectid(Integer meetcollectid) {
        this.meetcollectid = meetcollectid;
    }
}