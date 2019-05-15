<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<!-- 通过静态包含将base标签、link标签和script包含进来 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//给删除图书的超链接绑定单击事件
		$(".deleteBook").click(function(){
			//获取书名
// 			var title = $(this).parent().parent().children(":first").text();
// 			var title = $(this).parents("tr").find("td:first").text();
			var title = $(this).attr("id");
			var flag = confirm("确定要删除【"+title+"】这本图书吗？");
			return flag;
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/WEB-INF/include/head.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			
		<c:forEach items="${requestScope.page.list }" var="book">		
			<tr>
				<td>${book.title }</td>
				<td>${book.price }</td>
				<td>${book.author }</td>
				<td>${book.sales }</td>
				<td>${book.stock }</td>
				<td><a href="BookManagerServlet?methodName=getBook&bookId=${book.id }">修改</a></td>
				<td><a id="${book.title }" class="deleteBook" href="BookManagerServlet?methodName=deleteBook&bookId=${book.id }">删除</a></td>
			</tr>	
		</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
		
		<div id="page_nav">
			<c:if test="${page.pageNo > 1 }">
				<a href="BookManagerServlet?methodName=getPageBooks">首页</a>
				<a href="BookManagerServlet?methodName=getPageBooks&pageNo=${page.pageNo - 1 }">上一页</a>
			</c:if>
			当前是第${page.pageNo }页，共${page.totalPageNo }页，共${page.totalRecord }条记录
			<c:if test="${page.pageNo < page.totalPageNo }">
				<a href="BookManagerServlet?methodName=getPageBooks&pageNo=${page.pageNo + 1 }">下一页</a>
				<a href="BookManagerServlet?methodName=getPageBooks&pageNo=${page.totalPageNo }">末页</a>
			</c:if>
			 到第<input value="${page.pageNo }" name="pn" id="pn_input"/>页
			<input type="button" value="确定" id="sub">
			<script type="text/javascript">
				//给确定按钮绑定单击事件
				$("#sub").click(function(){
					//获取输入的页码
					var pageNo = $("#pn_input").val();
					//发送请求
// 					window.location.href="BookManagerServlet?methodName=getPageBooks&pageNo="+pageNo;
// 					location.href="BookManagerServlet?methodName=getPageBooks&pageNo="+pageNo;
					location="BookManagerServlet?methodName=getPageBooks&pageNo="+pageNo;
				});
			</script>
		</div>
		
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>