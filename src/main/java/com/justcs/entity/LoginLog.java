package com.justcs.entity;

import java.util.Date;

public class LoginLog {
    private Integer id;

    private Integer accoutnid;

    private String ip;

    private String devicename;

    private Date logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccoutnid() {
        return accoutnid;
    }

    public void setAccoutnid(Integer accoutnid) {
        this.accoutnid = accoutnid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}