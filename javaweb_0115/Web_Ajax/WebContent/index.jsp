<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.js">
</script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$.ajax({url:"${pageContext.request.contextPath}/AjaxServlet2",
			type:"get",
			data:"username=lucy&password=123456",
			success:function(res){
			//	alert(res);
			$("#msg").text(res);
			},
			error:function(){
				alert("出现异常了");
			}
		});
	});
});


</script>
</head>
<body>
<button id="btn">使用Ajax发送信息</button><span id="msg"></span>
<% application.getRealPath("/"); 
   out.println(application.getRealPath("/"));%>
</body>
</html>