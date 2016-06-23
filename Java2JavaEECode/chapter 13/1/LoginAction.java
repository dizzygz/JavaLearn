//因为要使用hibernate,所以导入hibernate所需要的包
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
              //得到formbean的实例
              LoginForm loginForm = (LoginForm) form;
              //Get the username and password from user input
              //从formbean中得到用户名和密码
              String username = loginForm.getUsername();
              String password = loginForm.getPassword();
              try {
                     //根据hibernate.cfm.xml得到session factory的配置信息,
                     //根据这些配置信息,生成SessionFactory对象
                     SessionFactory sf = new Configuration().configure().
                          buildSessionFactory();
                     //用SessionFactory生成Session连接
                     Session session = sf.openSession();
                     //开始一个事务
                     Transaction tx = session.beginTransaction();
                     //Select the users from database with the username
                     //从数据库中寻找此用户
                     String sqlQuery = "select u from User u where u.username
                          ='"+ username + "'";
                     Query lQuery = session.createQuery(sqlQuery);
                     ArrayList userList = (ArrayList) lQuery.list();
                     tx.commit();
                     session.close();
                     User user = new User();
                     //是否存在此用户,不存在,或者密码错误,前进到错误页面
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
               //验证成功,前进到成功登陆页面
               return mapping.findForward("success");
      }
}
