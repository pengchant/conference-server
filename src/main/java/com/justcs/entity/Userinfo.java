package com.justcs.entity;

import java.util.Date;

public class Userinfo {
    private Integer id;

    private Integer accid;

    private String usrname;

    private String idcard;

    private Short gender;

    private String national;

    private String recofschool;

    private Date entparttime;

    private Date formtime;

    private String partstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national == null ? null : national.trim();
    }

    public String getRecofschool() {
        return recofschool;
    }

    public void setRecofschool(String recofschool) {
        this.recofschool = recofschool == null ? null : recofschool.trim();
    }

    public Date getEntparttime() {
        return entparttime;
    }

    public void setEntparttime(Date entparttime) {
        this.entparttime = entparttime;
    }

    public Date getFormtime() {
        return formtime;
    }

    public void setFormtime(Date formtime) {
        this.formtime = formtime;
    }

    public String getPartstatus() {
        return partstatus;
    }

    public void setPartstatus(String partstatus) {
        this.partstatus = partstatus == null ? null : partstatus.trim();
    }
}