package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

@ApiModel(value = "用户注册表单")
public class UserRegistForm {

    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "用户名不能为空")
    private String workername;

    @ApiModelProperty(value = "工号")
    @NotBlank(message = "工号不能为空")
    private String workerid;

    @ApiModelProperty(value = "选择的部门")
    private List<Integer> depselected;

    @ApiModelProperty(value = "选择职位")
    private List<Integer> posselected;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "确认密码")
    @NotBlank(message = "确认密码不能为空")
    private String confirmpass;


    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public String getWorkerid() {
        return workerid;
    }

    public void setWorkerid(String workerid) {
        this.workerid = workerid;
    }

    public List<Integer> getDepselected() {
        return depselected;
    }

    public void setDepselected(List<Integer> depselected) {
        this.depselected = depselected;
    }

    public List<Integer> getPosselected() {
        return posselected;
    }

    public void setPosselected(List<Integer> posselected) {
        this.posselected = posselected;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
}
