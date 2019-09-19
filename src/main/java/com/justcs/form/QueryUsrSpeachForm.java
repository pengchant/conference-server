package com.justcs.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 条件查询会议的列表
 */
@ApiModel(value = "条件查询会议的列表")
public class QueryUsrSpeachForm {

    @NotBlank
    @ApiModelProperty(value = "会议的编号")
    private String confid;

    @NotBlank
    @ApiModelProperty(value = "会议的title")
    private String conftitle;

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
}
