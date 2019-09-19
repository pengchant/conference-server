package com.justcs.entity;

public class ConferenceWithBLOBs extends Conference {
    private String conclusion;

    private String abstractcont;

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
    }

    public String getAbstractcont() {
        return abstractcont;
    }

    public void setAbstractcont(String abstractcont) {
        this.abstractcont = abstractcont == null ? null : abstractcont.trim();
    }
}