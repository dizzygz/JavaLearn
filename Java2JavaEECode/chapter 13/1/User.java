//User类就是一个简单的JavaBean
public class User {
      //包含了三个成员,对应了数据库中的三个字段
      private String username;
      private String password;
      private int id;
      //这些成员的getter和setter方法
      public int getId() {
      		return id;
      }
      public void setId(int id) {
      		this.id = id;
      }
      public String getPassword() {
         return password;
      }
      public String getUsername() {
            return username;
      }
      public void setPassword(String password) {
            this.password = password;
      }
      public void setUsername(String username) {
            this.username = username;
      }
}
