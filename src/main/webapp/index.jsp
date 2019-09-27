<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.jasig.cas.client.authentication.AttributePrincipal"%>
<%@page import="org.jasig.cas.client.util.AssertionHolder"%>
<%@page import="org.jasig.cas.client.validation.Assertion"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.justcs.utils.EncodingUtil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
    try {
        String loginName = null;
        AttributePrincipal principal = null;
        Assertion assertion = AssertionHolder.getAssertion();
        if (assertion != null) {
            principal = assertion.getPrincipal();
            if (principal != null) {
                loginName = principal.getName();
            }
        }
        if (loginName == null) {
            out.println("登录失败,请重新登录"); // 一般不会执行到这步
        } else {
            // 获取用户的信息
            String workerid = loginName;
            // 姓名
            String usrname = (String) principal.getAttributes().get("Name");
            out.println("登录成功，欢迎您,工号:" + loginName + ",姓名:" + usrname);
            String str = EncodingUtil.base64Encode(workerid, usrname);
            // 登录完成后跳转
            response.sendRedirect("http://dzhy.just.edu.cn/v/#/login?redirect=%2Fdashboard&_justinfo=" + str);
        }
    } catch (Exception e) {
        out.print("sorry,系统正在维护中，请稍后重试...");
    }

%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>高校党政云会议记录管理平台</title>
</head>
<body>
<%--<a href="http://ids2.just.edu.cn/cas/logout?service=<%=java.net.URLEncoder.encode("http://dzhy.just.edu.cn", "UTF-8")%>">退出</a>--%>
</body>
</html>