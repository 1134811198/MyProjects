package com.atguigu.spring.ioc.iocFactory;

public class ReportService {   // 2 
	
	// 用到报表生成器对象
	/**
	 * 当使用了IOC容器以后,  Pdf...  HTML... 以及  ReportService都在容器中, 
	 * 通过 private ReportGenerator rg  表达 ReportService想要使用ReportGenerator具体的
	 * 一个实现类对象.  IOC容器就能主动的将一个具体的实现类对象推送过来. 
	 */
	private ReportGenerator rg ;   //DI
	
	public void  generatorReport() {
		
		//rg = ReportFactory.getRg();
	}
	
}
