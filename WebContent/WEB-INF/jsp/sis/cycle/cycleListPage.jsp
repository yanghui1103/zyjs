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
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>
</head> 
<body>
      <div style="padding:0 30px;">
		<form id="cyclelistFM">
        	关键词: <input class="easyui-textbox" type="text" name="keyWords" style="width:166px;height:35px;line-height:35px;"></input>
        	<a href="javascript:cycleReloadgrid();" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a> 
				<a href="javascript:openAddcycle();" class="easyui-linkbutton" iconCls="icon-add" >新增</a> 
				<a href="javascript:openAddcycle();" class="easyui-linkbutton" iconCls="icon-add" >编辑</a> 
        		<a href="javascript:closecycle();" class="easyui-linkbutton" iconCls="icon-remove" >开启/关闭</a> 
				<a href="javascript:openAddApply();" class="easyui-linkbutton" iconCls="icon-add" ><font color=red>发起申请</font></a> 
        </form>
        <input name="area" id="cyclelistFMarea" value="${area }" type="hidden">
      </div>
       <table id="cyclelistDg" style="width:100%;height:480px;" >
        </table>
        <div id="_loadDialog_cyclelist"></div>
</body> 
	<script type="text/javascript" src="<%=basePath%>common/js/sis/cycle/cycleListPage.js"></script>

</html>
