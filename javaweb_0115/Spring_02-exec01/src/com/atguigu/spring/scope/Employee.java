package com.atguigu.spring.scope;

public class Employee {
	private Integer id ; 
	private String lastName;
	


	public Employee() {
		System.out.println("Employee Constructor......");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + "]";
	}
	
	
}
