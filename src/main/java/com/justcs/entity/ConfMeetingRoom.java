package com.justcs.entity;

import java.util.Date;

public class ConfMeetingRoom extends ConfMeetingRoomKey {
    private Date starttime;

    private Date endtime;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}