package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 用户发言表单
 */
@ApiModel(value = "用户发言表单")
public class UsrSpeachForm {

    @NotBlank
    @ApiModelProperty(value = "会议编号")
    private String confid;

    @NotBlank
    @ApiModelProperty(value = "议题标题")
    private String conftitle;

    @NotBlank
    @ApiModelProperty(value = "发言人工号")
    private String speakerid;

    @NotBlank
    @ApiModelProperty(value = "发言人姓名")
    private String speakername;

    @NotBlank
    @ApiModelProperty(value = "发言内容")
    private String content;

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
}
