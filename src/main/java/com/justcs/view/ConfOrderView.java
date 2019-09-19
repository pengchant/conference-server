package com.justcs.view;

import com.justcs.entity.*;

import java.util.List;

/**
 * 会议预定视图
 */
public class ConfOrderView {

    // 1.会议议题采集表
    private MeetingCollect meetingCollect;

    // 2.封装上次会议所提议题 --》sb：改成议题
    private List<IssueLastmeet> issueLastmeetList;

    // 3.本次会议需要解决的问题
    private List<IssueCurmeet> issueCurmeetList;

    // 4.建议解决方案
    private List<Suggestion> suggestionList;

    // 5.会议
    private ConferenceWithBLOBs conference;

    // 6.会议属性
    private List<ConfAttributes> confAttributesList;

    // 7.封装列席人员
    private List<Attendes> attendesList;

    // 8.会议室占用表
    private ConfMeetingRoom confMeetingRoom;

    public MeetingCollect getMeetingCollect() {
        return meetingCollect;
    }

    public void setMeetingCollect(MeetingCollect meetingCollect) {
        this.meetingCollect = meetingCollect;
    }

    public List<IssueLastmeet> getIssueLastmeetList() {
        return issueLastmeetList;
    }

    public void setIssueLastmeetList(List<IssueLastmeet> issueLastmeetList) {
        this.issueLastmeetList = issueLastmeetList;
    }

    public List<IssueCurmeet> getIssueCurmeetList() {
        return issueCurmeetList;
    }

    public void setIssueCurmeetList(List<IssueCurmeet> issueCurmeetList) {
        this.issueCurmeetList = issueCurmeetList;
    }

    public List<Suggestion> getSuggestionList() {
        return suggestionList;
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    public ConferenceWithBLOBs getConference() {
        return conference;
    }

    public void setConference(ConferenceWithBLOBs conference) {
        this.conference = conference;
    }

    public List<ConfAttributes> getConfAttributesList() {
        return confAttributesList;
    }

    public void setConfAttributesList(List<ConfAttributes> confAttributesList) {
        this.confAttributesList = confAttributesList;
    }

    public List<Attendes> getAttendesList() {
        return attendesList;
    }

    public void setAttendesList(List<Attendes> attendesList) {
        this.attendesList = attendesList;
    }

    public ConfMeetingRoom getConfMeetingRoom() {
        return confMeetingRoom;
    }

    public void setConfMeetingRoom(ConfMeetingRoom confMeetingRoom) {
        this.confMeetingRoom = confMeetingRoom;
    }
}
