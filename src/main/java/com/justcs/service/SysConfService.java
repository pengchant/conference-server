package com.justcs.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.*;
import com.justcs.mapper.*;
import com.sun.deploy.security.DeployManifestChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.PortableRemoteObject;

/**
 * 系统配置服务
 */
@Service
public class SysConfService {

    @Autowired
    private SemesterMapper semesterMapper;

    @Autowired
    private MpositionMapper mpositionMapper;

    @Autowired
    private DutyMapper dutyMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private ConflevelMapper conflevelMapper;

    @Autowired
    private ConfAttributesMapper confAttributesMapper;

    @Autowired
    private ConfStatusMapper confStatusMapper;

    @Autowired
    private DepchildrensMapper depchildrensMapper;

    @Autowired
    private UsrsecdepMapper usrsecdepMapper;

    /**
     * 分页查询所有的学期信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Semester> queryPagedSemester(PagedQueryForm<Semesters_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Semester> semesterPageInfo = new PageInfo<>(
                    semesterMapper.selectSemester(query.getSearch().getSemestername(), query.getSort(), query.getOrder())
            );
            return semesterPageInfo;
        }
        return null;
    }

    /**
     * 添加学期
     *
     * @param semester
     * @return
     */
    @Transactional
    public int addSemester(Semester semester) {
        if (semester != null) {
            return semesterMapper.insertSelective(semester);
        }
        return 0;
    }

    /**
     * 根据主键修改学期
     *
     * @param semester
     * @return
     */
    @Transactional
    public int modifySemester(Semester semester) {
        if (semester != null && semester.getId() != null) {
            return semesterMapper.updateByPrimaryKeySelective(semester);
        }
        return 0;
    }

    /**
     * 根据主键删除学期
     *
     * @param semester
     * @return
     */
    @Transactional
    public int removeSemester(Semester semester) {
        if (semester != null && semester.getId() != null) {
            return semesterMapper.deleteByPrimaryKey(semester.getId());
        }
        return 0;
    }

    /**
     * 批量删除学期信息
     *
     * @param semesters
     * @return
     */
    @Transactional
    public int batchRemoveSemester(int[] semesters) {
        if (semesters != null && semesters.length > 0) {
            return semesterMapper.batchDeleteSemester(semesters);
        }
        return 0;
    }


    /////////////////////////////////////////////////////////////////////

    /**
     * 分页查询所有的职务信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Mposition> queryPagedPosition(PagedQueryForm<MPosition_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Mposition> mpositionPageInfo = new PageInfo<>(
                    mpositionMapper.selectPosition(query.getSearch().getPosname(), query.getSort(), query.getOrder())
            );
            return mpositionPageInfo;
        }
        return null;
    }


    /**
     * 添加职位
     *
     * @param mposition
     * @return
     */
    @Transactional
    public int addPosition(Mposition mposition) {
        if (mposition != null) {
            return mpositionMapper.insertSelective(mposition);
        }
        return 0;
    }

    /**
     * 根据主键修改职位
     *
     * @param mposition
     * @return
     */
    @Transactional
    public int modifyPosition(Mposition mposition) {
        if (mposition != null && mposition.getId() != null) {
            return mpositionMapper.updateByPrimaryKeySelective(mposition);
        }
        return 0;
    }

    /**
     * 根据主键删除职务
     *
     * @param mposition
     * @return
     */
    @Transactional
    public int removePosition(Mposition mposition) {
        if (mposition != null && mposition.getId() != null) {
            return mpositionMapper.deleteByPrimaryKey(mposition.getId());
        }
        return 0;
    }

    /**
     * 批量删除职务信息
     *
     * @param positions
     * @return
     */
    @Transactional
    public int batchRemovePosition(int[] positions) {
        if (positions != null && positions.length > 0) {
            return mpositionMapper.batchDeletePosition(positions);
        }
        return 0;
    }

    //////////////////////////////////////////////////////////

    /**
     * 分页查询所有的职位信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Duty> queryPagedDuty(PagedQueryForm<Duty_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Duty> dutyPageInfo = new PageInfo<Duty>(
                    dutyMapper.selectDuty(query.getSearch().getDutyname(), query.getSort(), query.getOrder())
            );
            return dutyPageInfo;
        }
        return null;
    }


    /**
     * 添加职位信息
     *
     * @param duty
     * @return
     */
    @Transactional
    public int addDuty(Duty duty) {
        if (duty != null) {
            return dutyMapper.insertSelective(duty);
        }
        return 0;
    }

