//��ΪҪʹ��hibernate,���Ե���hibernate����Ҫ�İ�
import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class LoginAction extends Action {
      public ActionForward execute(ActionMapping mapping, ActionForm form,
                  HttpServletRequest req, HttpServletResponse res)
                  throws IOException, ServletException {
              //�õ�formbean��ʵ��
              LoginForm loginForm = (LoginForm) form;
              //Get the username and password from user input
              //��formbean�еõ��û���������
              String username = loginForm.getUsername();
              String password = loginForm.getPassword();
              try {
                     //����hibernate.cfm.xml�õ�session factory��������Ϣ,
                     //������Щ������Ϣ,����SessionFactory����
                     SessionFactory sf = new Configuration().configure().
                          buildSessionFactory();
                     //��SessionFactory����Session����
                     Session session = sf.openSession();
                     //��ʼһ������
                     Transaction tx = session.beginTransaction();
                     //Select the users from database with the username
                     //�����ݿ���Ѱ�Ҵ��û�
                     String sqlQuery = "select u from User u where u.username
                          ='"+ username + "'";
                     Query lQuery = session.createQuery(sqlQuery);
                     ArrayList userList = (ArrayList) lQuery.list();
                     tx.commit();
                     session.close();
                     User user = new User();
                     //�Ƿ���ڴ��û�,������,�����������,ǰ��������ҳ��
                     if ((null != userList) && (userList.size() > 0)) {
                              user = (User) userList.get(0);
                              if (!user.getPassword().equals(password)) {
                                      return mapping.findForward("failure");
                              }
                      } else {
                              return mapping.findForward("failure");
                      }
               } catch (HibernateException e) {
                      e.printStackTrace();
                      return mapping.findForward("failure");
               }
               //��֤�ɹ�,ǰ�����ɹ���½ҳ��
               return mapping.findForward("success");
      }
}
