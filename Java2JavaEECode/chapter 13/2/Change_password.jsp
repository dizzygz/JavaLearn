<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>�޸�����</title>
</head>
<body>
<center>
�޸���������
</center>
<!--  html:form�����û�����  -->
<html:form action="change.do" method="post">
      <table border="0" cellspacing="0" cellpadding="0" align="left">
            <tr>
                  <td>�û���:</td>
                  <td><html:text property="username" /></td>
            </tr>
            <tr>
                  <td>������:</td>
                  <!--  html:password������������  -->
                  <td><html:password property="password" /></td>
            </tr>
            <tr>
                  <td>������:</td>
                  <td><html:password property="newPassword" /></td>
            </tr>
            <tr>
                  <td>������ȷ��:</td>
                  <td><html:password property="confirmPassword" /></td>
            </tr>
            <tr>
                  <td><html:submit property="change" value="ȷ��" /> <input
                        type="button" value="����"
                        onClick="location.href='/Example2/login.jsp'"></td>
            </tr>
      </table>
</html:form>
</body>
</html>
