<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--  ÃÜÂëÐÞ¸Ä´íÎóÒ³Ãæ  -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ÐÞ¸ÄÃÜÂëÊ§°Ü</title>
</head>
<body>
<!--  Ê¹ÓÃbean:write±êÇ©Êä³ö´íÎóÐÅÏ¢  -->
<bean:write name="loginForm" property="errorMessage" />
<br>
<a href="javascript:window.location('/Example2/change_password.jsp')">·µ»Ø</a>
</body>
</html>
