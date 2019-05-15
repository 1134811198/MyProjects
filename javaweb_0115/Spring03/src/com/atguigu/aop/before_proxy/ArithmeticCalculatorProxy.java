package com.atguigu.aop.before_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 生成动态代理对象:
 * 	动态代理需要关心的重要对象:
 * 	1. 原始对象、目标对象. 
 *  2. 代理对象
 *  3. Proxy
 *  4. InvocationHandler
 */
public class ArithmeticCalculatorProxy {
	
	private ArithmeticCalculator target ; // 目标对象  原始对象
	
	//通过构造器将原始对象传入
	public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
		this.target = target ; 
	}
	
	/**
	 * 获取代理对象
	 */
	public  Object  getProxy() {
		//代理对象
		Object proxy =null ; 
		
		//生成动态代理对象. 
		/*
		 * loader: ClassLoader 类加载器对象.  加载动态代理类
		 * 
		 * interfaces: 接口们.  目标类实现的所有接口.   保证代理类中的方法 与 目标类中的方法是一致的（目标类中自定义的方法除外.）
		 *  
		 * h: InvocationHandler
		 */
		ClassLoader loader = target.getClass().getClassLoader();
		
		Class [] interfaces = target.getClass().getInterfaces();
		
		proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			
			/**
			 * invoke方法就是动态代理的整个过程. 
			 * 
			 * Object proxy : 代理对象
			 * Method method : 正在被调用的方法
			 * Object [] args: 方法的参数.
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//方法名
				String methodName = method.getName();
				//日志功能:  
				System.out.println("Proxy===>The method  "+methodName+"  begin with " + Arrays.asList(args));
				
				//代理对象将对方法的调用转回到目标对象上。 
				Object result = method.invoke(target, args);
				
				System.out.println("Proxy===>The method "+methodName+" end  with : " +result );
			
				return result;
			}
		});
		
		return proxy; 
	}
	
}

/**
 * 简单模拟代理类
 */

class $Proxy0 extends Proxy  implements  ArithmeticCalculator{

	
	protected $Proxy0(InvocationHandler h) {
		super(h);
	}

	@Override
	public int add(int i, int j) {
		
		return 0 ; 
		//return super.h.invoke(this, nul, args);
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}






