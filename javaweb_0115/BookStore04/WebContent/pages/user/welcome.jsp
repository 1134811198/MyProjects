<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${not empty sessionScope.user }">
                <div>
					<span>欢迎<span class="um_span">${sessionScope.user }</span>光临尚硅谷书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="UserServlet?methodName="logout">注销</a>&nbsp;&nbsp;
					<a href="index.jsp">返回</a>
				</div>

</c:if>
<c:if test="${empty sessionScope.user }">



</c:if>
