package com.justcs.utils;

import com.google.gson.Gson;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * jwt与shiro集成，自定义jwt过滤器来作为shiro的过滤器
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);


    private static final String LOGIN_SIGN = "x-token";


    /**
     * 判断用户是否是否想要登录，检测header中是否包含x-token
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(JwtFilter.LOGIN_SIGN);
        return authorization != null;
    }

    /**
     * 执行登录认证
     *
     * @param request
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        logger.info("*********jwtfilter-登录认证***********");
        if (isLoginAttempt(request, response)) {
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                response401(request, response);
            }
        }
        return true;
    }


    /**
     * 执行登录逻辑
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        logger.info("************executeLogin************");
        try {
            HttpServletRequest httpreq = (HttpServletRequest) request;
            String token = httpreq.getHeader(JwtFilter.LOGIN_SIGN);
            JwtToken jwtToken = new JwtToken(token);
            // 提交给realm进行登录，如果错误会抛出异常并被捕获
            getSubject(request, response).login(jwtToken);
            // 如果登录成功查看是否需要重新刷新token

        } catch (AuthenticationException e) {
            throw new AuthenticationException("验证登录逻辑失败");
        }
        return true;
    }


    /**
     * 跳转到未授权接口
     * @param req
     * @param resp
     */
    private void response401(ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter outer = httpServletResponse.getWriter();
            outer.println(new Gson().toJson(JSONResult.unauthException("未曾授权访问接口", null)));
            outer.flush();
            outer.close();
        } catch (IOException e) {
            logger.error("请求跳转到未授权异常");
        }
    }

}
