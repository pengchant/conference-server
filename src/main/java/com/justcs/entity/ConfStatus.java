package com.justcs.entity;

public class ConfStatus {
    private Integer id;

    private String confstatus;

    private String confdes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfstatus() {
        return confstatus;
    }

    public void setConfstatus(String confstatus) {
        this.confstatus = confstatus == null ? null : confstatus.trim();
    }

    public String getConfdes() {
        return confdes;
    }

    public void setConfdes(String confdes) {
        this.confdes = confdes == null ? null : confdes.trim();
    }
}