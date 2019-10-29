package com.justcs.controller;


import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.*;
import com.justcs.service.SysConfService;
import com.justcs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统配置
 */
@Api(value = "系统配置控制层", description = "系统配置接口")
@RestController
@RequestMapping("/sys")
public class SysConfController {

    private static final Logger logger = LoggerFactory.getLogger(SysConfController.class);

    @Autowired
    private SysConfService sysConfService;

    /**
     * 分页查询所有学期信息
     *
     * @return
     */
    @PostMapping("/querySemesters")
    @ApiOperation(value = "分页按照条件查询所有的学期的信息")
    public JSONResult querySemesters(@RequestBody @Valid PagedQueryForm<Semesters_c> param) {
        try {
            PageInfo<Semester> result = sysConfService.queryPagedSemester(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增学期
     *
     * @param semester
     * @return
     */
    @PostMapping("/addSemester")
    @ApiOperation(value = "新增学期")
    public JSONResult addSemester(@RequestBody(required = true) Semester semester) {
        try {
            int affected = sysConfService.addSemester(semester);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除学期信息
     *
     * @param semesterid
     * @return
     */
    @PostMapping("/rmSemester/{semesterid}")
    @ApiOperation(value = "删除学期信息")
    public JSONResult removeSemester(@PathVariable("semesterid") int semesterid) {
        Semester semester = new Semester();
        semester.setId(semesterid);
        try {
            int affected = sysConfService.removeSemester(semester);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除学期信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmsemester")
    @ApiOperation(value = "批量删除学期信息")
    public JSONResult batchRemoveSemester(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveSemester(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改学期信息
     *
     * @param semester
     * @return
     */
    @PostMapping("/mdsemester")
    @ApiOperation(value = "修改学期信息")
    public JSONResult mdsemester(@RequestBody(required = true) Semester semester) {
        try {
            int affected = sysConfService.modifySemester(semester);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    ////////////////////////////////////////////////////////////


    /**
     * 分页查询所有职务信息
     *
     * @return
     */
    @PostMapping("/queryPositions")
    @ApiOperation(value = "分页查询所有职务信息")
    public JSONResult queryPositions(@RequestBody @Valid PagedQueryForm<MPosition_c> param) {
        try {
            PageInfo<Mposition> result = sysConfService.queryPagedPosition(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增职务
     *
     * @param mposition
     * @return
     */
    @PostMapping("/addPosition")
    @ApiOperation(value = "新增职务")
    public JSONResult addPosition(@RequestBody(required = true) Mposition mposition) {
        try {
            int affected = sysConfService.addPosition(mposition);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除职务信息
     *
     * @param positionid
     * @return
     */
    @PostMapping("/rmPosition/{positionid}")
    @ApiOperation(value = "删除职务信息")
    public JSONResult removePosition(@PathVariable("positionid") int positionid) {
        Mposition mposition = new Mposition();
        mposition.setId(positionid);
        try {
            int affected = sysConfService.removePosition(mposition);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除职务信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmposition")
    @ApiOperation(value = "批量删除职务信息")
    public JSONResult batchRemovePosition(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemovePosition(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改职务信息
     *
     * @param mposition
     * @return
     */
    @PostMapping("/mdposition")
    @ApiOperation(value = "修改职务信息")
    public JSONResult mdposition(@RequestBody(required = true) Mposition mposition) {
        try {
            int affected = sysConfService.modifyPosition(mposition);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    //////////////////////////////////////////////////////////

    /**
     * 分页查询所有职务信息
     *
     * @return
     */
    @PostMapping("/queryDutys")
    @ApiOperation(value = "分页查询所有职位信息")
    public JSONResult queryDutys(@RequestBody @Valid PagedQueryForm<Duty_c> param) {
        try {
            PageInfo<Duty> result = sysConfService.queryPagedDuty(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增职务
     *
     * @param duty
     * @return
     */
    @PostMapping("/addDuty")
    @ApiOperation(value = "新增职务")
    public JSONResult addDuty(@RequestBody(required = true) Duty duty) {
        try {
            int affected = sysConfService.addDuty(duty);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除职务信息
     *
     * @param dutyid
     * @return
     */
    @PostMapping("/rmDuty/{dutyid}")
    @ApiOperation(value = "删除职务信息")
    public JSONResult rmDuty(@PathVariable("dutyid") int dutyid) {
        Duty duty = new Duty();
        duty.setId(dutyid);
        try {
            int affected = sysConfService.removeDuty(duty);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除职务信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmduty")
    @ApiOperation(value = "批量删除职务信息")
    public JSONResult bhrmduty(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveDuty(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改职务信息
     *
     * @param duty
     * @return
     */
    @PostMapping("/mdduty")
    @ApiOperation(value = "修改职务信息")
    public JSONResult mdduty(@RequestBody(required = true) Duty duty) {
        try {
            int affected = sysConfService.modifyDuty(duty);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    //////////////////////////////////////////////////////////

    /**
     * 分页查询所有部门信息
     *
     * @return
     */
    @PostMapping("/queryDepartments")
    @ApiOperation(value = "分页查询所有部门信息")
    public JSONResult queryDepartments(@RequestBody @Valid PagedQueryForm<Department_c> param) {
        try {
            PageInfo<Department> result = sysConfService.queryPagedDep(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增部门信息
     *
     * @param department
     * @return
     */
    @PostMapping("/addDepartment")
    @ApiOperation(value = "新增部门信息")
    public JSONResult addDepartment(@RequestBody(required = true) Department department) {
        try {
            int affected = sysConfService.addDepartment(department);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除部门信息
     *
     * @param depid
     * @return
     */
    @PostMapping("/rmDepartment/{depid}")
    @ApiOperation(value = "删除职务信息")
    public JSONResult rmDepartment(@PathVariable("depid") int depid) {
        Department department = new Department();
        department.setId(depid);
        try {
            int affected = sysConfService.removeDepartment(department);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除部门信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmdepartment")
    @ApiOperation(value = "批量删除部门信息")
    public JSONResult bhrmdepartment(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveDepartment(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改部门信息
     *
     * @param department
     * @return
     */
    @PostMapping("/mddepartment")
    @ApiOperation(value = "修改职务信息")
    public JSONResult mddepartment(@RequestBody(required = true) Department department) {
        try {
            int affected = sysConfService.modifyDepartment(department);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    ////////////////////////////////////////////////////

    /**
     * 分页查询所有会议级别信息
     *
     * @return
     */
    @PostMapping("/queryConflevel")
    @ApiOperation(value = "分页查询所有会议级别信息")
    public JSONResult queryConflevel(@RequestBody @Valid PagedQueryForm<ConfLevel_c> param) {
        try {
            PageInfo<Conflevel> result = sysConfService.queryPagedConfLevel(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增会议级别信息
     *
     * @param conflevel
     * @return
     */
    @PostMapping("/addConflevel")
    @ApiOperation(value = "新增会议级别信息")
    public JSONResult addConflevel(@RequestBody(required = true) Conflevel conflevel) {
        try {
            int affected = sysConfService.addConfLevels(conflevel);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除会议级别信息
     *
     * @param conflevelid
     * @return
     */
    @PostMapping("/rmConflevel/{conflevelid}")
    @ApiOperation(value = "删除会议级别信息")
    public JSONResult rmConflevel(@PathVariable("conflevelid") int conflevelid) {
        Conflevel conflevel = new Conflevel();
        conflevel.setId(conflevelid);
        try {
            int affected = sysConfService.removeConflevel(conflevel);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除会议级别信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmconflevel")
    @ApiOperation(value = "批量删除会议级别信息")
    public JSONResult bhrmconflevel(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveConflevels(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改会议级别信息
     *
     * @param conflevel
     * @return
     */
    @PostMapping("/mdconflevel")
    @ApiOperation(value = "修改会议级别信息")
    public JSONResult mdconflevel(@RequestBody(required = true) Conflevel conflevel) {
        try {
            int affected = sysConfService.modifyConfLevel(conflevel);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    ///////////////////////////////////////////////////////////////////////

    /**
     * 分页查询所有会议属性信息
     *
     * @return
     */
    @PostMapping("/queryConfattr")
    @ApiOperation(value = "分页查询所有会议属性信息")
    public JSONResult queryConfattr(@RequestBody @Valid PagedQueryForm<ConfAttr_c> param) {
        try {
            PageInfo<ConfAttributes> result = sysConfService.queryPagedConfattr(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增会议属性信息
     *
     * @param confAttributes
     * @return
     */
    @PostMapping("/addConfattr")
    @ApiOperation(value = "新增会议属性信息")
    public JSONResult addConfattr(@RequestBody(required = true) ConfAttributes confAttributes) {
        try {
            int affected = sysConfService.addConfAttrs(confAttributes);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除会议属性信息
     *
     * @param confattrlid
     * @return
     */
    @PostMapping("/rmConfattr/{confattrlid}")
    @ApiOperation(value = "删除会议级别信息")
    public JSONResult rmConfattr(@PathVariable("confattrlid") int confattrlid) {
        ConfAttributes confAttributes = new ConfAttributes();
        confAttributes.setId(confattrlid);
        try {
            int affected = sysConfService.removeConfattr(confAttributes);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除会议属性信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmconfattr")
    @ApiOperation(value = "批量删除会议属性信息")
    public JSONResult bhrmconfattr(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveConfattrs(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改会议属性信息
     *
     * @param confAttributes
     * @return
     */
    @PostMapping("/mdconfattr")
    @ApiOperation(value = "修改会议属性信息")
    public JSONResult mdconfattr(@RequestBody(required = true) ConfAttributes confAttributes) {
        try {
            int affected = sysConfService.modifyConfattr(confAttributes);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }


    ///////////////////////////////////////////////////////////////

    /**
     * 分页查询所有会议状态信息
     *
     * @return
     */
    @PostMapping("/queryConfsts")
    @ApiOperation(value = "分页查询所有会议状态信息")
    public JSONResult queryConfsts(@RequestBody @Valid PagedQueryForm<ConfStatus_c> param) {
        try {
            PageInfo<ConfStatus> result = sysConfService.queryPagedConfsts(param);
            return JSONResult.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 新增会议状态信息
     *
     * @param confStatus
     * @return
     */
    @PostMapping("/addConfsts")
    @ApiOperation(value = "新增会议状态信息")
    public JSONResult addConfsts(@RequestBody(required = true) ConfStatus confStatus) {
        try {
            int affected = sysConfService.addConfStatus(confStatus);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("录入失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 删除会议状态信息
     *
     * @param confstsid
     * @return
     */
    @PostMapping("/rmConfsts/{confstsid}")
    @ApiOperation(value = "删除会议状态信息")
    public JSONResult rmConfsts(@PathVariable("confstsid") int confstsid) {
        ConfStatus confStatus = new ConfStatus();
        confStatus.setId(confstsid);
        try {
            int affected = sysConfService.removeConfsts(confStatus);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 批量删除会议状态信息
     *
     * @param arrs
     * @return
     */
    @PostMapping("/bhrmconfsts")
    @ApiOperation(value = "批量删除会议状态信息")
    public JSONResult bhrmconfsts(@RequestBody(required = true) int[] arrs) {
        try {
            int affected = sysConfService.batchRemoveConfsts(arrs);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("批量删除失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 修改会议状态信息
     *
     * @param confStatus
     * @return
     */
    @PostMapping("/mdconfsts")
    @ApiOperation(value = "修改会议状态信息")
    public JSONResult mdconfsts(@RequestBody(required = true) ConfStatus confStatus) {
        try {
            int affected = sysConfService.modifyConfsts(confStatus);
            return affected > 0 ? JSONResult.ok() : JSONResult.errorMsg("修改失败!");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**
     * 查询所有的二级部门
     */
    @PostMapping("/queryAllSecondDep")
    @ApiOperation(value = "查询所有的二级部门")
    public JSONResult queryAllSecondDep(@RequestBody PagedQueryForm<UsrSecDep_c> param) {
        return JSONResult.ok(sysConfService.queryChildDep(param));
    }

    /**
     * 删除二级部门
     *
     * @return
     */
    @PostMapping("/{childid}/removeChildDep")
    @ApiOperation(value = "删除二级部门")
    public JSONResult removeChildDep(@PathVariable(value = "childid", required = true) String childId) {
        Depchildrens depchildrens = new Depchildrens();
        depchildrens.setId(Integer.valueOf(childId));
        boolean result = sysConfService.delChildDep(depchildrens);
        return result ? JSONResult.ok() : JSONResult.errorMsg("删除二级部门失败");
    }

    /**
     * 更新二级部门的的信息
     *
     * @return
     */
    @PostMapping("/updateChildDep")
    @ApiOperation(value = "更新二级部门的信息")
    public JSONResult updateChildDep(@RequestBody Depchildrens depchildrens) {
        boolean result = sysConfService.updateSecondDep(depchildrens);
        return result ? JSONResult.ok() : JSONResult.errorMsg("对不起更新二级部门失败");
    }

    /**
     * 添加二级部门
     *
     * @param depchildrens
     * @return
     */
    @PostMapping("/addsecdep")
    @ApiOperation(value = "添加二级部门")
    public JSONResult addSecdep(@RequestBody Depchildrens depchildrens) {
        boolean result = sysConfService.adddepSec(depchildrens) > 0;
        return result ? JSONResult.ok() : JSONResult.errorMsg("添加二级部门失败");
    }


    /**
     * 查询所有的二级部门下的所有人员
     *
     * @param secdepid
     * @return
     */
    @PostMapping("/{secdepid}/queryUsecDep")
    @ApiOperation(value = "查询所有二级部门")
    public JSONResult queryUsecDep(@PathVariable(value = "secdepid") String secdepid) {
        return JSONResult.ok(sysConfService.querySecDepUsr(secdepid));
    }

    /**
     * 添加二级部门
     *
     * @param addUsrSecDep
     * @return
     */
    @PostMapping("/addUsrsecDep")
    @ApiOperation(value = "添加二级部门用户")
    public JSONResult addUsrsecDep(@RequestBody AddUsrSecDep addUsrSecDep) {
        Usrsecdep usrsecdep = new Usrsecdep();
        usrsecdep.setSecdepid(Integer.valueOf(addUsrSecDep.getSecdepid()));
        usrsecdep.setUsrid(Integer.valueOf(addUsrSecDep.getUsrid()));
        boolean flag = sysConfService.addUsrSecDep(usrsecdep);
        return flag ? JSONResult.ok() : JSONResult.errorMsg("添加二级部门失败");
    }


    /**
     * 删除用户二级部门关系
     * @param recorderid    关系编号
     * @return
     */
    @PostMapping("/{recorderid}/removeUsrSecDep")
    @ApiOperation(value="删除二级部门")
    public JSONResult removeUsrSecDep(@PathVariable(value = "recorderid")String recorderid) {
        Usrsecdep usrsecdep = new Usrsecdep();
        usrsecdep.setId(Integer.valueOf(recorderid));
        boolean flag = sysConfService.removeUsrSecDep(usrsecdep);
        return flag ? JSONResult.ok() : JSONResult.errorMsg("删除二级部门失败");
    }


}

