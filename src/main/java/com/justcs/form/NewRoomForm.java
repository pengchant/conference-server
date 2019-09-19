package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增会议室实体
 */
@ApiModel(value = "新增房间实体")
public class NewRoomForm {

    @ApiModelProperty(value = "会议室名称")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "会议室座位数")
    @NotNull
    private Integer seats;

    @ApiModelProperty(value = "所属部门编号")
    @NotNull
    private Integer department;

    @ApiModelProperty(value = "硬件条件")
    @NotNull
    private String[] hardcondition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String[] getHardcondition() {
        return hardcondition;
    }

    public void setHardcondition(String[] hardcondition) {
        this.hardcondition = hardcondition;
    }
}
