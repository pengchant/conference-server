package com.justcs.entity;

public class MeetingRoom {
    private Integer id;

    private Integer department;

    private String roomname;

    private Integer maxcontain;

    private Short aircondition;

    private Short projector;

    private Short microphone;

    private Short stereo;

    private Short podium;

    private Short lightequ;

    private String address;

    private String meetingroomurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    public Integer getMaxcontain() {
        return maxcontain;
    }

    public void setMaxcontain(Integer maxcontain) {
        this.maxcontain = maxcontain;
    }

    public Short getAircondition() {
        return aircondition;
    }

    public void setAircondition(Short aircondition) {
        this.aircondition = aircondition;
    }

    public Short getProjector() {
        return projector;
    }

    public void setProjector(Short projector) {
        this.projector = projector;
    }

    public Short getMicrophone() {
        return microphone;
    }

    public void setMicrophone(Short microphone) {
        this.microphone = microphone;
    }

    public Short getStereo() {
        return stereo;
    }

    public void setStereo(Short stereo) {
        this.stereo = stereo;
    }

    public Short getPodium() {
        return podium;
    }

    public void setPodium(Short podium) {
        this.podium = podium;
    }

    public Short getLightequ() {
        return lightequ;
    }

    public void setLightequ(Short lightequ) {
        this.lightequ = lightequ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMeetingroomurl() {
        return meetingroomurl;
    }

    public void setMeetingroomurl(String meetingroomurl) {
        this.meetingroomurl = meetingroomurl == null ? null : meetingroomurl.trim();
    }
}