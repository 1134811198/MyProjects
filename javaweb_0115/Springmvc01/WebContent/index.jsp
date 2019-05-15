<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 修改一个order  PUT -->
	<form action="order" method="POST">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="REST PUT"/>
		
	</form>
	<br/>
	
	<!-- 添加一个order  POST -->
	<form action="order" method="POST">
		<input type="submit" value="REST POST"/>
		
	</form>
	<br/>
	
	<!-- 删除id为1001的order   DELETE-->
	<form action="order/1001" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="REST DELETE"/>		
	</form>
	<br/>
	
	<!-- 查询id为1001 的order  GET -->
	<a href="order/1001">REST GET</a>
	

	<br/>
	

	<a href="testPathVariable/tom/1001">Test PathVariable</a>
	<br/>
	<a href="testRequestMappingAnt/abc/test">Test RequestMapping Ant </a>
	<br/>
	<a href="testRequestMappingHeaders"> Test RequestMappingHeaders </a>
	<br/>
	<a href="testRequestMappingParams?username=tom&age=10"> Test RequestMapping  Params</a>
	<br/>
	
	<form action="testRequestMappingMethod" method="post">
		<input type="submit" value="Test RequestMapping method"/>
	</form>
	<br/>
	<a href="testRequestMappingMethod">Test RequestMapping method </a>
	<br/>
	<a href="hello">Hello Springmvc </a>
</body>
</html>