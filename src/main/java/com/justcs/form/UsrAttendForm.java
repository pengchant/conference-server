package com.justcs.form;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;

/**
 * 用户签到视图
 */
@ApiModel(value = "用户签到视图")
public class UsrAttendForm {

    @NotBlank
    private String workerid;

    @NotBlank
    private String confid;

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public String getConfid() {
        return confid;
    }

    public void setConfid(String confid) {
        this.confid = confid;
    }
}
