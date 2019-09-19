package com.justcs.form;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 会议预约表单
 */
@ApiModel(value = "会议预约表单")
public class OrderConfForm {

    ////////////////步骤一、添加会议基本信息//////////////////
    @ApiModelProperty(value = "会议名称")
    @NotBlank(message = "会议名称不能为空")
    private String confname;

    @ApiModelProperty(value = "sb:会议级别->类别")
    @NotNull(message = "会议级别(类别)不能为Null")
    private Integer conflevel;

    @ApiModelProperty(value = "会议属性")
    @NotNull(message = "会议属性不能为空")
    private Integer[] confattrs;

    @ApiModelProperty(value = "sb:上次所提议题->议题")
    @NotNull(message = "上次所提议题->议题不能为空")
    private String[] lastquestions;

    @ApiModelProperty(value = "待解决的问题")
    @NotNull(message = "待解决的问题不能为空")
    private String[] curquesttions;

    @ApiModelProperty(value = "建议解决方案")
    @NotNull(message = "建议解决方案不能为空")
    private String[] suggestions;

    @ApiModelProperty(value = "学年")
    @NotBlank(message = "学年不能为空")
    private String years;

    @ApiModelProperty(value = "学期编号")
    @NotNull(message = "学期的编号不能为空")
    private Integer semesterid;

    @ApiModelProperty(value = "sb:第几周改成->日期")
    @NotBlank(message = "第几周->日期")
    private String weeksno;

    @ApiModelProperty(value = "sb:院领导->改成会议召集人(审核人员)")
    @NotBlank(message = "院领导姓名不能为空")
    private String leadername;


    //////////////////步骤二、添加会议室 和开会时间信息///////
    @ApiModelProperty(value = "会议室的编号")
    @NotNull(message = "会议室编号不能为空")
    private Integer selectedroomid;


    @ApiModelProperty(value = "会议开始时间:sb->不是日期")
    @NotNull(message = "会议开始时间不能为空")
    private String starttime;

    @ApiModelProperty(value = "会议结束时间:sb->不是日期")
    @NotNull(message = "会议结束时间不能为空")
    private String endtime;


    //////////////////步骤三、参会人员列表/////////////////////////
    @ApiModelProperty(value = "参会人员列表")
    @NotNull(message = "参会人员列表不能为空")
    private String[] selectAttenders;


    @ApiModelProperty(value = "记录人的工号")
    @NotBlank(message = "记录人员的工号不能为空")
    private String recorderid;

    @ApiModelProperty(value = "记录人员姓名")
    @NotBlank(message = "记录人员姓名不能为空")
    private String recorder;



    public String getConfname() {
        return confname;
    }

    public void setConfname(String confname) {
        this.confname = confname;
    }

    public Integer getConflevel() {
        return conflevel;
    }

    public void setConflevel(Integer conflevel) {
        this.conflevel = conflevel;
    }

    public Integer[] getConfattrs() {
        return confattrs;
    }

    public void setConfattrs(Integer[] confattrs) {
        this.confattrs = confattrs;
    }

    public String[] getLastquestions() {
        return lastquestions;
    }

    public void setLastquestions(String[] lastquestions) {
        this.lastquestions = lastquestions;
    }

    public String[] getCurquesttions() {
        return curquesttions;
    }

    public void setCurquesttions(String[] curquesttions) {
        this.curquesttions = curquesttions;
    }

    public String[] getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String[] suggestions) {
        this.suggestions = suggestions;
    }

    public Integer getSelectedroomid() {
        return selectedroomid;
    }

    public void setSelectedroomid(Integer selectedroomid) {
        this.selectedroomid = selectedroomid;
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

    public String[] getSelectAttenders() {
        return selectAttenders;
    }

    public void setSelectAttenders(String[] selectAttenders) {
        this.selectAttenders = selectAttenders;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }


    public Integer getSemesterid() {
        return semesterid;
    }

    public void setSemesterid(Integer semesterid) {
        this.semesterid = semesterid;
    }

    public String getWeeksno() {
        return weeksno;
    }

    public void setWeeksno(String weeksno) {
        this.weeksno = weeksno;
    }

    public String getLeadername() {
        return leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername;
    }

    public String getRecorderid() {
        return recorderid;
    }

    public void setRecorderid(String recorderid) {
        this.recorderid = recorderid;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }
}
