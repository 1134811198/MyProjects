<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//设置两个变量接收用户名和密码
		String username="";
	    String password="";
		//获取Cookie对象
	     Cookie [] cookies=request.getCookies();
		if(cookies !=null){
				//获取Cookie对象的名字
	     for(Cookie cookie:cookies){
	    	 String name=cookie.getName();
	    	 if("username".equals(name)){
	    		  username=cookie.getValue();
	    	 }if("password".equals(name)){
	    		 password=cookie.getValue();
	    	 }
	     }
		}
					//这是保存用户名的Cookie对象
			
				
				
					//这是保存密码的Cookie对象
				
				
			
		
	%>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
用户名<input type="text" value="" name="username"><br>
密码<input  type="password" value="" name="password"><br>
<input type="checkbox" name="confirm" value="bechecked">七天免登陆<br>
<input type="submit" value="提交">
</form>

</body>
</html>