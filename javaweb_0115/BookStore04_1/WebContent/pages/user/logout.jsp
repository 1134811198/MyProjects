<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<!-- 通过静态包含将base标签、link标签和script包含进来 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
</head>
<body>
	
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word"></span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷</h1>
								
							</div>
							
							<div class="form">
								<form action="UserServlet?methodName=logout" method="post">
                          
									<input type="submit" value="注销" id="sub_btn" />
									
								</form>
								<form action="index.jsp" method="post">
                          
									<input type="submit" value="返回"  />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>