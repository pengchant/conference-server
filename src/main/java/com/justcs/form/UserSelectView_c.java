package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 用户选择的条件视图
 */
@ApiModel(value = "用户选择查询条件的视图")
public class UserSelectView_c {

    /**
     * 部门的编号
     */
    @ApiModelProperty(value = "部门编号")
    @NotNull
    private Integer depid;

    /**
     * 职位编号的列表
     */
    @ApiModelProperty(value = "职位列表")
    @NotNull
    private Integer[] positionid;

    /**
     * 用户职位编号列表
     */
    @ApiModelProperty(value = "职位编号")
    @NotNull
    private Integer[] dutyid;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public Integer[] getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer[] positionid) {
        this.positionid = positionid;
    }

    public Integer[] getDutyid() {
        return dutyid;
    }

    public void setDutyid(Integer[] dutyid) {
        this.dutyid = dutyid;
    }
}
