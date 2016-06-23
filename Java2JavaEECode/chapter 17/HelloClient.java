//HelloClient.java 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
import javax.rmi.*; 
import java.util.Vector; 
import javax.naming.NamingException; 
import javax.naming.InitialContext; 
import javax.naming.Context; 

public class HelloClient { 
public static void main( String args[] ) { 
Context ic; 
Object objref; 
HelloInterface hi; 
try { 
ic = new InitialContext(); 
// 利用JNDI获得对象引用 
objref = ic.lookup("HelloService"); 
System.out.println("Client: Obtained a ref. to Hello server."); 
// 将对象映射为具体类型，并调用其方法 
hi = (HelloInterface) PortableRemoteObject.narrow( 
objref, HelloInterface.class); 
hi.sayHello( " MARS " ); 
} catch( Exception e ) { 
System.err.println( "Exception " + e + "Caught" ); 
e.printStackTrace( ); 
return; 
} 
} 
}
