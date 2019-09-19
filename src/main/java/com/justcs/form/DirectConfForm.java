package com.justcs.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 直接开会用户提交的表单
 */
@ApiModel(value = "直接开会填写的表单")
public class DirectConfForm {

    @ApiModelProperty(value = "会议名称")
    @NotBlank
    private String confname;

    @ApiModelProperty(value = "学期编号")
    @NotNull
    private Integer semester;

    @ApiModelProperty(value = "会议属性")
    @NotNull
    private Integer[] confattr;

    @ApiModelProperty(value = "会议类别/级别")
    @NotNull
    private Integer conftype;

    @ApiModelProperty(value = "主持人编号")
    @NotNull
    private Integer hosterid;

    @ApiModelProperty(value = "录入人编号")
    @NotNull
    private Integer recorderid;

    @ApiModelProperty(value = "会议地点")
    @NotBlank
    private String confaddress;

    @ApiModelProperty(value = "开始时间")
    @NotBlank
    private String starttime;

    @ApiModelProperty(value = "结束时间")
    @NotBlank
    private String endtime;

    @ApiModelProperty(value = "与会人员")
    @NotNull
    private Integer[] attenders;

    @ApiModelProperty(value = "会议内容记录")
    @NotBlank
    private String maincontent;

    @ApiModelProperty(value = "会议结论")
    @NotBlank
    private String conclusion;


    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer[] getConfattr() {
        return confattr;
    }

    public void setConfattr(Integer[] confattr) {
        this.confattr = confattr;
    }

    public Integer getConftype() {
        return conftype;
    }

    public void setConftype(Integer conftype) {
        this.conftype = conftype;
    }

    public Integer getHosterid() {
        return hosterid;
    }

    public void setHosterid(Integer hosterid) {
        this.hosterid = hosterid;
    }

    public Integer getRecorderid() {
        return recorderid;
    }

    public void setRecorderid(Integer recorderid) {
        this.recorderid = recorderid;
    }

    public String getConfaddress() {
        return confaddress;
    }

    public void setConfaddress(String confaddress) {
        this.confaddress = confaddress;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer[] getAttenders() {
        return attenders;
    }

    public void setAttenders(Integer[] attenders) {
        this.attenders = attenders;
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
