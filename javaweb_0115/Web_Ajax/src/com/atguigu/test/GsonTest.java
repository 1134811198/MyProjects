package com.atguigu.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.atguigu.bean.Student;
import com.google.gson.Gson;

public class GsonTest {
	
	@Test
	public void test() {
		
		Student stu01=new Student("1", "lily", 18);
		Gson gson=new Gson();    
		String json = gson.toJson(stu01);
		System.out.println(json);
		//将JSON转换为Student对象
		Student fromJson = gson.fromJson(json, Student.class);
		System.out.println(fromJson);
	}
	@Test
	public void test02() {
		//创建一个List<Student>
				List<Student> stus = new ArrayList();
				stus.add(new Student("1", "刘备", 35));
				stus.add(new Student("2", "关羽", 30));
				stus.add(new Student("3", "张飞", 25));
				stus.add(new Student("4", "赵云", 20));
				
				//创建Gson对象
				Gson gson=new Gson();
				//将List转换为JSON字符串
				String json = gson.toJson(stus);
				System.out.println(json);
				
	}
	@Test
	public void testMap() {
		//创建一个Map<String , Student>
		Map<String , Student> map = new HashMap<String,Student>();
		map.put("stu01", new Student("1", "扫雷", 30));
		map.put("stu02", new Student("2", "传奇", 60));
		map.put("stu03", new Student("3", "红警", 30));
		
		
		//创建Gson对象
		Gson gson = new Gson();
		//将Map转换为JSON字符串
		String json = gson.toJson(map);
		System.out.println(json);
	}
}
    
