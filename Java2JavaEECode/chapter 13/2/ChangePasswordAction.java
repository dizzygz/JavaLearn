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
            // �õ��û�������û���,����,�������������ȷ��
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            String newPassword = loginForm.getNewPassword();
            String confirmPassword = loginForm.getConfirmPassword();
            // �ж��������������ȷ���Ƿ�һ��
            if (newPassword != null && confirmPassword != null) {
                  //Not the same
                  if (!newPassword.equals(confirmPassword)) {
                         loginForm.setErrorMessage("Your password entris did 
                              not match!");
                         return mapping.findForward("change_failure");
                  }
            } else {
                  //����һ��,���ش�����Ϣ,��Ҫ���û���������
                  loginForm.setErrorMessage("Please enter the new password
                       twice!");
                  return mapping.findForward("change_failure");
            }
            //��������ͨ��,���ж��Ƿ��д��û�,�Լ��������Ƿ���ȷ
            if (username != null) {
                  // Whether it's a valid user
                  try {
                        SessionFactory sf = new Configuration().configure(). 
                             buildSessionFactory();
                        Session session = sf.openSession();
                        Transaction tx = session.beginTransaction();
                        // �����ݿ���Ѱ�Ҵ��û�
                        String sqlQuery = "select u from User u where u. 
                             username='"+ username + "'";
                        Query lQuery = session.createQuery(sqlQuery);
                        ArrayList userList = (ArrayList) lQuery.list();
                        User user = new User();
                        // ���ڴ��û�
                        if ((null != userList) && (userList.size() > 0)) {
                               user = (User) userList.get(0);
                               if (!user.getPassword().equals(password)) {
                                       loginForm.setErrorMessage("Invalid 
                                            user or incorrect password!");
                                        return mapping.findForward("change_
                                             failure");
                              } else {
                                    // ������ڴ��û�,����������ȷ,���޸�����Ϊ������
                                    if (newPassword != null) {
                                          user.setPassword(newPassword);
                                                //�������뱣�浽���ݿ���
                                           session.save(user);
                                    } else {
                                          loginForm.setErrorMessage("Please 
                                               enter the old password!");
                                          return mapping.findForward("change_
                                               failure");
                                    }
                              }
                        } else {
                              // �����ڴ��û�
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
            // �ɹ���������޸�
            return mapping.findForward("change_success");
      }
}
