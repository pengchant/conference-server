package com.justcs.view;

import com.justcs.entity.VoiceRecord;

import java.util.List;

/**
 * 用户发言视图
 */
public class UsrConfRecordView {

    // 会议发言编号
    private String confrecid;

    // 发言人工号
    private String speakerid;

    // 发言人姓名
    private String speakername;

    // 发言内容
    private String content;

    // 发言时间
    private String speakertime;

    // 录音列表
    private List<VoiceRecord> voiceRecords;

    public String getConfrecid() {
        return confrecid;
    }

    public void setConfrecid(String confrecid) {
        this.confrecid = confrecid;
    }

    public String getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(String speakerid) {
        this.speakerid = speakerid;
    }

    public String getSpeakername() {
        return speakername;
    }

    public void setSpeakername(String speakername) {
        this.speakername = speakername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpeakertime() {
        return speakertime;
    }

    public void setSpeakertime(String speakertime) {
        this.speakertime = speakertime;
    }

    public List<VoiceRecord> getVoiceRecords() {
        return voiceRecords;
    }

    public void setVoiceRecords(List<VoiceRecord> voiceRecords) {
        this.voiceRecords = voiceRecords;
    }
}
