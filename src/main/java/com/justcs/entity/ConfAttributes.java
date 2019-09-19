package com.justcs.entity;

public class ConfAttributes {
    private Integer id;

    private String attrname;

    private String attrdes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname == null ? null : attrname.trim();
    }

    public String getAttrdes() {
        return attrdes;
    }

    public void setAttrdes(String attrdes) {
        this.attrdes = attrdes == null ? null : attrdes.trim();
    }
}