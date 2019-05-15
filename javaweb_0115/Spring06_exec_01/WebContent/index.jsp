<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
     $(function(){
    	 $("#testJson").click(function(){
    		 $.ajax({url:"testJson",
    			 type:"post",
    			 dataType:"json",
    			 success:function(data){
    				 
   				 for(var i=0;i<data.length;i++){
    					 var emp=data[i];
    					
    					 // alert(emp.id+","+emp.lastName+","+emp.email+","+emp.gender+","+
    						// emp.department.id+","+emp.department.departmentName); 
    					  $("#msg").append(emp.id+","+emp.lastName+","+emp.email+","+emp.gender+","+
    	    						 emp.department.id+","+emp.department.departmentName +"<br>");
    						 
    					
    				 } 	 
    				 
    			 }
    		 });
    		 return false;
    	 });
     });

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="testFileUpload" method="post" enctype="multipart/form-data">
		File: <input type="file" name="uploadFile"/>
		<br/>
		Desc: <input type="text" name="desc"/>
		<br/>
		<input type="submit" value="上传"/>
	</form>
<a href="testResponseEntity">download beauty</a><br>
<a href="testHttpEntity">TestHttpEntity</a><br>
<form action="testRequestBody" method="post" enctype="multipart/form-data">
File:<input type="file" name="uploadfile"><br>
DESC:<input type="text" name="desc"><br>
<input type="submit" value="@RequestBody">

</form>
<a id="testJson" href="testJson">Test Json</a></br>
<a href="emps">TestREST CRUD Show All Emps</a></br>
<div id="msg"></div>


</body>
</html>