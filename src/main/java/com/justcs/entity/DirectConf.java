package com.justcs.entity;

import java.util.Date;

public class DirectConf {
    private Integer id;

    private String confname;

    private Integer semesterid;

    private String semester;

    private String confattrs;

    private Integer conftypeid;

    private String conftypename;

    private Integer hosterid;

    private String hoster;

    private Integer recorderid;

    private String recorder;

    private String confaddress;

    private Date confstarttime;

    private Date confendtime;

    private String attenders;

    private String confstatus;

    private Date subtime;

    private Date objtime;

    private String other1;

    private String other2;

    private String other3;

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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public String getConfattrs() {
        return confattrs;
    }

    public void setConfattrs(String confattrs) {
        this.confattrs = confattrs == null ? null : confattrs.trim();
    }

    public Integer getConftypeid() {
        return conftypeid;
    }

    public void setConftypeid(Integer conftypeid) {
        this.conftypeid = conftypeid;
    }

    public String getConftypename() {
        return conftypename;
    }

    public void setConftypename(String conftypename) {
        this.conftypename = conftypename == null ? null : conftypename.trim();
    }

    public Integer getHosterid() {
        return hosterid;
    }

    public void setHosterid(Integer hosterid) {
        this.hosterid = hosterid;
    }

    public String getHoster() {
        return hoster;
    }

    public void setHoster(String hoster) {
        this.hoster = hoster == null ? null : hoster.trim();
    }

    public Integer getRecorderid() {
        return recorderid;
    }

    public void setRecorderid(Integer recorderid) {
        this.recorderid = recorderid;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getConfaddress() {
        return confaddress;
    }

    public void setConfaddress(String confaddress) {
        this.confaddress = confaddress == null ? null : confaddress.trim();
    }

    public Date getConfstarttime() {
        return confstarttime;
    }

    public void setConfstarttime(Date confstarttime) {
        this.confstarttime = confstarttime;
    }

    public Date getConfendtime() {
        return confendtime;
    }

    public void setConfendtime(Date confendtime) {
        this.confendtime = confendtime;
    }

    public String getAttenders() {
        return attenders;
    }

    public void setAttenders(String attenders) {
        this.attenders = attenders == null ? null : attenders.trim();
    }

    public String getConfstatus() {
        return confstatus;
    }

    public void setConfstatus(String confstatus) {
        this.confstatus = confstatus == null ? null : confstatus.trim();
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public Date getObjtime() {
        return objtime;
    }

    public void setObjtime(Date objtime) {
        this.objtime = objtime;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3 == null ? null : other3.trim();
    }
}