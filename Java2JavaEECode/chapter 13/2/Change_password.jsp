<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改密码</title>
</head>
<body>
<center>
修改您的密码
</center>
<!--  html:form接受用户输入  -->
<html:form action="change.do" method="post">
      <table border="0" cellspacing="0" cellpadding="0" align="left">
            <tr>
                  <td>用户名:</td>
                  <td><html:text property="username" /></td>
            </tr>
            <tr>
                  <td>旧密码:</td>
                  <!--  html:password用于输入密码  -->
                  <td><html:password property="password" /></td>
            </tr>
            <tr>
                  <td>新密码:</td>
                  <td><html:password property="newPassword" /></td>
            </tr>
            <tr>
                  <td>新密码确认:</td>
                  <td><html:password property="confirmPassword" /></td>
            </tr>
            <tr>
                  <td><html:submit property="change" value="确认" /> <input
                        type="button" value="返回"
                        onClick="location.href='/Example2/login.jsp'"></td>
            </tr>
      </table>
</html:form>
</body>
</html>
