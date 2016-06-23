import java.io.*;
import java.util.*;

public class Test2{
	public static void main (String[] args){
		short s1=1; 
		s1= (short)(s1+1);
		s1=(short)(3/0);
		System.out.println("s1: "+s1);
	}
}