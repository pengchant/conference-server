package com.justcs.entity;

public class ConfTitle {
    private Integer id;

    private String conftitlecnt;

    private Integer confid;

    private String conclusion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConftitlecnt() {
        return conftitlecnt;
    }

    public void setConftitlecnt(String conftitlecnt) {
        this.conftitlecnt = conftitlecnt == null ? null : conftitlecnt.trim();
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}