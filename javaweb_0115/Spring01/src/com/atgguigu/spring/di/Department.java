package com.atgguigu.spring.di;

import java.util.List;
import java.util.Map;

public class Department {
	
	private Integer id ;
	private String  deptName;
	
	private List<Employee> emps ; 
	
	private Map<String, Employee> mapEmps ; 
	
	
	
	public Map<String, Employee> getMapEmps() {
		return mapEmps;
	}
	public void setMapEmps(Map<String, Employee> mapEmps) {
		this.mapEmps = mapEmps;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	} 
	
	
}
