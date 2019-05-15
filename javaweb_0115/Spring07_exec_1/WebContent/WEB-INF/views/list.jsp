<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script>
  $(function(){
	  
	  $("._del").click(function(){
		  var flag=window.confirm("确定要删除么?");
		  if(!flag){
			  return false;
		  }
		  var href=this.href;
		  $("form").attr("action",href).submit();
		  return false;
	  });
	  
  });

</script>
</head>
<body>
<form action="" method="post">
<input type="hidden" name="_method" value="delete">
</form>
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
     <td><a href="emp/${emp.id }">EDIT</a>&nbsp;&nbsp;<a class="_del" href="emp/${emp.id }">DELETE</a></td> 
  </tr>

  </c:forEach>
</table>


<h2 align="center"><a href="emp">ADD New Emp</a></h2>
</body>
</html>