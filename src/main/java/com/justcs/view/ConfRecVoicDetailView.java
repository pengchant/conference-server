package com.justcs.view;

/**
 * 会议议题
 * 会议发言记录
 * 会议发言录音
 * 结果视图
 */
public class ConfRecVoicDetailView {

    // 当前议题编号
    private String titleid;

    // 会议记录编号
    private String recordid;

    // 会议语音编号
    private String voiceid;

    // 会议议题名称
    private String titlename;

    // 会议发言人编号
    private String speakerid;

    // 会议发言人
    private String speakername;

    // 会议发言内容
    private String speaking;

    // 录音的monggodb的id
    private String voiceurl;

    public String getTitleid() {
        return titleid;
    }

    public void setTitleid(String titleid) {
        this.titleid = titleid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public String getVoiceid() {
        return voiceid;
    }

    public void setVoiceid(String voiceid) {
        this.voiceid = voiceid;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
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

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    public String getVoiceurl() {
        return voiceurl;
    }

    public void setVoiceurl(String voiceurl) {
        this.voiceurl = voiceurl;
    }
}
