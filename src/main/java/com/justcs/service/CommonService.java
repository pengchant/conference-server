package com.justcs.service;

import com.justcs.entity.Account;
import com.justcs.entity.Attendes;
import com.justcs.entity.Userinfo;
import com.justcs.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    /**
     * 用户注册
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
     * @param workerid
     * @param confid
     * @param status
     * @return
     */
    @Transactional
    public boolean attendConf(String workerid, String confid, String status) {
        if(StringUtils.isNotBlank(workerid)&&StringUtils.isNotBlank(confid)) {
            return attendesMapper.updateAttStatus(confid, workerid, status)> 0;
        }
        return false;
    }




}
