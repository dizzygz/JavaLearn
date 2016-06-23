package com.myjava.human.general;

import java.io.*;

public class Person{
	String name;
	int age;
	String gender;
	
	public Person(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public static void main(String[] args){
		System.out.println("test");
	}
	
}