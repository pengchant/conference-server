package com.justcs.entity;

import java.util.Date;

public class MeetingCollect {
    private Integer id;

    private String collegeleader;

    private Date colltime;

    private String termyear;

    private String meetsemesters;

    private String meetweeks;

    private String department;

    private Short meetcollectsts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeleader() {
        return collegeleader;
    }

    public void setCollegeleader(String collegeleader) {
        this.collegeleader = collegeleader == null ? null : collegeleader.trim();
    }

    public Date getColltime() {
        return colltime;
    }

    public void setColltime(Date colltime) {
        this.colltime = colltime;
    }

    public String getTermyear() {
        return termyear;
    }

    public void setTermyear(String termyear) {
        this.termyear = termyear == null ? null : termyear.trim();
    }

    public String getMeetsemesters() {
        return meetsemesters;
    }

    public void setMeetsemesters(String meetsemesters) {
        this.meetsemesters = meetsemesters == null ? null : meetsemesters.trim();
    }

    public String getMeetweeks() {
        return meetweeks;
    }

    public void setMeetweeks(String meetweeks) {
        this.meetweeks = meetweeks == null ? null : meetweeks.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Short getMeetcollectsts() {
        return meetcollectsts;
    }

    public void setMeetcollectsts(Short meetcollectsts) {
        this.meetcollectsts = meetcollectsts;
    }
}