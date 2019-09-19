package com.justcs.controller;

import com.google.gson.Gson;
import com.justcs.entity.Account;
import com.justcs.entity.Userinfo;
import com.justcs.form.LoginForm;
import com.justcs.form.UserRegistForm;
import com.justcs.form.UsrAttendForm;
import com.justcs.mapper.*;
import com.justcs.service.CommonService;
import com.justcs.service.ConfOrderService;
import com.justcs.utils.*;
import com.justcs.view.CurDepUsrView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Api(value = "公用的接口可以直接对外暴露", description = "公共接口")
@RequestMapping("/comm")
@RestController
public class CommonController {

    @Autowired
    private RedisOperator REDIS;

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private MpositionMapper mpositionMapper;

    @Autowired
    private ConflevelMapper conflevelMapper;

    @Autowired
    private ConfAttributesMapper confAttributesMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SemesterMapper semesterMapper;

    @Autowired
    private DutyMapper dutyMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ConfOrderService confOrderService;

    /**
     * 查询所有的职位
     *
     * @return
     */
    @ApiOperation(value = "查询所有的职位")
    @PostMapping("/allpositon")
    public JSONResult queryAllPosition() {
        return JSONResult.ok(mpositionMapper.selectAllPosition());
    }

    /**
     * 查询所有的部门
     *
     * @return
     */
    @ApiOperation(value = "查询所有的部门")
    @PostMapping("/alldepartment")
    public JSONResult queryAllDep() {
        return JSONResult.ok(departmentMapper.selectAllDepartment());
    }

    /**
     * 查询所有会议级别
     *
     * @return
     */
    @ApiOperation(value = "查询所有会议级别")
    @PostMapping("/allconflevel")
    public JSONResult queryAllConflevel() {
        return JSONResult.ok(conflevelMapper.selectAllConflevel());
    }

    /**
     * 查询所有会议属性
     *
     * @return
     */
    @ApiOperation(value = "查询所有会议属性")
    @PostMapping("/allconfattr")
    public JSONResult queryAllConfAttr() {
        return JSONResult.ok(confAttributesMapper.selectAllConfAttrs());
    }


    /**
     * 查询所有学期
     *
     * @return
     */
    @ApiOperation(value = "查询所有会议属性")
    @PostMapping("/allsemesters")
    public JSONResult queryallsemesters() {
        return JSONResult.ok(semesterMapper.selectAllSemester());
    }


    /**
     * 查询所有职务
     *
     * @return
     */
    @ApiOperation(value = "查询所有职务")
    @PostMapping("/allduty")
    public JSONResult queryallallduty() {
        return JSONResult.ok(dutyMapper.selectAllDutys());
    }


    /**
     * 注册用户信息
     *
     * @return
     */
    @ApiOperation(value = "注册用户信息")
    @PostMapping("/registuser")
    public JSONResult registuser(@RequestBody @Valid UserRegistForm userRegistForm) {
        logger.info(new Gson().toJson(userRegistForm));
        // 账户信息
        Account account = new Account();
        account.setWorkerid(userRegistForm.getWorkerid());
        account.setRegisttime(new Date(System.currentTimeMillis()));
        account.setPwd(userRegistForm.getPassword());
        account.setUserstatus(Constraints.USESR_REGISTERED);
        // 用户信息
        Userinfo userinfo = new Userinfo();
        userinfo.setUsrname(userRegistForm.getWorkername());
        // 用户职务
        List<Integer> postions = userRegistForm.getPosselected();
        // 用户所属部门
        List<Integer> departments = userRegistForm.getDepselected();
        try {
            commonService.registUser(account, userinfo, postions, departments);
            return JSONResult.ok("恭喜你注册成功!");
        } catch (Exception e) {
            logger.info("注册用户信息异常");
            return JSONResult.errorMsg("注册失败请稍后重试，或者检查您的账号是否被注册");
        }
    }


    /**
     * 用户登录接口
     *
     * @param loginForm
     * @return
     */
    @ApiOperation(value = "用户登录接口", notes = "用户登录")
    @PostMapping("/login")
    public JSONResult usrlogin(@RequestBody @Valid LoginForm loginForm) {
        logger.info("--登录-- username:" + loginForm.getAccount());
        Subject subject = SecurityUtils.getSubject();
        try {
            JwtToken token = new JwtToken(JwtUtil.sign(loginForm.getAccount(), loginForm.getPassword()));
            subject.login(token);
            // 将token => 用户账户信息(json格式) 放到redis中 30min后失效
            Account account = accountMapper.selectByAccount(loginForm.getAccount());
            Userinfo userinfo = accountMapper.selectByUsername(String.valueOf(account.getId()));
            String userinfostr = new Gson().toJson(userinfo);
            REDIS.set(token.getCredentials().toString(), userinfostr, 12*60*60*1); // 设置12个小时
            // 将token返回给前端
            return JSONResult.ok(token.getCredentials());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JSONResult.errorMsg("对不起您的账号或者密码输入错误");
        }
    }

    /**
     * 用户签到
     *
     * @param usrAttendForm
     * @return
     */
    @ApiOperation(value = "用户签到", notes = "用户签到接口")
    @PostMapping("/attendtag")
    public JSONResult attendTag(@RequestBody @Valid UsrAttendForm usrAttendForm) {
        logger.info("--用户签到--");
        boolean flag = commonService.attendConf(usrAttendForm.getWorkerid(), usrAttendForm.getConfid(), "1");
        if (flag) {
            // 查询所有用户
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("对不起签到失败，请稍后重试!");
    }

    /**
     * 用户取消签到
     *
     * @param usrAttendForm
     * @return
     */
    @ApiOperation(value = "用户取消签到", notes = "取消签到接口")
    @PostMapping("/cancelattendtag")
    public JSONResult cancelattendtag(@RequestBody @Valid UsrAttendForm usrAttendForm) {
        logger.info("--用户取消签到--");
        boolean flag = commonService.attendConf(usrAttendForm.getWorkerid(), usrAttendForm.getConfid(), "0");
        if (flag) {
            // 查询所有用户
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("操作失败，请稍后重试!");
    }


    /**
     * 查询该用户下所有部门的用户信息
     * @param accid
     * @return
     */
    @ApiOperation(value = "查询该用户下所有部门的用户信息")
    @PostMapping("/getcurdepusr/{accid}")
    public JSONResult queryCurDepCurUsr(@PathVariable(value = "accid")Integer accid) {
        List<CurDepUsrView> curDepUsrViews = confOrderService.queryCurDepUsrViews(accid);
        if(curDepUsrViews != null) {
            return JSONResult.ok(curDepUsrViews);
        }
        return JSONResult.errorMsg("查询本部门用户信息失败!");
    }
}