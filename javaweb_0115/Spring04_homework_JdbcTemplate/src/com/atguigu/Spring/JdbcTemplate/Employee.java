package com.atguigu.Spring.JdbcTemplate;
/*
 * 实验2：将employee_id=100的记录的salary更新为300000.00
 */
public class Employee {
	private String name;
	private String employee_id;
	private Double salary;
	private String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Employee(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public Employee(String name, String employee_id, Double salary) {
		super();
		this.name = name;
		this.employee_id = employee_id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + "]";
	} 
	
	

}
