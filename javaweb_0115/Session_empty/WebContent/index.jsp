<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">欢迎光临武林秘籍管理系统</h1>
<c:if test="${empty sessionScope.user }">
<h2 align="center">游客您好，如果想查看武林秘籍请登录</h2>

<form action="${pageContext.request.contextPath }/LoginServlet" method="post">      
用户名：<input type="text" name="username" />
密码：<input type="password" name="password">
<input type="submit" name="submit" value="提交">
</form>
	<h3>普通武功秘籍</h3>
	<ul>
		<li><a href="level1/1.jsp">罗汉拳</a></li>
		<li><a href="level1/2.jsp">武当长拳</a></li>
		<li><a href="level1/3.jsp">全真剑法</a></li>
	</ul>

</c:if>

<c:if test="${!empty sessionScope.user }">
<h2 align="center"> 欢迎您，${sessionScope.user} 请看武林秘籍</h2>
<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
<hr>
	<h3>普通武功秘籍</h3>
	<ul>
		<li><a href="level1/1.jsp">罗汉拳</a></li>
		<li><a href="level1/2.jsp">武当长拳</a></li>
		<li><a href="level1/3.jsp">全真剑法</a></li>
	</ul>



	<h3>高级武功秘籍</h3>
	<ul>
		<li><a href="level2/1.jsp">太极拳</a></li>
		<li><a href="level2/2.jsp">七伤拳</a></li>
		<li><a href="level2/3.jsp">梯云纵</a></li>
	</ul>

	<h3>绝世武功秘籍</h3>
	<ul>
		<li><a href="level3/1.jsp">葵花宝典</a></li>
		<li><a href="level3/2.jsp">龟派气功</a></li>
		<li><a href="level3/3.jsp">独孤九剑</a></li>
	</ul>
</c:if>
</body>
</html>