<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
用户名：<input type="text" name="username">
<input type="file" name="photo1">
<input type="file" name="photo2">
<input type="file" name="photo3">
<input type="submit" value="提交">
</form><span style="color:red">${requestScope.msg }</span>
<a href="${pageContext.request.contextPath }/DownloadServlet">点我有惊喜</a>
</body>
</html>