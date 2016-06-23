<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
   <head>
      <title>A Simple JavaServer Faces Application</title>
   </head>
   <body>
      <%@ taglib uri="http://java.sun.com/j2ee/html_basic/" prefix="faces" %>
      <font size="4">Please enter your name and password</font>
       <faces:usefaces>
         <faces:form id="simpleForm" formName="simpleForm">
            <table>
               <tr>
                  <td>Name:</td>
                  <td><faces:textentry_input id="name"/></td>
               </tr>
               <tr>
                  <td>Password:</td>
                  <td><faces:textentry_secret id="password"/></td>
              </tr>
            </table>
            <p><faces:command_button id="submit" commandName="Log In"/>
         </faces:form>
      </faces:usefaces>
   </body>
</html>
