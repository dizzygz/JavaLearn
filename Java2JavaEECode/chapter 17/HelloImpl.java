//HelloImpl.java 
import javax.rmi.PortableRemoteObject; 

public class HelloImpl extends PortableRemoteObject implements HelloInterface { 
//���캯��
public HelloImpl() throws java.rmi.RemoteException { 
super(); // invoke rmi linking and remote object initialization 
} 
	//Զ�̷�������Χ�ַ���
public void sayHello( String from ) throws java.rmi.RemoteException { 
System.out.println( "Hello from " + from + "!!" ); 
System.out.flush(); 
} 
} 
