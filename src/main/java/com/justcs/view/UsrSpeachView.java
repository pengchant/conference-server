package com.justcs.view;

import java.util.List;

/**
 * 用户发言的视图
 */
public class UsrSpeachView {

    // 会议的编号
    private String confid;

    // 会议的title
    private String conftitle;

    // 用户发言的视图列表
    private List<UsrSpeachView> usrSpeachViews;


    public String getConfid() {
        return confid;
    }

    public void setConfid(String confid) {
        this.confid = confid;
    }

    public String getConftitle() {
        return conftitle;
    }

    public void setConftitle(String conftitle) {
        this.conftitle = conftitle;
    }

    public List<UsrSpeachView> getUsrSpeachViews() {
        return usrSpeachViews;
    }

    public void setUsrSpeachViews(List<UsrSpeachView> usrSpeachViews) {
        this.usrSpeachViews = usrSpeachViews;
    }
}
