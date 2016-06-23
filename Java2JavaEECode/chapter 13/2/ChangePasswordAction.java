import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * @author Chao Wu
 * 
 * Description: This class is a Struts Action class used to do the validation
 * work and change the password.
 * <p>
 * 
 * Copyright:
 * <p>
 */
public class ChangePasswordAction extends Action {

      /**
       * This method deals with the actions need to change the password
       * @param mapping
       * @param form
       * @param req
       * @param res
       * @return
       */
      public ActionForward execute(ActionMapping mapping, ActionForm form,
                  HttpServletRequest req, HttpServletResponse res)
                  throws IOException, ServletException {
            LoginForm loginForm = (LoginForm) form;
            // 得到用户输入的用户名,密码,新密码和新密码确认
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            String newPassword = loginForm.getNewPassword();
            String confirmPassword = loginForm.getConfirmPassword();
            // 判断新密码和新密码确认是否一致
            if (newPassword != null && confirmPassword != null) {
                  //Not the same
                  if (!newPassword.equals(confirmPassword)) {
                         loginForm.setErrorMessage("Your password entris did 
                              not match!");
                         return mapping.findForward("change_failure");
                  }
            } else {
                  //若不一致,返回错误信息,并要求用户重新输入
                  loginForm.setErrorMessage("Please enter the new password
                       twice!");
                  return mapping.findForward("change_failure");
            }
            //若新密码通过,则判断是否有此用户,以及其密码是否正确
            if (username != null) {
                  // Whether it's a valid user
                  try {
                        SessionFactory sf = new Configuration().configure(). 
                             buildSessionFactory();
                        Session session = sf.openSession();
                        Transaction tx = session.beginTransaction();
                        // 在数据库中寻找此用户
                        String sqlQuery = "select u from User u where u. 
                             username='"+ username + "'";
                        Query lQuery = session.createQuery(sqlQuery);
                        ArrayList userList = (ArrayList) lQuery.list();
                        User user = new User();
                        // 存在此用户
                        if ((null != userList) && (userList.size() > 0)) {
                               user = (User) userList.get(0);
                               if (!user.getPassword().equals(password)) {
                                       loginForm.setErrorMessage("Invalid 
                                            user or incorrect password!");
                                        return mapping.findForward("change_
                                             failure");
                              } else {
                                    // 如果存在此用户,并且密码正确,则修改密码为新密码
                                    if (newPassword != null) {
                                          user.setPassword(newPassword);
                                                //将新密码保存到数据库中
                                           session.save(user);
                                    } else {
                                          loginForm.setErrorMessage("Please 
                                               enter the old password!");
                                          return mapping.findForward("change_
                                               failure");
                                    }
                              }
                        } else {
                              // 不存在此用户
                              loginForm.setErrorMessage("Invalid user or 
                                   incorrect password!");
                              return mapping.findForward("change_failure");
                        }
                        tx.commit();
                        session.close();
                  } catch (HibernateException e) {
                        e.printStackTrace();
                        loginForm.setErrorMessage("Error!");
                        return mapping.findForward("change_failure");
                  }
            } else {
                  loginForm.setErrorMessage("Please enter the username!");
                  return mapping.findForward("change_failure");
            }
            // 成功完成密码修改
            return mapping.findForward("change_success");
      }
}
