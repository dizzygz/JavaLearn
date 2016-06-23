<!--  ÓÉÓÚÒ³ÃæÉÏ²ÉÓÃÖÐÎÄ,ËùÒÔ²ÉÓÃutf-8×Ö·û¼¯  -->
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
    
<!--  ¶¨ÒåËùÓÃµ½µÄstruts±êÇ©¿â  -->
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>µÇÂ½</title>
</head>
<body>
<!--  html:formÓÃÒÔµÃµ½ÓÃ»§ÊäÈë  -->
<html:form action="login.do" method="post">
  	   <!--  html:text¶¨ÒåÎÄ±¾ÊäÈë¿ò  -->
  	   ÓÃ»§Ãû: <html:text size="15" property="username" />
  	   <br>
  	   ÃÜÂë: <html:text size="15" property="password" />
  	   <br>
  	   <!--  html:submit¶¨Òå±íµ¥Ìá½»°´Å¥  -->
  	   <html:submit property="login" value="È·¶¨" />
</html:form>
</body>
</html>
