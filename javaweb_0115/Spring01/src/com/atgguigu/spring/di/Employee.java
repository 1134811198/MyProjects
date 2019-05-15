package com.atgguigu.spring.di;

public class Employee {
	private Integer id ; 
	private String  lastName ;
	private String  email ;
	private Integer age;
	
	private Double salary ; 
	
	private Department dept ; 
	
	
	public Employee() {
	}
	
	
	public Employee(Integer id, String lastName, String email, Integer age) {
		super();
		System.out.println("invoke Employee(id,lastName,email,age) ......");
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}


	public Employee(Integer id, String lastName, String email, Double salary) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	
	

	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("setId:" + id );
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + ", salary="
				+ salary + "]";
	}
	 
	
	
}
