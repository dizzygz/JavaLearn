package com.myjava.human.teacher;

import com.myjava.human.general.*;
import java.io.*;

public class Teacher extends Person{
	double salary;
	public Teacher(String name){
		super(name);
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	public double getSalary(){
		return this.salary;
	}
}
