package com.justcs.entity;

import java.util.Date;

public class OpConflog {
    private Integer id;

    private String opworkerid;

    private String opworker;

    private String opdescription;

    private String operip;

    private String device;

    private Integer confid;

    private Date optime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpworkerid() {
        return opworkerid;
    }

    public void setOpworkerid(String opworkerid) {
        this.opworkerid = opworkerid == null ? null : opworkerid.trim();
    }

    public String getOpworker() {
        return opworker;
    }

    public void setOpworker(String opworker) {
        this.opworker = opworker == null ? null : opworker.trim();
    }

    public String getOpdescription() {
        return opdescription;
    }

    public void setOpdescription(String opdescription) {
        this.opdescription = opdescription == null ? null : opdescription.trim();
    }

    public String getOperip() {
        return operip;
    }

    public void setOperip(String operip) {
        this.operip = operip == null ? null : operip.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }
}