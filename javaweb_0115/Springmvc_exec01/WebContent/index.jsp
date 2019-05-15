<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 测试GET请求 -->
<a href="hello">Hello Springmvc</a>
<!-- 测试POST -->
<form action="TestRequestMappingPostMethod" method="Post">
<input type="submit" value="TestRequestMapping PostMethod">
</form>
<!-- 测试 映射请求参数 --><br>
<a href="TestRequestMappingParams?username=Lucy&age=10">TestRequestMapping Params</a>
<!-- 测试 映射请求头 -->
<a href="TestRequestMappingHeaders">TestRequestMappingHeaders</a>
<!-- 测试映射Ant -->
<a href="TestRequestMappingAnt/a/test.aaa">TestRequestMappingAnt</a><br>
<!-- 测试pathVariable -->
<a href="TestRequestMappingPathVariable/tom/1001/boy">TestRequestMappingPathVariable</a><br>
<!-- 测试REST风格的GET 获取资源方法 -->
<a href="order/1001">TestRequestMappingREST GET Method</a><br>
<!-- 测试REST风格的POST 新建资源 方法 -->
<form action="order" method="POST">
<input type="submit" value="REST POST">
</form><br>
<!-- 测试REST风格的DELETE 删除资源的方法 -->
<form action="order/1003" method="post">
<input type="hidden" name="_method" value="DELETE">
<input type="submit" value="REST DELETE">
</form>
<!-- 测试REST风格的PUT 更改资源的方法 -->
<form action="order/1111" method="post">
<input type="hidden" name="_method" value="PUT">
<input type="submit" value="REST PUT">
</form>
</body>
</html>