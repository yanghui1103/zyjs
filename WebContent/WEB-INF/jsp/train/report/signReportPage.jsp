<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/common/common.js"></script>
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
	<link href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
    <link href="<%=basePath%>common/fit/v4/static/lightblue/css/basic_info.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div>
	<form id="fairAddFm"  class="easyui-form"  >
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<label>开始日期</label>
			<input class="easyui-datebox" id="startDate" data-options="required:true,editable:false"     >
			
			<label>结束日期</label>
			<input class="easyui-datebox" id="endDate" data-options="required:true,editable:false"    >
		</div>
	</form>	
		<a href="javascript:exportAllExcel();" target="_">导出职业培训报名Excel</a>
		<input id="pppth" value="<%=basePath %>" type="hidden">
	</div>
	<script type="text/javascript"> 
	 	
	 	function exportAllExcel(){ 
	 		var startDate = $("#startDate").datetimebox('getValue');
	 		var endDate = $("#endDate").datetimebox('getValue');
	 		var pppth = $("#pppth").val();
	 		if(endDate!='' && startDate !=''){
		 		window.open(pppth + "trainRpt/rpt/"+startDate+"/"+endDate );
	 		}
	 	}
	</script>

</body>
</html>