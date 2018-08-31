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
			onclick="updateFair();"  style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="fairUpdateFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>招聘会名称</div>
			<input class="easyui-textbox"  name="name" value="${fair.name }" data-options="required:true,validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>类型</div>
			<select class="easyui-combogrid" name="typeCode"   editable="false"
				style="width: 30%" 
				data-options="limitToList:true,
					panelWidth: 200,
					value:'${fair.typeCode }',
					idField: 'dict_value',
					textField: 'dict_name',
					url: '<%=basePath%>dict/getDictsByParentValue/fairType',
					method: 'get', 
					columns: [[
						{field:'dict_value',title:'值',width:50},
						{field:'dict_name',title:'名称',width:140} 
					]],
					fitColumns: true, 
					required:true
				">
			</select>
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>联系电话</div>
			<input class="easyui-textbox" name="phone" value="${fair.phone }"  data-options="required:true,validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>主办单位</div>
			<input class="easyui-textbox" name="department" value="${fair.department }"  data-options="required:true,validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>协办单位</div>
			<input class="easyui-textbox" name="department2"  value="${fair.department2 }"  data-options="validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>举办地</div>
			<input class="easyui-textbox"  name="address"  value="${fair.address }"  data-options="required:true,validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>开始日期</div>
			<input class="easyui-datebox" name="startDate"  value="${fair.startDate }"  data-options="required:true,formatter:myformatter,parser:myparser"  style="width:80%;">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>结束日期</div>
			<input class="easyui-datebox" name="endDate"   value="${fair.endDate }"  data-options="required:true,formatter:myformatter,parser:myparser" style="width:80%;">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>介绍</div>
			<input class="easyui-textbox" name="introduction"   value="${fair.introduction }"   style="width:80%;height:60px" data-options="label:'Message:',multiline:true">
		</div>
		<input name="id" value="${fair.id }" type="hidden">
	</form>
	<script type="text/javascript">
	$(function(){
		
	});
	
	function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    
    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }
    
    function updateFair(){
		promptMessageCallBack("3", "是否确认修改招聘会？", function() {
			$.ajax({
				type : 'PUT',
				url : ctx + "fair/fair",
				data : ($("#fairUpdateFm").serialize()),
				success : function(data) {
					promptMessage(data.res, data.msg);
				},
				dataType : "JSON"
			});
		});		
    }
	</script>
</body>
</html>