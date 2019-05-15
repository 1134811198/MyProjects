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
		String username = "";
		String password = "";
		//获取Cookie对象
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				//获取Cookie对象的名字
				String name = cookie.getName();
				if("username".equals(name)){
					//这是保存用户名的Cookie对象
					username = cookie.getValue();
				}
				if("password".equals(name)){
					//这是保存密码的Cookie对象
					password = cookie.getValue();
				}
			}
		}
	%>
	<h1>免登录</h1>
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		用户名：<input type="text" name="username" value="<%=username%>"><br>
		密码：<input type="password" name="password" value="<%=password%>"><br>
		<input type="checkbox" name="confirm" value="beChecked">七天内免登录<br>
		<input type="submit">
	</form>
</body>
</html>