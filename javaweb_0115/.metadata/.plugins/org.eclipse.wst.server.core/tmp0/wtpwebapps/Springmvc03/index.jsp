<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#testJson").click(function(){
				$.ajax({
					url:"testJson",
					type:"POST",
					dataType:"json",
					success:function(data){
						for(var i =0 ;i<data.length;i++){
							var emp = data[i];
							alert(emp.id + " , " + emp.lastName + " , " +emp.email  );
							//作业:  异步请求json数据，显示员工信息列表. 
						}
					}
					
				});
				
				return false ;
			});
			
		});
	
	</script>
</head>
<body>	
	<form action="testFileUpload" method="post" enctype="multipart/form-data">
		File: <input type="file" name="uploadFile"/>
		<br/>
		Desc: <input type="text" name="desc"/>
		<br/>
		<input type="submit" value="上传"/>
	</form>
	<br/>
	
	<a href="testResponseEntity">下载美女图片</a>
	<br/>
	<a href="testHttpEntity"> Test HttpEntity</a>
	<br/>
	<form action="testRequestBody" method="post" enctype="multipart/form-data">
		File: <input type="file" name="uploadFile"/>
		<br/>
		Desc: <input type="text" name="desc"/>
		<br/>
		<input type="submit" value="@RequestBody"/>
		
	</form>
	<br/>
	<a id="testJson" href="testJson">Test Json</a>
	<br/>
	<a href="emps">List All Emps</a>
	<br/>
	<a href="testRedirect">Test Redirect</a>
	<br/>
	
	<a href="testMyView">Test MyView</a>
	<br/>
	
	<a href="testModelOrMap">Test  Model  Map</a>
	<br/>
	
	<a href="testModelAndView"> Test ModelAndView </a>
	<br/>
	
	<a href="testServletAPI">Test ServletAPI</a>
	<br/>
	<form action="testPOJO" method="post">
		username: <input type="text" name="username"/>
		<br/>
		password: <input type="password" name="password"/>
		<br/>
		email: <input type="text" name="email"/>
		<br/>
		age : <input type="text" name="age"/>
		<br/>
		province:<input type="text" name="address.province"/>
		<br/>
		city:<input type="text" name="address.city"/>
		<br/>
		<input type="submit" value="注册"/>
		
	</form>

	<br/>
	
	<a href="testCookieValue">Test CookieValue</a>
	<br/>
	
	<a href="testRequestHeader">Test RequestHeader</a>
	<br/>
	<a href="testRequestParam?username=tom&age=22">Test RequestParam</a>
</body>
</html>