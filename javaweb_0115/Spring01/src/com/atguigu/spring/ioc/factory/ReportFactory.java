package com.atguigu.spring.ioc.factory;

public class ReportFactory {

	
	public static ReportGenerator getRg() {
		 
		return new PdfReportGenerator();  // new HTML...()
	}
}
