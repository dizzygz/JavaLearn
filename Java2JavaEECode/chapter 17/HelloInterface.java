//HelloInterface.java 
import java.rmi.Remote; 
//ʵ��Remote�ӿ�
public interface HelloInterface extends java.rmi.Remote { 
public void sayHello( String from ) throws java.rmi.RemoteException; 
} 
