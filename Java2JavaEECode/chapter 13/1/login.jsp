<!--  由于页面上采用中文,所以采用utf-8字符集  -->
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
    
<!--  定义所用到的struts标签库  -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
</head>
<body>
<!--  html:form用以得到用户输入  -->
<html:form action="login.do" method="post">
  	   <!--  html:text定义文本输入框  -->
  	   用户名: <html:text size="15" property="username" />
  	   <br>
  	   密码: <html:text size="15" property="password" />
  	   <br>
  	   <!--  html:submit定义表单提交按钮  -->
  	   <html:submit property="login" value="确定" />
</html:form>
</body>
</html>
