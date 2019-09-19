package com.justcs.config;

import com.justcs.utils.JwtFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 */

@Configuration
public class ShiroConfig {

    /**
     * LifecycleBeanPostProcessor这个的bean的作用是管理shiro中一些bean的生命周期。这是shiro的生命周期管理器
     * @return
     */
    @Bean(name="lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


    /**
     * 对密码进行编码，防止密码在数据库里面明码保存。登录认证将form输入密码编码。
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(2); //散列的次数
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * 获取自定义认证类，负责用户认证和权限处理
     * @return
     */
    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public MyReleam shiroRealm(){
        MyReleam releam = new MyReleam();
        releam.setCacheManager(new MemoryConstrainedCacheManager()); // 开启内存缓存
        return releam;
    }


    /**
     * 配置shiro在Web中提供的默认安全管理器bean
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());

        // 禁用掉shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }


    /**
     *  生成ShiroFilter的工厂类，维护securityManager, filters, filterChainDefinitionManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 添加我们自定义的JWT过滤器
        Map<String, Filter> myFilter = new HashMap<>();
        myFilter.put("jwt", new JwtFilter());
        shiroFilterFactoryBean.setFilters(myFilter);


        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/usr/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/just/unauth");

        // 注入URL拦截规则
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();

        // 给登录页面放行
        filterChainDefinitionManager.put("/usr/login", "anon");
        filterChainDefinitionManager.put("/comm/**", "anon");


        // 给swagger放行
        filterChainDefinitionManager.put("/shirotest/login**/**", "anon");
        filterChainDefinitionManager.put("/**.js", "anon");
        filterChainDefinitionManager.put("/**.css", "anon");
        filterChainDefinitionManager.put("/**.img", "anon");
        filterChainDefinitionManager.put("/**.html", "anon");
        filterChainDefinitionManager.put("/swagger**/**", "anon");
        filterChainDefinitionManager.put("/webjars/**", "anon");
        filterChainDefinitionManager.put("/v2/**", "anon");

        // 配置其他的url
        filterChainDefinitionManager.put("/logout", "logout");
        filterChainDefinitionManager.put("/just/unauth", "anon");
        filterChainDefinitionManager.put("/**", "jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);

        return shiroFilterFactoryBean;
    }



    /**
     * 自动创建代理
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }


    /**
     * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类,
     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor aASA = new AuthorizationAttributeSourceAdvisor();
        aASA.setSecurityManager(securityManager());
        return aASA;
    }


}
