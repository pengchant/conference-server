package com.justcs.controller;

import com.google.gson.Gson;
import com.justcs.config.MyReleam;
import com.justcs.entity.Account;
import com.justcs.entity.Userinfo;
import com.justcs.mapper.AccountMapper;
import com.justcs.utils.JSONResult;
import com.justcs.utils.RedisOperator;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户信息管理接口", description = "用户信息管理")
@RestController
@RequestMapping("/user")
public class UsrController {

    private static final Logger logger = LoggerFactory.getLogger(UsrController.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RedisOperator REDIS;

    /**
     * 根据token获取用户的信息
     * @param token
     * @return
     */
    @RequestMapping(value = "/info", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONResult queryUserByToken(@RequestParam(value = "token") String token) {
        String usrjson = REDIS.get(token);
        if(StringUtils.isNotBlank(usrjson)) {
            return JSONResult.ok(new Gson().fromJson(usrjson, Userinfo.class));
        }
        return JSONResult.errorMsg("失败");
    }

    /**
     * 用户退出登录接口
     * @param accid
     * @return
     */
    @RequestMapping(value = "/{accid}/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public JSONResult logout(@PathVariable(value = "accid", required = true)String accid,
                             @RequestParam(value = "token") String token) {
        Account account = accountMapper.selectByPrimaryKey(Integer.valueOf(accid));
        String tr = REDIS.get(token);
        if(account!=null && StringUtils.isNotBlank(tr)) {
            // 删除登录接口redis
            REDIS.del(token);
            // 删除accredis
            REDIS.del(MyReleam.PERFIX_ACCOUNT+account.getWorkerid());
            return JSONResult.ok("退出登录成功");
        }
        return JSONResult.errorMsg("退出失败!");
    }




}
