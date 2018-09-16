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
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/common/common.js"></script>
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"
	rel="stylesheet">
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/static/lightblue/css/basic_info.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>


</head>
<body>
	<div id="tb" style="padding: 0 30px;">
		<form id="poorlistFM">
			关键词: <input class="easyui-textbox" type="text" name="keyWords"
				style="width: 166px; height: 35px; line-height: 35px;"></input> <a
				href="javascript:poorReloadgrid();" class="easyui-linkbutton"
				iconCls="icon-search" data-options="selected:true">查询</a> <a
				href="javascript:openDetail();" class="easyui-linkbutton"
				iconCls="icon-remove">详情</a> <a
				href="#" class="easyui-linkbutton"
				iconCls="icon-remove">变更户内人员</a>
		</form>
		<input name="area" id="poorlistFMarea" value="${arg }" type="hidden">
	</div>
	<table id="poorlistDg" style="width: 100%; height: 480px;">
	</table>
	<div id="_loadDialog_poorlist"></div>
</body>
<script type="text/javascript"
	src="<%=basePath%>common/js/zyjs/poorCard/poorListPage.js"></script>

</html>
