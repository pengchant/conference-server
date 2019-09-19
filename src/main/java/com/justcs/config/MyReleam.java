package com.justcs.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.justcs.entity.Account;
import com.justcs.entity.Privilege;
import com.justcs.entity.Role;
import com.justcs.mapper.AccountMapper;
import com.justcs.utils.JwtToken;
import com.justcs.utils.JwtUtil;
import com.justcs.utils.RedisOperator;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义Releam
 */
public class MyReleam extends AuthorizingRealm {

    private static final Logger loggger = LoggerFactory.getLogger(MyReleam.class);

    /**
     * redis中用户角色列表值，key前缀 + {userid}
     */
    public static final String PREFIX_USER_ROLES = "PREFIX_USER_ROLES_";

    /**
     * redis中用户权限列表值，key前缀 + {userid}
     */
    public static final String PERFIX_USER_PRIVILEGES = "PERFIX_USER_PRIVILEGES_";


    @Resource
    private AccountMapper accountMapper;

    @Autowired
    private RedisOperator REDIS;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权方法，告知shiro该用户能够获取那些权限，只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        loggger.info("=========用户授权==========");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取当前用户的信息
        Account user = (Account) principalCollection.getPrimaryPrincipal();
        int usrid = Integer.valueOf(user.getId());

        // 用户角色列表
        List<Role> roles = null;
        // 用户权限列表
        List<Privilege> privileges = null;

        // 优先从redis中查询用户的角色
        String resourceStr = REDIS.get(MyReleam.PREFIX_USER_ROLES + user.getId());
        if (resourceStr != null) {
            roles = new Gson().fromJson(resourceStr, TypeToken.getParameterized(List.class, Role.class).getType());
        } else {
            // 从数据库中查询放到redis中
            roles = accountMapper.selectRolesById(usrid);
            REDIS.set(MyReleam.PREFIX_USER_ROLES + user.getId(),
                    new Gson().toJson(roles), 30*60); // timeout:以秒为单位
        }

        // 优先从redis中查询用户的权限
        String privilegesStr = REDIS.get(MyReleam.PERFIX_USER_PRIVILEGES + user.getId());
        if(privilegesStr != null){
            privileges = new Gson().fromJson(privilegesStr, TypeToken.getParameterized(List.class, Privilege.class).getType());
        } else {
            // 从数据库中查询放到redis中
            privileges = accountMapper.selectPrivBysId(usrid);
            REDIS.set(MyReleam.PERFIX_USER_PRIVILEGES + user.getId(),
                    new Gson().toJson(privileges), 30*60);
        }

        // 赋予角色
        for (Role r : roles) {
            info.addRole(r.getKeyname());
        }
        // 赋予权限
        for (Privilege p : privileges) {
            info.addStringPermission(p.getKeyname());
        }
        return info;
    }

    /**
     * 认证方法，告知shiro是谁在登录(用户登录调用)
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        loggger.info("==============登录认证=============");

        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }

        Account user = accountMapper.selectByAccount(username);
        // 判断用户是否存在
        if (user == null) {
            throw new AuthenticationException("用户不存在");
        }

        // 判断用户名和密码是否错误
        if (!JwtUtil.verify(token, username, user.getPwd())) {
            throw new AuthenticationException("token非法");
        }

        return new SimpleAuthenticationInfo(
                user,
                token,
                this.getClass().getName()); // 安全管理器负责比对

    }
}
