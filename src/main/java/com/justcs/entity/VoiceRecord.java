package com.justcs.entity;

public class VoiceRecord {
    private Integer id;

    private String voicedes;

    private String voiceurl;

    private Integer conftitlerecordid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoicedes() {
        return voicedes;
    }

    public void setVoicedes(String voicedes) {
        this.voicedes = voicedes == null ? null : voicedes.trim();
    }

    public String getVoiceurl() {
        return voiceurl;
    }

    public void setVoiceurl(String voiceurl) {
        this.voiceurl = voiceurl == null ? null : voiceurl.trim();
    }

    public Integer getConftitlerecordid() {
        return conftitlerecordid;
    }

    public void setConftitlerecordid(Integer conftitlerecordid) {
        this.conftitlerecordid = conftitlerecordid;
    }
}