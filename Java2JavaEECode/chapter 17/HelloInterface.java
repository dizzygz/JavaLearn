//HelloInterface.java 
import java.rmi.Remote; 
//实现Remote接口
public interface HelloInterface extends java.rmi.Remote { 
public void sayHello( String from ) throws java.rmi.RemoteException; 
} 
