<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.setAttribute("hello",null); %>
${hello==null }<br>
${empty hello }<br>
<hr>
<%pageContext.setAttribute("hello2",""); %>
${hello2==null }<br>
${empty hello2 }<br>
<hr>
<%List list=new ArrayList(); %>
<%pageContext.setAttribute("hello3",list); %>
${hello3==null }<br>
${empty hello3 }


<c:remove var="bye" scope="page"/>
${pageScope.hello }<br>
















</body>
</html>