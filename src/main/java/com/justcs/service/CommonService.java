package com.justcs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.justcs.entity.*;
import com.justcs.form.PagedQueryForm;
import com.justcs.form.UsrInfo_c;
import com.justcs.mapper.*;
import com.justcs.view.UsrInfoView;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 通用服务
 */
@Transactional
@Service
public class CommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private UsrPositionMapper usrPositionMapper;

    @Autowired
    private UsrdepMapper usrdepMapper;

    @Autowired
    private AttendesMapper attendesMapper;

    @Autowired
    private UsrDutyMapper usrDutyMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 用户注册
     *
     * @param account
     * @param userinfo
     * @param usrpos
     * @param usrdep
     * @return
     */
    @Transactional
    public boolean registUser(Account account, Userinfo userinfo, List<Integer> usrpos, List<Integer> usrdep) {
        // 1.插入账户表
        accountMapper.insertSelective(account);
        // 2.插入用户信息表
        userinfo.setAccid(account.getId());
        userinfoMapper.insertSelective(userinfo);
        // 3.录入用户职务(批量)
        int affected_1 = usrPositionMapper.batchInsert(userinfo.getId(), usrpos);
        // 4.录入用户所属部门表(批量)
        int affected_2 = usrdepMapper.batchInsertUsrdep(userinfo.getId(), usrdep);
        return true;
    }

    /**
     * 用户签到
     *
     * @param workerid
     * @param confid
     * @param status
     * @return
     */
    @Transactional
    public boolean attendConf(String workerid, String confid, String status) {
        if (StringUtils.isNotBlank(workerid) && StringUtils.isNotBlank(confid)) {
            return attendesMapper.updateAttStatus(confid, workerid, status) > 0;
        }
        return false;
    }


    /**
     * 分页查询用户的信息
     *
     * @param query
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo<UsrInfoView> queryPagedUsrinfo(PagedQueryForm<UsrInfo_c> query) {
        if (query != null) {
            PageHelper.startPage(query.getPage(), query.getPagesize());
            PageInfo<UsrInfoView> semesterPageInfo = new PageInfo<>(
                    userinfoMapper.selectUsrInfoView(
                            query.getSearch().getDepname(),
                            query.getSearch().getUsrname(),
                            query.getSort(),
                            query.getOrder())
            );
            return semesterPageInfo;
        }
        return null;
    }


    /**
     * 修改用户信息
     *
     * @param account
     * @param userinfo
     * @param usrdepKeys
     * @param usrPositionKeys
     * @param usrDutyKeys
     * @param userRoleKeys
     * @return
     */
    @Transactional
    public int modifyUsrInfo(Account account,
                             Userinfo userinfo,
                             List<Integer> usrdepKeys,
                             List<Integer> usrPositionKeys,
                             List<Integer> usrDutyKeys,
                             List<Integer> userRoleKeys) {
        int temfalg = 0;
        // 修改acc
        if (account == null || account.getId() == null) {
            return -1;
        }
        Account _dbaccount = accountMapper.selectByPrimaryKey(account.getId());
        if (_dbaccount == null) {
            return -1;
        }
        _dbaccount.setEmail(account.getEmail());
        _dbaccount.setPhonenum(account.getPhonenum());
        temfalg = accountMapper.updateByPrimaryKeySelective(_dbaccount);
        if (temfalg == 0) {
            return -1;
        } else {
            temfalg = 0;
        }

        // 修改usrinfo
        if (userinfo == null || userinfo.getId() == null) {
            return -1;
        }
        Userinfo _dbusrinfo = userinfoMapper.selectByPrimaryKey(userinfo.getId());
        if (_dbusrinfo == null) {
            return -1;
        }
        _dbusrinfo.setUsrname(userinfo.getUsrname());
        temfalg = userinfoMapper.updateByPrimaryKeySelective(_dbusrinfo);
        if (temfalg == 0) {
            return -1;
        } else {
            temfalg = 0;
        }

        // 删除usrdep,添加usrdep
        if (usrdepKeys != null && usrdepKeys.size() > 0) {
            usrdepMapper.deleteUsrDeps(userinfo.getId());
            usrdepMapper.batchInsertUsrdep(userinfo.getId(), usrdepKeys);
        }


        if (usrPositionKeys != null && usrPositionKeys.size() > 0) {
            // 删除usrposition, 添加usrposition
            usrPositionMapper.deleteUsrPositions(userinfo.getId());
            usrPositionMapper.batchInsert(userinfo.getId(), usrPositionKeys);
        }

        if (usrDutyKeys != null && usrDutyKeys.size() > 0) {
            // 删除usrduty,添加usrduty
            usrDutyMapper.deleteUsrDutys(userinfo.getId());
            usrDutyMapper.batchInsert(userinfo.getId(), usrDutyKeys);
        }

        if (userRoleKeys != null && userRoleKeys.size() > 0) {
            // 删除usrrole,添加usrrole
            userRoleMapper.deleteUsrRoles(account.getId());
            userRoleMapper.batchInsert(account.getId(), userRoleKeys);
        }

        return 1;
    }
}
