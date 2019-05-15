package com.atguigu.spring.ioc.interfaces;

public class ReportService {   // 3 
	
	// 用到报表生成器对象
	
	private ReportGenerator rg ; 
	
	public void  generatorReport() {
		
		rg = new PdfReportGenerator();
		
		rg = new HTMLReportGenerator();
	}
	
}
