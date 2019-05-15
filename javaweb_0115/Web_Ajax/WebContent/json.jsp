<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
var obj={"name":"张三","age":18};
alert(obj);
//alert(obj.name);
var array=["张三",false,18,obj];
//alert(array);
//alert(array[3].age);
var str='{"name":"lily","age":28}';
   alert(str);
var strToJsonObj=JSON.parse(str);
   alert(strToJsonObj);
   alert(strToJsonObj.name);
var JsonObjToStr=JSON.stringify(obj);
alert(JsonObjToStr);
</script>
</head>
<body>

</body>
</html>