package com.atguigu.spring.ioc.factory;

public class ReportService {   // 2 
	
	// 用到报表生成器对象
	
	private ReportGenerator rg ; 
	
	public void  generatorReport() {
		
		rg = ReportFactory.getRg();
	}
	
}
