<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
<link href="<%=basePath %>common/fit/v4/static/lightblue/css/login/login.css" rel="stylesheet">
<!DOCTYPE html> 
<html lang="en"> 
<body class="default">
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
			<span class="sys-name">就业服务局智慧就业云平台</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<form id="login_form" action="<%=basePath %>system/login" method="post">
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input type="text" name="logName" value="admin" placeholder="账号">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input type="password" name="logPwd" value="123456" placeholder="请输入密码">
							</div>
						<div class="alert alert-error">
			              <i class="iconfont">&#xe62e;</i>
			              <span>${errorMsg }</span>
			            </div>
							<div class="enter">
								<a href="javascript:;" class="purchaser" onClick="javascript:login();">登录</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
			</div>
			<div class="address">地址：内蒙古鄂尔多斯市&nbsp;邮编：017000&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2019&nbsp;-&nbsp;2030&nbsp;&nbsp;博为科技公司版权所有[服务电话：186-0477-3099]</div>
		</div>
	</div>
	<script type="text/javascript">
		function login(){
			document.getElementById("login_form").submit();
		}
	</script>
</body> 
</html>