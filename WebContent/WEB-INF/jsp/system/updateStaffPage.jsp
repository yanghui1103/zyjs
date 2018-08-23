<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/x-www-form-urlencoded; charset=UTF-8">
<script type="text/javascript">
$("button",navTab.getCurrentPanel()).click(function(){
	dwzConfirmFormToBack("是否确认修改用户资料?",function(){
		$('#company_id', navTab.getCurrentPanel()).val($('#topIds', navTab.getCurrentPanel()).val());
		$('#role_id', navTab.getCurrentPanel()).val($('#topIds2', navTab.getCurrentPanel()).val());
		$('#staff_group_id', navTab.getCurrentPanel()).val($('#topIds3', navTab.getCurrentPanel()).val());
		$('#postion_id', navTab.getCurrentPanel()).val($('#topIds4', navTab.getCurrentPanel()).val());

		
		$("#staffFm",navTab.getCurrentPanel()).submit();
	},function(){}); 
});
</script>
</head>
<body>
	<div class="pageContent">
		<form id="staffFm"   method=post
			action="<%=basePath %>system/updateStaff?navTabId=page101&callbackType=closeCurrent"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this,navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<p>
					<label>用户姓名：</label> <input name="staff_name" value="${model.staff_name }" class="required" minlength="2" maxlength=10
						type="text"   size="30" maxlength=30 />
				</p>
				<p>
					<label>登录帐号：</label> <input name="staff_number" value="${model.staff_number }" readonly class="required  readonly alphanumeric" minlength="2" maxlength=10
						type="text"   size="30" maxlength=30 />
				</p>
				<p>
					<label>联系电话：</label> <input name="phone"  class="phone" value="${model.phone }" 
						type="text"   size="30" maxlength=11 minlength="11" />
				</p>
				<p>
					<label>所属组织：</label><input type="text" class="required" style="float: left" readonly  value="${model.company_name }"  lookupGroup="orgLookup1" name="orgLookup1.names"   />
					<input type="hidden" id="topIds"  value="${model.company_id }"  lookupGroup="orgLookup1"  name="orgLookup1.ids"   />
					<input name="company_id" id="company_id" type="hidden">
					<a href='<%=basePath %>system/openSysAddressBook/0/22221/0/${model.fdid}/1' target="dialog"
						mask=true maxable=false mixable=false minable=false resizable=false drawable=true  
						 width="543" height="750" max="false"  lookupGroup="orgLookup1" title="地址本" class=btnLook ></a>
				</p>
				<p>
					<label>角色：</label><input type="text" class="required" style="float: left" readonly  value="${model.role_name }"  lookupGroup="orgLookup2" name="orgLookup2.names"   />
					<input type="hidden" id="topIds2"  value="${model.role_id }"  lookupGroup="orgLookup2"  name="orgLookup2.ids"   />
					<input name="role_id" id="role_id" type="hidden">
					<a href='<%=basePath %>system/openSysAddressBook/0/22212/1/${model.fdid}/2' target="dialog"
						mask=true maxable=false mixable=false minable=false resizable=false drawable=true  
						 width="543" height="750" max="false"  lookupGroup="orgLookup2" title="地址本" class=btnLook ></a>
				</p>
				<p>
					<label>用户组：</label><input type="text" class="required" style="float: left" readonly  value="${model.staff_group_name }"  lookupGroup="orgLookup3" name="orgLookup3.names"   />
					<input type="hidden" id="topIds3"  value="${model.staff_group_id }"  lookupGroup="orgLookup3"  name="orgLookup3.ids"   />
					<input name="staff_group_id" id="staff_group_id" type="hidden">
					<a href='<%=basePath %>system/openSysAddressBook/0/21222/1/${model.fdid}/3' target="dialog"
						mask=true maxable=false mixable=false minable=false resizable=false drawable=true  
						 width="543" height="750" max="false"  lookupGroup="orgLookup3" title="地址本" class=btnLook ></a>
				</p>
				<p>
					<label>岗位：</label><input type="text" class="required" style="float: left" readonly   value="${model.postion_name }" lookupGroup="orgLookup4" name="orgLookup4.names"   />
					<input type="hidden" id="topIds4"   value="${model.postion_id }" lookupGroup="orgLookup4"  name="orgLookup4.ids"   />
					<input name="postion_id" id="postion_id" type="hidden">
					<a href='<%=basePath %>system/openSysAddressBook/0/22122/1/${model.fdid}/4' target="dialog"
						mask=true maxable=false mixable=false minable=false resizable=false drawable=true  
						 width="543" height="750" max="false"  lookupGroup="orgLookup4" title="地址本" class=btnLook ></a>
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