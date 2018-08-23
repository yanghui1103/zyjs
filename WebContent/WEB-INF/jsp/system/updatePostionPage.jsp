<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$("button",navTab.getCurrentPanel()).click(function(){
	dwzConfirmFormToBack("是否确认修改岗位?",function(){
		$("#postionFm",navTab.getCurrentPanel()).submit();
	},function(){}); 
});
</script>
</head>
<body>
	<div class="pageContent">
		<form id="postionFm"   method=post 
			action="<%=basePath %>system/updatePostion?navTabId=page105&callbackType=closeCurrent"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>岗位名称：</label> <input name="postion_name" value="${model.postion_name }" class="required" minlength="2"  
						type="text"   size="30" maxlength=30 />
				</p>
				<p>
					<label>描述：</label> <input name="desp" class="required" minlength="2"    value="${model.desp }" 
						type="text"   size="30" maxlength=30 />
				</p>
			</div>
			<input name="fdid" value="${model.fdid}" type="hidden" />
			<div class="formBar" id="panelBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="button">保存</button>
							</div>
						</div></li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>