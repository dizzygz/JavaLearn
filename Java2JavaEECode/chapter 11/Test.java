import java.sql.*; 

public class Test {
public static void main(String[] srg) {
  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //����JDBC����
  String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=sample";  //���ӷ����������ݿ�sample
  String userName = "sa";  //Ĭ���û���
  String userPwd = "123456";  //����
  Connection dbConn;

  try {
   Class.forName(driverName);
   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
   System.out.println("Connection Successful!");  //������ӳɹ� ����̨���Connection Successful!
  } catch (Exception e) {
   e.printStackTrace();
  }
}
}
