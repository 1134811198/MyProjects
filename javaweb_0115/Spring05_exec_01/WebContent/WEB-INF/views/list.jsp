<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Emps EXCEL</h2>
<table align="center" border="1px" width="70%" cellspacing="0px">
  <tr>
     <th>ID</th>
     <th>LastName</th>
     <th>Email</th>
     <th>Gender</th>
     <th>DepartmentName</th>
     <th>Operation</th>
  </tr>

<c:forEach items="${emps }" var="emp">
  <tr align="center">
     <td>${emp.id }</td>
     <td>${emp.lastName }</td>
     <td>${emp.gender }</td>
     <td>${emp.email }</td>
     <td>${emp.department.departmentName }</td> 
     <td><a href="#">EDIT</a>&nbsp;&nbsp;<a href="#">DELETE</a></td> 
  </tr>

  </c:forEach>
</table>
<h2 align="center"><a href="#">ADD New Emp</a></h2>
</body>
</html>