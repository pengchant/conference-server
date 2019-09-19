package com.justcs.config;

//@Configuration
public class SOSConfig {

//    /**
//     * 可选配置，单点注销监听器
//     * @return
//     */
//    @Bean
//    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> SingleSignOutHttpSessionListener() {
//        return new ServletListenerRegistrationBean<>(
//          new org.jasig.cas.client.session.SingleSignOutHttpSessionListener()
//        );
//    }
//
//
//    /**
//     * 可选配置，单点注销过滤器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean SingleSignOutFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new SingleSignOutFilter());
//        // registration.addUrlPatterns("/*");
//        registration.addUrlPatterns("/sso/*");
//        return registration;
//    }
//
//    /**
//     * 必选配置，拦截SSO登录请求
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean AuthenticationFilter(){
//        FilterRegistrationBean registration = new FilterRegistrationBean(new AuthenticationFilter());
//       //  registration.addUrlPatterns("/*");
//        registration.addUrlPatterns("/sso/*");
//
//        Map<String, String> initParameters = new HashMap();
//        initParameters.put("renew", "false");
//        initParameters.put("gateway", "false");
//        initParameters.put("casServerLoginUrl", "http://ids2.just.edu.cn/cas/login");
//        initParameters.put("serverName", "http://localhost:9999");
//        registration.setInitParameters(initParameters);
//        return registration;
//    }
//
//    /**
//     * 拦截登录后返回的跳转请求，如果有Ticket则到CAS Server校验获取用户
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean Cas20ProxyReceivingTicketValidationFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new Cas20ProxyReceivingTicketValidationFilter());
//        registration.addUrlPatterns("/*");
//        registration.addUrlPatterns("/sso/*");
//
//        Map<String, String> initParameters = new HashMap();
//        initParameters.put("useSession", "true");
//        initParameters.put("redirectAfterValidation", "true");
//        initParameters.put("casServerUrlPrefix", "http://ids2.just.edu.cn/cas/");
//        initParameters.put("serverName", "http://localhost:9999");
//        registration.setInitParameters(initParameters);
//        return registration;
//    }
//
//
//    /**
//     * 封装CAS Server返回的信息到Http Request
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean HttpServletRequestWrapperFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new HttpServletRequestWrapperFilter());
//        registration.addUrlPatterns("/*");
//        return registration;
//    }
//
//    /**
//     * 封装CAS Server返回信息
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean AssertionThreadLocalFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new AssertionThreadLocalFilter());
//        registration.addUrlPatterns("/*");
//        return registration;
//    }


}
