package com.justcs.view;

import java.io.Serializable;

/**
 * 节点的媒体信息
 */
public class Meta implements Serializable {

    private String title;

    private String icon;

    public Meta(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
