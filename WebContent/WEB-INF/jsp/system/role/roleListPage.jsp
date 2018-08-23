<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
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
    <link href="<%=basePath%>common/fit/v4/static/lightblue/css/providers.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>	
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/custom/lightblue/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/role/roleListPage.js"></script>
</head> 
<body>	
    <div>
      <div id="tb" style="padding:0 30px;">
		<form id="rolelistFM">
        	关键词: <input class="easyui-textbox"   type="text" name="keyWords" style="width:166px;height:35px;line-height:35px;"></input>
        <a href="javascript:roleReloadgrid();" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a> 
        <a href="javascript:openAddRole();" class="easyui-linkbutton" iconCls="icon-add" >新增</a> 
        <a href="javascript:openAssignAccount();" class="easyui-linkbutton" iconCls="icon-edit" >分配账号</a> 
        <a href="javascript:openRole2AuthPage();" class="easyui-linkbutton" iconCls="icon-edit" >配置功能权限</a> 
        <a href="javascript:openRole2DataAuthPage();" class="easyui-linkbutton" iconCls="icon-edit" >配置数据权限</a> 
        <a href="javascript:openRole2MenuPage();" class="easyui-linkbutton" iconCls="icon-edit" >配置菜单权限</a> 
        <a href="javascript:deleteRole();" class="easyui-linkbutton" iconCls="icon-remove" >删除</a> 
        </form>
      </div>      
       <table id="roleListDg" style="width:100%;height:480px;" >
        </table>
    </div>      
	<div id="_loadDialog_rolelist"></div>
	<div id="_loadDialog_address"></div>
	
</body> 
</html>
