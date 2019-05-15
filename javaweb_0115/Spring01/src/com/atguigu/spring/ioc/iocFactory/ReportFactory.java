package com.atguigu.spring.ioc.iocFactory;

/**
 * IOC
 *
 */
public class ReportFactory {

	
	public static ReportGenerator getRg() {
		 
		return new PdfReportGenerator();  // new HTML...()
	}
}
