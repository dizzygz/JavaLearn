import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.cfg.*;
/**
 * @author Chao Wu
* Description: This class is a Struts Action class used to do the validation
 * work and login to the system.
 * <p>
 * 
 * Copyright:
 * <p>
 */
public class LoginAction extends Action {
      /**
       * This method deals with the actions need to login
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
            // ���û�����õ��û���������
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            try {
                  SessionFactory sf = new Configuration().configure().
                       buildSessionFactory();
                  Session session = sf.openSession();
                  Transaction tx = session.beginTransaction();
                  // �����ݿ���Ѱ�Ҵ��û�
                  String sqlQuery = "select u from User u where u.username='"+ 
                       username + "'";
                  Query lQuery = session.createQuery(sqlQuery);
                  ArrayList userList = (ArrayList) lQuery.list();
                  tx.commit();
                  session.close();
                  User user = new User();
                  //���ڴ��û�
                  if ((null != userList) && (userList.size() > 0)) {
                           user = (User) userList.get(0);
                           if (!user.getPassword().equals(password)) {
                                   return mapping.findForward("failure");
                           }
                  } else {
                           // �����ڴ��û�
                           return mapping.findForward("failure");
                  }
            } catch (HibernateException e) {
                   e.printStackTrace();
                   return mapping.findForward("failure");
                   }
                   // ��½�ɹ�
                   return mapping.findForward("success");
      }
}
