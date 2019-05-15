package com.atguigu.spring.spel;

public class Person {
	
	private Integer id ; 
	
	private String name ; 
	
	private String street ;   //引用Address的street属性 
	
	private Car car ;  // 使用SPEL进行对象的引用. 
	
	private String info ;   // 根据车的价格判断得出一个结果.

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", street=" + street + ", car=" + car + ", info=" + info + "]";
	}
	
	
	
	
}
