<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入Springmvc 标签库 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 添加   修改页面 -->
	
	<!-- 
		Springmvc的表单标签:
			1. 快速的开发页面
			2. 更加方便的回显数据
		Springmvc标签标签回显数据的问题:
			Springmvc表单标签默认情况下必须要进行数据的回显. 
			默认情况下使用"command"这个key到request中去找回显的数据. 
			如果找不到则报错: 
			Neither BindingResult nor plain target object for bean name 'command' available as request attribute
			
			我们可以使用modelAttribute来指定一个key替换掉默认的"command",建议都手动指定一个key.
	
	 -->
	 <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
	 
	 	<!-- 判断是修改还是添加 -->
	 	<c:if test="${!empty employee.id }" var="flag">
	 		<!-- 修改 -->
	 		<input type="hidden" name="_method" value="PUT"/>
	 		<form:hidden path="id"/>
	 	</c:if>
	 	<!-- path就相当于HTML中input标签的name属性. -->
	 	LastName: <form:input path="lastName" />
	 	<br/>
	 	Email: <form:input path="email"/>
	 	<br/>
	 	Gender: <form:radiobuttons path="gender" items="${genders }"/>
	 	<br/>
	 	DeptName:<form:select path="department.id" items="${depts }" itemLabel="departmentName" itemValue="id"></form:select>
	 	<br/>
	 	<c:if test="${!flag }">
	 		<input type="submit" value="ADD"/> 
	 	</c:if>
	 	<c:if test="${flag }">
	 		<input type="submit" value="Edit"/> 
	 	</c:if>
	 	
	 </form:form>
</body>
</html>