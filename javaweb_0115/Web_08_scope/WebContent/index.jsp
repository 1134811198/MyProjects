<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.atguigu.beans.Department"%>
<%@page import="com.atguigu.beans.Employee"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% Date date=new Date(); 
   pageContext.setAttribute("date",date+"1");
   request.setAttribute("date",date+"2");
   session.setAttribute("date",date+"3");
   application.setAttribute("date",date+"4");

   %>

<%=date %>
${pageScope.date }<br>
${requestScope.date }<br>
${sessionScope.date }<br>
${applicationScope.date }<br>

<% Employee emp=new Employee("1","lily",new Department("001","Deplomat")); 
   pageContext.setAttribute("emp", emp);
%>

${emp.name }<br>
${emp.dept.name }<br>

</body>
</html>