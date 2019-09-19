package com.justcs.entity;

public class Attendes {
    private Integer id;

    private String workerid;

    private String wokername;

    private Short hasattend;

    private Integer confid;

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

    public String getWokername() {
        return wokername;
    }

    public void setWokername(String wokername) {
        this.wokername = wokername == null ? null : wokername.trim();
    }

    public Short getHasattend() {
        return hasattend;
    }

    public void setHasattend(Short hasattend) {
        this.hasattend = hasattend;
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }
}