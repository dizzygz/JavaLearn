//��������Ҫ�İ�,ActionForm���������org.apache.struts.action����
import org.apache.struts.action.*;
//�Լ�д��actionform����̳�ActionForm����
public class LoginForm extends ActionForm {
  	   //actionform�ĳ�Ա:username��password
  	   private String username;
  	   private String password;
  	   //��Ա��getter��setter����
  	   public String getPassword() {
  			return password;
  	   }
  	   public void setPassword(String password) {
  			this.password = password;
  	   }
  	   public String getUsername() {
  			return username;
  	   }
  	   public void setUsername(String username) {
  			this.username = username;
  	   }
}
