package com.justcs.form;


/**
 * 条件查询的会议室的请求参数封装
 */
public class MeetingRoom_c {

    /**
     * 部门编号
     */
    private Integer departmentid;

    /**
     * 是否有空调
     */
    private Boolean kt;

    /**
     * 是否有投影仪
     */
    private Boolean tyy;

    /**
     * 是否有麦克风
     */
    private Boolean mkf;

    /**
     * 是否有演讲台
     */
    private Boolean yjt;

    /**
     * 是否有音响
     */
    private Boolean yx;

    /**
     * 照明设备
     */
    private Boolean zmsb;

    /**
     * 需要容纳的参会人数
     */
    private Integer contains;


    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Boolean getKt() {
        return kt;
    }

    public void setKt(Boolean kt) {
        this.kt = kt;
    }

    public Boolean getTyy() {
        return tyy;
    }

    public void setTyy(Boolean tyy) {
        this.tyy = tyy;
    }

    public Boolean getMkf() {
        return mkf;
    }

    public void setMkf(Boolean mkf) {
        this.mkf = mkf;
    }

    public Boolean getYjt() {
        return yjt;
    }

    public void setYjt(Boolean yjt) {
        this.yjt = yjt;
    }

    public Boolean getYx() {
        return yx;
    }

    public void setYx(Boolean yx) {
        this.yx = yx;
    }

    public Integer getContains() {
        return contains;
    }

    public void setContains(Integer contains) {
        this.contains = contains;
    }

    public Boolean getZmsb() {
        return zmsb;
    }

    public void setZmsb(Boolean zmsb) {
        this.zmsb = zmsb;
    }
}
