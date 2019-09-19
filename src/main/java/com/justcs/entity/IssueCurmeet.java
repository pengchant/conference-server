package com.justcs.entity;

import com.deepoove.poi.data.RowRenderData;

public class IssueCurmeet extends RowRenderData {
    private Integer id;

    private String mainconent;

    private Integer meetcollid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainconent() {
        return mainconent;
    }

    public void setMainconent(String mainconent) {
        this.mainconent = mainconent == null ? null : mainconent.trim();
    }

    public Integer getMeetcollid() {
        return meetcollid;
    }

    public void setMeetcollid(Integer meetcollid) {
        this.meetcollid = meetcollid;
    }
}