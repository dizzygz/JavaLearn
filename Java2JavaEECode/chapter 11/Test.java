import java.sql.*; 

public class Test {
public static void main(String[] srg) {
  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //加载JDBC驱动
  String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=sample";  //连接服务器和数据库sample
  String userName = "sa";  //默认用户名
  String userPwd = "123456";  //密码
  Connection dbConn;

  try {
   Class.forName(driverName);
   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
   System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
  } catch (Exception e) {
   e.printStackTrace();
  }
}
}
