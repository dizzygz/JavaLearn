<!--  ����ҳ���ϲ�������,���Բ���utf-8�ַ���  -->
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
    
<!--  �������õ���struts��ǩ��  -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>��½</title>
</head>
<body>
<!--  html:form���Եõ��û�����  -->
<html:form action="login.do" method="post">
  	   <!--  html:text�����ı������  -->
  	   �û���: <html:text size="15" property="username" />
  	   <br>
  	   ����: <html:text size="15" property="password" />
  	   <br>
  	   <!--  html:submit������ύ��ť  -->
  	   <html:submit property="login" value="ȷ��" />
</html:form>
</body>
</html>
