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
	dwzConfirmFormToBack("是否确认修改用户组?",function(){
		$('#temp_str1', navTab.getCurrentPanel()).val($('#topIds', navTab.getCurrentPanel()).val());
		$("#grpFm",navTab.getCurrentPanel()).submit();
	},function(){}); 
});
</script>
</head>
<body>
	<div class="pageContent">
		<form id="grpFm"   method=post 
			action="<%=basePath %>system/updateStaffGrp?navTabId=page102&callbackType=closeCurrent"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>组名称：</label> <input name="group_name" value="${model.group_name }" class="required" minlength="2"  
						type="text"   size="30" maxlength=30 />
				</p>
				<p>
					<label>用户：</label><input type="text"  value="${model.temp_str2 }" class="required" style="float: left" readonly lookupGroup="orgLookup1" name="orgLookup1.names"   />
					<input type="hidden" id="topIds" lookupGroup="orgLookup1"  value="${model.temp_str1 }"  name="orgLookup1.ids"   />
					<input name="temp_str1" id="temp_str1" type="hidden">
					<a href='<%=basePath %>system/openSysAddressBook/0/12222/1/${model.fdid}/1' target="dialog"
						mask=true maxable=false mixable=false minable=false resizable=false drawable=true  
						 width="543" height="750" max="false"  lookupGroup="orgLookup1" title="地址本" class=btnLook ></a>
				</p>
			</div>
			<input name="fdid" value="${model.fdid }" type="hidden" />
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