    /**
     * 根据主键修改职位
     *
     * @param duty
     * @return
     */
    @Transactional
    public int modifyDuty(Duty duty) {
        if (duty != null && duty.getId() != null) {
            return dutyMapper.updateByPrimaryKeySelective(duty);
        }
        return 0;
    }

    /**
     * 根据主键删除职务
     *
     * @param duty
     * @return
     */
    @Transactional
    public int removeDuty(Duty duty) {
        if (duty != null && duty.getId() != null) {
            return dutyMapper.deleteByPrimaryKey(duty.getId());
        }
        return 0;
    }

    /**
     * 批量删除职务信息
     *
     * @param ids
     * @return
     */
    @Transactional
    public int batchRemoveDuty(int[] ids) {
        if (ids != null && ids.length > 0) {
            return dutyMapper.batchDeleteDuty(ids);
        }
        return 0;
    }


    ///////////////////////////////////////////////////////////

    /**
     * 分页查询所有的部门信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Department> queryPagedDep(PagedQueryForm<Department_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Department> departmentPageInfo = new PageInfo<>(
                    departmentMapper.selectDepartments(query.getSearch().getDepartmentname(), query.getSort(), query.getOrder())
            );
            return departmentPageInfo;
        }
        return null;
    }


    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    @Transactional
    public int addDepartment(Department department) {
        if (department != null) {
            return departmentMapper.insertSelective(department);
        }
        return 0;
    }

    /**
     * 根据主键修改部门
     *
     * @param department
     * @return
     */
    @Transactional
    public int modifyDepartment(Department department) {
        if (department != null && department.getId() != null) {
            return departmentMapper.updateByPrimaryKeySelective(department);
        }
        return 0;
    }

    /**
     * 根据主键删除部门
     *
     * @param department
     * @return
     */
    @Transactional
    public int removeDepartment(Department department) {
        if (department != null && department.getId() != null) {
            return departmentMapper.deleteByPrimaryKey(department.getId());
        }
        return 0;
    }

    /**
     * 批量删除部门信息
     *
     * @param departments
     * @return
     */
    @Transactional
    public int batchRemoveDepartment(int[] departments) {
        if (departments != null && departments.length > 0) {
            return departmentMapper.batchDeletePosition(departments);
        }
        return 0;
    }

    //////////////////////////////////////////////////////////////////////////

    /**
     * 分页查询所有的会议级别信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Conflevel> queryPagedConfLevel(PagedQueryForm<ConfLevel_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Conflevel> conflevelPageInfo = new PageInfo<>(
                    conflevelMapper.selectConfLevels(query.getSearch().getLevelname(), query.getSort(), query.getOrder())
            );
            return conflevelPageInfo;
        }
        return null;
    }


    /**
     * 添加会议级别
     *
     * @param conflevel
     * @return
     */
    @Transactional
    public int addConfLevels(Conflevel conflevel) {
        if (conflevel != null) {
            return conflevelMapper.insertSelective(conflevel);
        }
        return 0;
    }

    /**
     * 根据主键修改会议级别
     *
     * @param conflevel
     * @return
     */
    @Transactional
    public int modifyConfLevel(Conflevel conflevel) {
        if (conflevel != null && conflevel.getId() != null) {
            return conflevelMapper.updateByPrimaryKeySelective(conflevel);
        }
        return 0;
    }

    /**
     * 根据主键删除会议级别
     *
     * @param conflevel
     * @return
     */
    @Transactional
    public int removeConflevel(Conflevel conflevel) {
        if (conflevel != null && conflevel.getId() != null) {
            return conflevelMapper.deleteByPrimaryKey(conflevel.getId());
        }
        return 0;
    }

    /**
     * 批量删除会议级别
     *
     * @param conflevels
     * @return
     */
    @Transactional
    public int batchRemoveConflevels(int[] conflevels) {
        if (conflevels != null && conflevels.length > 0) {
            return conflevelMapper.batchDeleteConfLevel(conflevels);
        }
        return 0;
    }


    /////////////////////////////////////////////////////////////

