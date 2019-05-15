package com.atguigu.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {

	public static void main(String[] args) throws DocumentException {
		//1.创建解析器对象
		SAXReader reader = new SAXReader();
		//2.解析xml文件得到Document对象
		Document document = reader.read("students.xml");
		//3.获取id属性值为5的student元素
//		Element stuEle = (Element) document.selectSingleNode("/students/student[@id='5']");
		Element stuEle = (Element) document.selectSingleNode("//student[@id='5']");
		//获取该元素的id属性值
		String id = stuEle.attributeValue("id");
		System.out.println(id);
	}
}
