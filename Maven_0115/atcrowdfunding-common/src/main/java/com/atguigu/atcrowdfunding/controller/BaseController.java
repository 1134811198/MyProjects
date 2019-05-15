package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
  
	private ThreadLocal<Map<String,Object>> threadLocal=new ThreadLocal();
	
	public void start() {
		Map<String,Object> result=new HashMap();
		threadLocal.set(result);
	}
	public void success(boolean success) {
		Map<String, Object> result = threadLocal.get();
		result.put("success", success);
	}
	public void message(String message ) {
		Map<String, Object> result = threadLocal.get();
		result.put("message", message);
	}
	public void data(Object data) {
		Map<String, Object> result = threadLocal.get();
		result.put("data", data);
	}
	public Map<String,Object> end(){
		Map<String, Object> result = threadLocal.get();
		return result;
	}
}
