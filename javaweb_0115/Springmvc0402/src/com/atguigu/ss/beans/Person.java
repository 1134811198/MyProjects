package com.atguigu.ss.beans;

public class Person {
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	} 
	
	public void sayHello() {
		System.out.println("My Name is " + name );
	}
	
	
}
