package com.justcs.entity;

public class Mposition {
    private Integer id;

    private String position;

    private String positionnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPositionnum() {
        return positionnum;
    }

    public void setPositionnum(String positionnum) {
        this.positionnum = positionnum == null ? null : positionnum.trim();
    }
}