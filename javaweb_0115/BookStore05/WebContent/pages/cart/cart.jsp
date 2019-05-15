<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<!-- 通过静态包含将base标签、link标签和script包含进来 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//给清空购物车的超链接绑定单击事件
		$("#emptyCart").click(function(){
			return confirm("亲！您确定要清空购物车吗？三思啊！┭┮﹏┭┮");
		});
		//给删除购物项的超链接绑定单击事件
		$(".deleteCartItem").click(function(){
			//获取书名
// 			var title = $(this).parents("tr").find("td:first").text();
			var title = $(this).attr("id");
			return confirm("确定要删除【"+title+"】这本图书吗？");
		});
		//给输入图书数量的文本框绑定change事件
		$(".countInput").change(function(){
			//获取显示图书数量的input标签中的默认值
			var defaultV = this.defaultValue;
			//获取图书的id
			var bookId = $(this).attr("id");
			//获取用户输入的图书的数量
			var inputCount = $(this).val();
			//获取图书的库存
			var stock = $(this).attr("name");
// 			stock = parseInt(stock);
			stock = new Number(stock);
			if(inputCount > stock){
				//恢复默认值
				this.value = defaultV;
				alert("图书的库存只有"+stock+"本！");
				return false;
			}
			//发送请求
			location = "CartServlet?methodName=updateCartItem&bookId="+bookId+"&bookCount="+inputCount;
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	
	<div id="main">
		<c:if test="${empty sessionScope.cart.cartItems }">
			<br><br><br><br><br><br><br><br><br>
			<h1 align="center">购物车空空如也，快去<a href="index.jsp" style="color: red">购物</a>吧！！！</h1>
		</c:if>
		<c:if test="${not empty sessionScope.cart.cartItems }">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
		<c:forEach items="${sessionScope.cart.cartItems }" var="cartItem">	
			<tr>
				<td>${cartItem.book.title }</td>
				<td>
					<input name="${cartItem.book.stock }" id="${cartItem.book.id }" class="countInput" type="text" value="${cartItem.count }" style="width: 30px;text-align: center;">
				</td>
				<td>${cartItem.book.price }</td>
				<td>${cartItem.amount }</td>
				<td><a id="${cartItem.book.title }" class="deleteCartItem" href="CartServlet?methodName=deleteCartItem&bookId=${cartItem.book.id }">删除</a></td>
			</tr>		
		</c:forEach>	
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount }</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalAmount }</span>元</span>
			<span class="cart_span"><a href="index.jsp">继续购物</a></span>
			<span class="cart_span"><a id="emptyCart" href="CartServlet?methodName=emptyCart">清空购物车</a></span>
			<span class="cart_span"><a href="OrderServlet?methodName=checkOut">去结账</a></span>
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