package com.atguigu.spring.spel;

public class Car {
	
	private String brand ; 
	
	private Double price ; 
	
	private Double tyreZC ;  //轮胎周长 .
 
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTyreZC() {
		return tyreZC;
	}

	public void setTyreZC(Double tyreZC) {
		this.tyreZC = tyreZC;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", tyreZC=" + tyreZC + "]";
	} 
	
	
}
