<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
<c:if test="${!empty employee.id }" var = "flag">
     <input type="hidden" name="_method" value="PUT">
     <form:hidden path="id"/>
</c:if>

LastName:<form:input path="lastName"/><br>
Email:<form:input path="email"/><br>
Gender:<form:radiobuttons path="gender" items="${genders }"/><br>
DeptName:<form:select path="department.id" items="${depts }" itemLabel="departmentName" itemValue="id"></form:select><br>
<c:if test="${!flag}">
<input type="submit" value="ADD">
</c:if>
<c:if test="${flag }">
<input type="submit" value="EDIT">

</c:if>
</form:form>
</body>
</html>