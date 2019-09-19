package com.justcs.entity;

public class Privilege {
    private Integer id;

    private String privilegename;

    private String keyname;

    private String description;

    private String router;

    private Short ismenu;

    private Integer parentnodeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilegename() {
        return privilegename;
    }

    public void setPrivilegename(String privilegename) {
        this.privilegename = privilegename == null ? null : privilegename.trim();
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router == null ? null : router.trim();
    }

    public Short getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Short ismenu) {
        this.ismenu = ismenu;
    }

    public Integer getParentnodeid() {
        return parentnodeid;
    }

    public void setParentnodeid(Integer parentnodeid) {
        this.parentnodeid = parentnodeid;
    }
}