package com.justcs.entity;

import java.util.Date;

public class Account {
    private Integer id;

    private String workerid;

    private String email;

    private String wxopenid;

    private Short wxflag;

    private Date registtime;

    private String phonenum;

    private String pwd;

    private Short userstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid == null ? null : workerid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid == null ? null : wxopenid.trim();
    }

    public Short getWxflag() {
        return wxflag;
    }

    public void setWxflag(Short wxflag) {
        this.wxflag = wxflag;
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Short getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Short userstatus) {
        this.userstatus = userstatus;
    }
}