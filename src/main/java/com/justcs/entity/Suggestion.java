package com.justcs.entity;

import com.deepoove.poi.data.RowRenderData;

public class Suggestion extends RowRenderData {
    private Integer id;

    private String maincontent;

    private Integer meetcollid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent == null ? null : maincontent.trim();
    }

    public Integer getMeetcollid() {
        return meetcollid;
    }

    public void setMeetcollid(Integer meetcollid) {
        this.meetcollid = meetcollid;
    }
}