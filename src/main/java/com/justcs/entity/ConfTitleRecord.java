package com.justcs.entity;

import java.util.Date;

public class ConfTitleRecord {
    private Integer id;

    private String speakerid;

    private String speakername;

    private Date speaktime;

    private Integer conftitleid;

    private String speaking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(String speakerid) {
        this.speakerid = speakerid == null ? null : speakerid.trim();
    }

    public String getSpeakername() {
        return speakername;
    }

    public void setSpeakername(String speakername) {
        this.speakername = speakername == null ? null : speakername.trim();
    }

    public Date getSpeaktime() {
        return speaktime;
    }

    public void setSpeaktime(Date speaktime) {
        this.speaktime = speaktime;
    }

    public Integer getConftitleid() {
        return conftitleid;
    }

    public void setConftitleid(Integer conftitleid) {
        this.conftitleid = conftitleid;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking == null ? null : speaking.trim();
    }
}