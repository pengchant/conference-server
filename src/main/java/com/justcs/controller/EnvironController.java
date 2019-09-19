package com.justcs.controller;

import com.justcs.form.TLoginForm;
import com.justcs.service.MenueService;
import com.justcs.utils.JSONResult;
import com.justcs.utils.JwtToken;
import com.justcs.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * 模拟登录接口（搭建环境）
 */
@RequestMapping("/environment")
@RestController
@Api(value = "模拟登录接口", description = "集成shiro之后的测试")
public class EnvironController {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(EnvironController.class);
//
//    @Autowired
//    private MenueService menueService;
//
//
//    /**
//     * 测试登录接口
//     *
//     * @param loginForm
//     * @return
//     */
//    @PostMapping("/login")
//    @ApiOperation(value = "登录测试接口", notes = "这是一个模拟登录的测试接口")
//    public JSONResult demotest(@Valid @RequestBody TLoginForm loginForm) {
//        logger.info("----登录，usearname:" + loginForm.getUsername() + ", pwd: " + loginForm.getPassword() + "----");
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            JwtToken token = new JwtToken(JwtUtil.sign(loginForm.getUsername(), loginForm.getPassword()));
//            subject.login(token);
//            // 登录成功后将权限，token等信息返回给前端
//            return JSONResult.ok(token);
//        } catch (AuthenticationException e) {
//            logger.error(e.toString());
//            return JSONResult.errorMsg("您的账号或密码输入有误!");
//        }
//    }
//
//
//    /**
//     * 获取所有的菜单
//     *
//     * @return
//     */
//    @PostMapping("/getmenu")
//    @ApiOperation(value = "查询菜单接口", notes = "加载用户的所有的菜单")
//    public JSONResult getmenu() {
//        logger.info("--查询用户的所有的权限--");
//        Map<String, Object> data = menueService.queryAllPrivileges();
//        return JSONResult.ok(data);
//    }


}