    /**
     * 分页查询所有的会议属性信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<ConfAttributes> queryPagedConfattr(PagedQueryForm<ConfAttr_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<ConfAttributes> confAttributesPageInfo = new PageInfo<>(
                    confAttributesMapper.selectConfAttrs(query.getSearch().getAttrname(), query.getSort(), query.getOrder())
            );
            return confAttributesPageInfo;
        }
        return null;
    }


    /**
     * 添加会议属性
     *
     * @param confAttributes
     * @return
     */
    @Transactional
    public int addConfAttrs(ConfAttributes confAttributes) {
        if (confAttributes != null) {
            return confAttributesMapper.insertSelective(confAttributes);
        }
        return 0;
    }

    /**
     * 根据主键修改会议属性
     *
     * @param confAttributes
     * @return
     */
    @Transactional
    public int modifyConfattr(ConfAttributes confAttributes) {
        if (confAttributes != null && confAttributes.getId() != null) {
            return confAttributesMapper.updateByPrimaryKeySelective(confAttributes);
        }
        return 0;
    }

    /**
     * 根据主键删除会议属性
     *
     * @param confAttributes
     * @return
     */
    @Transactional
    public int removeConfattr(ConfAttributes confAttributes) {
        if (confAttributes != null && confAttributes.getId() != null) {
            return confAttributesMapper.deleteByPrimaryKey(confAttributes.getId());
        }
        return 0;
    }

    /**
     * 批量删除会议属性
     *
     * @param confattrs
     * @return
     */
    @Transactional
    public int batchRemoveConfattrs(int[] confattrs) {
        if (confattrs != null && confattrs.length > 0) {
            return confAttributesMapper.batchDeleteConfattr(confattrs);
        }
        return 0;
    }


    //////////////////////////////////////////////////////////

    /**
     * 分页查询所有的会议状态信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<ConfStatus> queryPagedConfsts(PagedQueryForm<ConfStatus_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<ConfStatus> confStatusPageInfo = new PageInfo<>(
                    confStatusMapper.selectConfStatus(
                            query.getSearch().getStatusname(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
            return confStatusPageInfo;
        }
        return null;
    }


    /**
     * 添加会议状态
     *
     * @param confStatus
     * @return
     */
    @Transactional
    public int addConfStatus(ConfStatus confStatus) {
        if (confStatus != null) {
            return confStatusMapper.insertSelective(confStatus);
        }
        return 0;
    }

    /**
     * 根据主键修改会议状态
     *
     * @param confStatus
     * @return
     */
    @Transactional
    public int modifyConfsts(ConfStatus confStatus) {
        if (confStatus != null && confStatus.getId() != null) {
            return confStatusMapper.updateByPrimaryKeySelective(confStatus);
        }
        return 0;
    }

    /**
     * 根据主键删除会议状态
     *
     * @param confStatus
     * @return
     */
    @Transactional
    public int removeConfsts(ConfStatus confStatus) {
        if (confStatus != null && confStatus.getId() != null) {
            return confStatusMapper.deleteByPrimaryKey(confStatus.getId());
        }
        return 0;
    }

    /**
     * 批量删除会议状态
     *
     * @param confsts
     * @return
     */
    @Transactional
    public int batchRemoveConfsts(int[] confsts) {
        if (confsts != null && confsts.length > 0) {
            return confStatusMapper.batchDeleteConfStatus(confsts);
        }
        return 0;
    }


    /**
     * 根据编号分页查询所有子部门
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<Depchildrens> queryChildDep(PagedQueryForm<UsrSecDep_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<Depchildrens> result = new PageInfo<>(
                    depchildrensMapper.selectByDepId(
                            query.getSearch().getDepid(),
                            query.getSort(),
                            query.getOrder()
                    )
            );
            return result;
        }
        return null;
    }

    /**
     * 删除子部门信息
     */
    @Transactional
    public boolean delChildDep(Depchildrens depchildrens) {
        if (depchildrens != null) {
            return depchildrensMapper.deleteByPrimaryKey(depchildrens.getId()) > 0;
        }
        return false;
    }

    /**
     * 更新子部门信息
     */
    @Transactional
    public boolean updateSecondDep(Depchildrens depchildrens) {
        if (depchildrens != null) {
            return depchildrensMapper.updateByPrimaryKeySelective(depchildrens) > 0;
        }
        return false;
    }

    /**
     * 添加二级部门
     * @param depchildrens
     * @return
     */
    @Transactional
    public int adddepSec(Depchildrens depchildrens) {
        if (depchildrens != null) {
            return depchildrensMapper.insertSelective(depchildrens);
        }
        return 0;
    }


}
