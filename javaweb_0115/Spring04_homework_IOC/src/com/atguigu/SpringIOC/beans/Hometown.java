package com.atguigu.SpringIOC.beans;

public class Hometown {

	private String province;
	private String city;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Hometown(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}
	public Hometown() {
		super();
	}
	@Override
	public String toString() {
		return "Hometown [province=" + province + ", city=" + city + "]";
	}
	
}
