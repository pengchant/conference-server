package com.justcs.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 当前添加会议议题的表单
 */
@ApiModel(value = "添加会议议题表单")
public class CurIssueForm {

    @ApiModelProperty(value = "会议议题采集表编号")
    @NotBlank
    private String conftitleid;

    @ApiModelProperty(value = "当前会议议题内容")
    @NotBlank
    private String content;


    public String getConftitleid() {
        return conftitleid;
    }

    public void setConftitleid(String conftitleid) {
        this.conftitleid = conftitleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
