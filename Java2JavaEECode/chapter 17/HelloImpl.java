//HelloImpl.java 
import javax.rmi.PortableRemoteObject; 

public class HelloImpl extends PortableRemoteObject implements HelloInterface { 
//构造函数
public HelloImpl() throws java.rmi.RemoteException { 
super(); // invoke rmi linking and remote object initialization 
} 
	//远程方法，范围字符串
public void sayHello( String from ) throws java.rmi.RemoteException { 
System.out.println( "Hello from " + from + "!!" ); 
System.out.flush(); 
} 
} 
