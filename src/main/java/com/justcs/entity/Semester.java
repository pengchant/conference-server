package com.justcs.entity;

public class Semester {
    private Integer id;

    private String semesterid;

    private String semestername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(String semesterid) {
        this.semesterid = semesterid == null ? null : semesterid.trim();
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername == null ? null : semestername.trim();
    }
}