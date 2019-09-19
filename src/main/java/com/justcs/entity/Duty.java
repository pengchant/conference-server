package com.justcs.entity;

public class Duty {
    private Integer id;

    private String duty;

    private String dutynum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getDutynum() {
        return dutynum;
    }

    public void setDutynum(String dutynum) {
        this.dutynum = dutynum == null ? null : dutynum.trim();
    }
}