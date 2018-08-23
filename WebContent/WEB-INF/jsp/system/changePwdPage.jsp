<%@ page language="java" contentType="text/html; charset=UTF-8"   import="com.bw.fit.common.model.LogUser"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<div class="pageContent">
		<form method=post
			action="<%=basePath %>system/changePwd?callbackType=closeCurrent"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>当前用户:</label> <input value="<%=((LogUser)session.getAttribute("LogUser")).getUser_name()  %>" type="text"
						size="30" readonly  maxlength=20 />
				</p>
				<p>
					<label>用户账号:</label> <input name="staff_number" value="<%=((LogUser)session.getAttribute("LogUser")).getUser_cd()  %>" type="text"
						size="30" readonly  maxlength=20 />
				</p>
				<p>
					<label>原密码:</label> <input name="passwd" type="password"
						size="30"  class="required"   maxlength=6 minlength=6 />
				</p> 
				<p>
					<label>新密码:</label> <input name="temp_str1" id="temp_str1" type="password"
						size="30"  class="required alphanumeric"   maxlength=6 minlength=6 />
				</p> 
				<p>
					<label>重输新密码:</label> <input name="temp_str2" type="password"
						size="30"  class="required alphanumeric" maxlength=6 minlength=6  equalto="#temp_str1" />
				</p> 
 			</div>
 			<input type="hidden" value="<%=((LogUser)session.getAttribute("LogUser")).getUser_id() %>" name="fdid" />
			<div class="formBar" id="panelBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" >保存</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>