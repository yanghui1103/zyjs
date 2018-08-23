<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="float: right;margin-right:30px;margin-top:5px" >
		<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			onclick="updateDict();" style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="dicteditFm"  class="easyui-form" method="post"
		data-options="novalidate:false">	
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>名称</div>
			<input class="easyui-textbox" name="dictName" style="width: 80%;paddding-right:2px"   value="${dict.dictName }"
				data-options="required:true,validType:['length[0,20]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>编码</div>
			<input class="easyui-textbox" name="dictValue" style="width: 80%;paddding-right:2px"    value="${dict.dictValue }"
				data-options="required:true,validType:['length[0,10]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>排序号</div>
			<input class="easyui-numberbox" name="sortNumber" style="width: 80%;paddding-right:2px"    value="${dict.sortNumber }"
				data-options="required:true,validType:['length[0,3]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>可增加</div>
			<select class="easyui-combobox" name="canAdd"   editable=false labelPosition="top" style="width:80%;">
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</div>	
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>可修改</div>
			<select class="easyui-combobox" name="canEdit"   editable=false labelPosition="top" style="width:80%;">
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</div>	
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>可删除</div>
			<select class="easyui-combobox" name="canDel"   editable=false labelPosition="top" style="width:80%;">
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</div>	
		<input type="hidden" name="id" value="${dict.id }" >
		<input type="hidden" name="_method" value="put" >
	</form>	
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/dict/dictEditPage.js"></script>
	<script type="text/javascript">

	$(function(){
		$("select[name='canAdd']").val(${dict.canAdd });
		$("select[name='canEdit']").val(${dict.canEdit });
		$("select[name='canDel']").val(${dict.canDel });
	});
	</script>
</body>
</html>