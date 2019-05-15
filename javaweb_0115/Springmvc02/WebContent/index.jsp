<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<a href="emp">List All Emps</a>
	<br/>
	<a href="testRedirect">Test Redirect</a>
	<br/>
	
	<a href="testMyView">Test MyView</a>
	<br/>
	
	<a href="testModelOrMap">Test  Model  Map</a>
	<br/>
	
	<a href="testModelAndView"> Test ModelAndView </a>
	<br/>
	
	<a href="testServletAPI">Test ServletAPI</a>
	<br/>
	<form action="testPOJO" method="post">
		username: <input type="text" name="username"/>
		<br/>
		password: <input type="password" name="password"/>
		<br/>
		email: <input type="text" name="email"/>
		<br/>
		age : <input type="text" name="age"/>
		<br/>
		province:<input type="text" name="address.province"/>
		<br/>
		city:<input type="text" name="address.city"/>
		<br/>
		<input type="submit" value="注册"/>
		
	</form>

	<br/>
	
	<a href="testCookieValue">Test CookieValue</a>
	<br/>
	
	<a href="testRequestHeader">Test RequestHeader</a>
	<br/>
	<a href="testRequestParam?username=tom&age=22">Test RequestParam</a>
</body>
</html>