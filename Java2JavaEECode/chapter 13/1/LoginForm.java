//导入所需要的包,ActionForm基类包含在org.apache.struts.action包中
import org.apache.struts.action.*;
//自己写的actionform必须继承ActionForm基类
public class LoginForm extends ActionForm {
  	   //actionform的成员:username和password
  	   private String username;
  	   private String password;
  	   //成员的getter和setter方法
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
