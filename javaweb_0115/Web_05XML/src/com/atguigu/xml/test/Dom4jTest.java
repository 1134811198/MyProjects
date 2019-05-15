package com.atguigu.xml.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.atguigu.xml.bean.Student;

public class Dom4jTest {
      public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("Students.xml");
		Element rootElement = document.getRootElement();
		List<Element> stus = rootElement.elements();
		for (Element stu : stus) {
			String id = stu.attributeValue("id");
			//Element nameEle = stu.element("name");
			//String name = nameEle.getText();
			String name = stu.elementText("name");
			String age = stu.elementText("age");
			String gender = stu.elementText("gender");
			String address = stu.elementText("address");
			Student student=new Student(id,name,age,gender,address);
			System.out.println(student);
			
		}
		
	}
}
