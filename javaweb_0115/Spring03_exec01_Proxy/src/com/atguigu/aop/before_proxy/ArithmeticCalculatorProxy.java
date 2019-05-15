package com.atguigu.aop.before_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class ArithmeticCalculatorProxy {
    //目标对象
	private ArithmeticCalculator target;
    //构造器
	public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
		
		this.target = target;
	}
	//获取代理对象
	public Object getProxy() {
		//代理对象
		Object proxy=null;
		//代理对象的获取
		
		//获取目标对象的类加载器
		ClassLoader loader=target.getClass().getClassLoader();
		//获取目标对象实现的所有接口
		Class [] interfaces=target.getClass().getInterfaces();
		
		//使用代理类的父类中的newProxyInsatance的方法来获取代理对象
	    proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//获取方法名
			    String methodName = method.getName();
				//日志功能:  
				System.out.println("Proxy===>The method  "+methodName+"  begin with " + Arrays.asList(args));
				
				Object result = method.invoke(target, args);
				
				System.out.println("Proxy===>The method "+methodName+" end  with : " +result );
				return result;
			}
			
		});
	    
		return proxy;
		
		
	}
	
	
	
}
