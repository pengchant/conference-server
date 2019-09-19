package com.justcs.entity;

public class Department {
    private Integer id;

    private String departnum;

    private String departname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartnum() {
        return departnum;
    }

    public void setDepartnum(String departnum) {
        this.departnum = departnum == null ? null : departnum.trim();
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }
}