<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<!-- 通过静态包含将base标签、link标签和script包含进来 -->
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		//给注册按钮绑定单击事件
		$("#sub_btn").click(function(){
			//获取用户输入的用户名
			var username = $("#username").val();
			//设置验证用户名是否符合要求的正则表达式
			var userReg = /^[a-zA-Z0-9_-]{3,16}$/;
			//验证用户名是否符合要求
			var flag = userReg.test(username);
			if(!flag){
				alert("请输入3-16为的字母、数字、下划线或者减号的用户名！");
				//取消默认行为
				return false;
			}
			//获取用户输入的密码
			var password = $("#password").val();
			//设置验证密码的正则表达式
			var pwdReg = /^[a-zA-Z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				alert("请输入6-18为的字母、数字、下划线或者减号的密码！");
				//取消默认行为
				return false;
			}
			//获取用户输入的确认密码
			var rePwd = $("#repwd").val();
			if(rePwd == ""){
				alert("确认密码也不能为空！");
				return false;
			}
			if(rePwd != password){
				//将确认密码置空，即将确认密码的input的value属性值设置为空串
				$("#repwd").val("");
				alert("两次输入的密码不一致！");
				return false;
			}
			//获取用户输入的邮箱
			var email = $("#email").val();
			//设置验证邮箱的正则表达式
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				alert("邮箱格式不正确！");
				return false;
			}
			//获取用户输入的验证码
			var code = $("#code").val();
			if(code == ""){
				alert("验证码不能为空！");
				return false;
			}

			
		});
	});
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
<%-- 								<span class="errorMsg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></span> --%>
								<span class="errorMsg">${requestScope.msg }</span>
							</div>
							<div class="form">
								<form action="UserServlet?methodName=regist" method="post">
									<label>用户名称：</label>
									<input value="${param.username }" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input value="${param.email }" class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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