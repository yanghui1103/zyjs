<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
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
	
</head>
<body>
	<div id="tb" style="padding: 0 30px;">
		<form id="seekerlistFM">
			关键词: <input class="easyui-textbox" type="text" name="keyWords"
				style="width: 166px; height: 35px; line-height: 35px;"></input> <a
				href="javascript:seekerReloadgrid();" class="easyui-linkbutton"
				iconCls="icon-search" data-options="selected:true">查询</a> <a
				href="javascript:openBlackseeker();" class="easyui-linkbutton"
				iconCls="icon-remove">拉黑/拉白</a><a
				href="#" class="easyui-linkbutton"
				iconCls="icon-remove">指定为建档立卡户户主</a><a
				href="#" class="easyui-linkbutton"
				iconCls="icon-remove">取消建档立卡户户主</a><a
				href="#" class="easyui-linkbutton"
				iconCls="icon-remove">指定为城镇就业困难户户主</a><a
				href="#" class="easyui-linkbutton"
				iconCls="icon-remove">取消城镇就业困难户户主</a>
		</form>
		<input name="area" id="seekerlistFMarea" value="${area }"
			type="hidden">
	</div>
	<table id="seekerlistDg" style="width: 100%; height: 480px;">
	</table>
	<div id="_loadDialog_seekerlist"></div>
</body>
<script type="text/javascript"
	src="<%=basePath%>common/js/zyjs/seeker/seekerListPage.js"></script>

</html>
