//HelloServer.java 
import javax.naming.InitialContext; 
import javax.naming.Context; 

public class HelloServer { 
public static void main(String[] args) { 
try { 
// 创建远程对象
HelloImpl helloRef = new HelloImpl(); 
// 用JNDI将此对象发布 
Context initialNamingContext = new InitialContext(); 
initialNamingContext.rebind("HelloService", helloRef ); 
System.out.println("Hello Server: Ready..."); 
} catch (Exception e) { 
System.out.println("Trouble: " + e); 
e.printStackTrace(); 
} 
} 
} 
