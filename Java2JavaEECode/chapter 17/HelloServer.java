//HelloServer.java 
import javax.naming.InitialContext; 
import javax.naming.Context; 

public class HelloServer { 
public static void main(String[] args) { 
try { 
// ����Զ�̶���
HelloImpl helloRef = new HelloImpl(); 
// ��JNDI���˶��󷢲� 
Context initialNamingContext = new InitialContext(); 
initialNamingContext.rebind("HelloService", helloRef ); 
System.out.println("Hello Server: Ready..."); 
} catch (Exception e) { 
System.out.println("Trouble: " + e); 
e.printStackTrace(); 
} 
} 
} 
