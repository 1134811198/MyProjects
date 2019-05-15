<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>文件的上传</h1>
	<span style="color:red">${requestScope.msg }</span>
	<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
		姓名：<input type="text" name="username"><br>
		照片1：<input type="file" name="photo1"><br>
		照片2：<input type="file" name="photo2"><br>
		照片3：<input type="file" name="photo3"><br>
		<input type="submit">
	</form>
	<hr>
	<a href="${pageContext.request.contextPath }/DownloadServlet">点我有惊喜</a>
</body>
</html>