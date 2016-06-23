import com.myjava.human.general.*;
import com.myjava.human.teacher.*;

import java.io.*;

public class TestPerson{
	public static void main(String[] args){
		Person p1= new Person("Mike");
		Teacher t1 = new Teacher("Susie");
		t1.setSalary(8000.5);
		
		String s= "Teacher's name:"+t1.getName();
		System.out.println(s);
	}

}