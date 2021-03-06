package com.atguigu.mybatis.beans;

import java.io.Serializable;

public class Employee implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id ; 
	private String lastName; 
	private String email ;
	private Integer gender ;
	
	private Department dept ; 
	
	
	
	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(Integer id, String lastName, String email, Integer gender) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + "]";
	} 
	
	
}
