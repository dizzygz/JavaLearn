<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>µÇÂ½</title>
</head>
<body>
<center>
ÇëÊäÈëÄúµÄÓÃ»§ÃûºÍÃÜÂëµÇÂ½
</center>
<html:form action="login.do" method="post">
      <table border="0" cellspacing="0" cellpadding="0" align="left">
            <tr>
                  <td>ÓÃ»§Ãû:</td>
                  <td><html:text property="username" /></td>
            </tr>
            <tr>
                  <td>ÃÜÂë£º</td>
                  <td><html:password property="password" /></td>
            </tr>
            <tr>
                  <td><html:submit property="login" value="µÇÂ½" /></td>
                  <td><input type="button" value="ÐÞ¸ÄÃÜÂë"
                        onClick="location.href='/Example2/change_password.
                             jsp'"></td>
            </tr>
      </table>
</html:form>
</body>
</html>
