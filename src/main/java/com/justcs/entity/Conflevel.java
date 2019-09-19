package com.justcs.entity;

public class Conflevel {
    private Integer id;

    private String levelname;

    private String leveldes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname == null ? null : levelname.trim();
    }

    public String getLeveldes() {
        return leveldes;
    }

    public void setLeveldes(String leveldes) {
        this.leveldes = leveldes == null ? null : leveldes.trim();
    }
}