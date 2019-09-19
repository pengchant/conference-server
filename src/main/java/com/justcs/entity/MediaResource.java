package com.justcs.entity;

import java.util.Date;

public class MediaResource {
    private Integer id;

    private String description;

    private String mediaurl;

    private String uploaderid;

    private String uploader;

    private Date uploadtime;

    private Integer confid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl == null ? null : mediaurl.trim();
    }

    public String getUploaderid() {
        return uploaderid;
    }

    public void setUploaderid(String uploaderid) {
        this.uploaderid = uploaderid == null ? null : uploaderid.trim();
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader == null ? null : uploader.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }
}