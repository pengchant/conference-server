<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.jasig.cas.client.authentication.AttributePrincipal"%>
<%@page import="org.jasig.cas.client.util.AssertionHolder"%>
<%@page import="org.jasig.cas.client.validation.Assertion"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    String loginName = null;
    Assertion assertion = AssertionHolder.getAssertion();
    if (assertion != null) {
        AttributePrincipal principal = assertion.getPrincipal();
        if (principal != null) {
            loginName = principal.getName();
        }
    }
    if (loginName == null) {
        out.println("登录失败");
    } else {
        out.println("登录成功，欢迎您：" + loginName);
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>统一认证登录测试</title>
    </head>
    <body>
        <a href="http://ids2.just.edu.cn/cas/logout?service=<%=java.net.URLEncoder.encode("http://localhost:9999/conferencem/sso/ssoLogin.jsp", "UTF-8")%>">退出</a>
    </body>
</html>