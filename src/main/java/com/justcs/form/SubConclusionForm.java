package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "保存会议结论表单")
public class SubConclusionForm {

    @NotBlank
    @ApiModelProperty(value = "会议的编号")
    private String confid;

    @NotBlank
    @ApiModelProperty(value = "会议的结论内容")
    private String consolusion;

    public String getConfid() {
        return confid;
    }

    public void setConfid(String confid) {
        this.confid = confid;
    }

    public String getConsolusion() {
        return consolusion;
    }

    public void setConsolusion(String consolusion) {
        this.consolusion = consolusion;
    }
}
