package com.atguigu.SpringIOC.beans;

public class Employee {

	private String name;
	private String salary;
	private Department dept;
	private Hometown hometown;
	
	public Employee(String name, String salary, Department dept, Hometown hometown) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.hometown = hometown;
	}
	public Hometown getHometown() {
		return hometown;
	}
	public void setHometown(Hometown hometown) {
		this.hometown = hometown;
	}
	public Employee(String name, String salary, Department dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", dept=" + dept + ", hometown=" + hometown + "]";
	}
	public Employee(String name, String salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
}
