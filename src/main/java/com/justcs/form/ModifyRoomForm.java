package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "修改房间实体类")
public class ModifyRoomForm extends NewRoomForm {

    @ApiModelProperty(value = "房间的编号")
    @NotBlank
    private String roomid;

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }
}
