<%@ page language="java" contentType="text/html; charset=utf-8"page
Encoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--  µÇÂ½³É¹¦Ò³Ãæ  -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>µÇÂ½³É¹¦</title>
</head>
<body>
»¶Ó­Äú:
<bean:write name="loginForm" property="username" />
</body>
</html>
