package com.atguigu.SpringIOC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.SpringIOC.Service.StudentService;

@Controller
public class Student {
    @Autowired
	StudentService studentService;
	public void goToSchool() {
		System.out.println("go to school");
		studentService.putOnClothes();
	}
}
