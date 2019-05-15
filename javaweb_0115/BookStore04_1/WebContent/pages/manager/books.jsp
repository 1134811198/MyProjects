<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<!-- 通过静态包含将base标签、link标签和script包含进来 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//给添加购物车的超链接绑定单击事件
		$(".addBook").click(function(){
			//获取图书的id
			var bookId = $(this).attr("id");
			//发送请求
			location = "CartServlet?methodName=addBook2Cart&bookId="+bookId;
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	<div id="main">
			<c:if test="${empty requestScope.page.list }">
				<br><br><br><br><br><br><br><br>
				<h1 align="center">没有任何图书！</h1>
			</c:if>
			<c:if test="${!empty requestScope.page.list }">
			<div id="book">
				<div class="book_cond">
					<form action="BookClientServlet?methodName=getPageBooksByPrice" method="post">
					价格：<input type="text" name="min" value="${param.min }"> 元 - 
						<input type="text" name="max" value="${param.max }"> 元 
						<button>查询</button>
					</form>
				</div>
				<div style="text-align: center">
					<c:if test="${empty sessionScope.cart }">
						<span>您的购物车饥渴难耐，快去购物吧！！！</span>
					</c:if>
					<c:if test="${not empty sessionScope.cart }">
						<span>您的购物车中有${sessionScope.cart.totalCount }件商品</span>
					</c:if>
					<c:if test="${!empty sessionScope.bookTitle }">
						<div>
							您刚刚将<span style="color: red">${sessionScope.bookTitle }</span>加入到了购物车中
							<c:remove var="bookTitle"/>
						</div>
					</c:if>
				</div>
				
			<c:forEach items="${requestScope.page.list }" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button id="${book.id }" class="addBook">加入购物车</button>
						</div>
					</div>
				</div>
				</c:forEach>	
		</div>
		
		<div id="page_nav">
			<c:if test="${page.pageNo > 1 }">
				<a href="BookClientServlet?methodName=getPageBooks&min=${param.min }&max=${param.max }">首页</a>
				<a href="BookClientServlet?methodName=getPageBooks&pageNo=${page.pageNo - 1 }&min=${param.min }&max=${param.max }">上一页</a>
			</c:if>
			<!-- 
				1.当总页数小于5时
				2.当总页数大于等于5时
					1）当当前页小于等于3时
					2）当当前页大于3时	
			 -->
			 <c:choose>
			 	<c:when test="${page.totalPageNo < 5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${page.totalPageNo }"></c:set>
			 	</c:when>
			 	<c:when test="${page.pageNo <= 3 }">
			 		<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
			 	</c:when>
			 	<c:otherwise>
			 		<c:set var="begin" value="${page.pageNo - 2 }"></c:set>
					<c:set var="end" value="${page.pageNo + 2 }"></c:set>
					<c:if test="${page.pageNo + 2 > page.totalPageNo }">
						<c:set var="begin" value="${page.totalPageNo - 4 }"></c:set>
						<c:set var="end" value="${page.totalPageNo }"></c:set>
					</c:if>
			 	</c:otherwise>
			 </c:choose>
			<c:forEach begin="${begin }" end="${end }" var="index">
				<c:if test="${page.pageNo == index }">
					[<a href="BookClientServlet?methodName=getPageBooksByPrice&pageNo=${index }&min=${param.min }&max=${param.max }">${index }</a>]
				</c:if>
				<c:if test="${page.pageNo != index }">
					<a href="BookClientServlet?methodName=getPageBooksByPrice&pageNo=${index }&min=${param.min }&max=${param.max }">${index }</a>
				</c:if>
			</c:forEach>
			<c:if test="${page.pageNo < page.totalPageNo }">
				<a href="BookClientServlet?methodName=getPageBooksByPrice&pageNo=${page.pageNo + 1 }&min=${param.min }&max=${param.max }">下一页</a>
				<a href="BookClientServlet?methodName=getPageBooksByPrice&pageNo=${page.totalPageNo }&min=${param.min }&max=${param.max }">末页</a>
			</c:if>
			当前是第${page.pageNo }页，共${page.totalPageNo }页，共${page.totalRecord }条记录 到第<input value="${page.pageNo }" name="pn" id="pn_input"/>页
			<input type="button" value="确定" id="sub">
			<script type="text/javascript">
				//给确定按钮绑定单击事件
				$("#sub").click(function(){
					//获取输入的页码
					var pageNo = $("#pn_input").val();
					//发送请求
					location="BookClientServlet?methodName=getPageBooksByPrice&pageNo="+pageNo+"&min=${param.min }&max=${param.max }";
				});
			</script>
		</div>
		</c:if>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>