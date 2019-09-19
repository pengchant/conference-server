package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "添加会议议题实体类")
public class AddMeetingCollectForm {

    @ApiModelProperty(value = "会议编号")
    @NotNull(message = "会议编号不能为空")
    private Integer confid;

    @ApiModelProperty(value = "会议议题内容")
    @NotBlank(message = "会议议题内容不能为空")
    private String speechitem;

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public String getSpeechitem() {
        return speechitem;
    }

    public void setSpeechitem(String speechitem) {
        this.speechitem = speechitem;
    }
}
