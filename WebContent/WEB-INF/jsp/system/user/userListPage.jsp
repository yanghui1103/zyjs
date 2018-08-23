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
	<script type="text/javascript" src="<%=basePath%>common/js/system/user/userListPage.js"></script>
</head> 
<body>	
    <div class="container">
      <div id="tb" style="padding:0 30px;">
		<form id="userlistFM">
        	关键词: <input class="easyui-textbox" type="text" name="keyWords" style="width:166px;height:35px;line-height:35px;"></input>
        <a href="javascript:userReloadgrid();" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a> 
        <a href="javascript:openAddUser();" class="easyui-linkbutton" iconCls="icon-add" >新增</a> 
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" >修改[未作]</a> 
        <shiro:hasRole name="DEL_USER"> 
        	<a href="javascript:deleteUser();" class="easyui-linkbutton" iconCls="icon-remove" >删除</a> 
        </shiro:hasRole>
        </form>
      </div>      
       <table id="userLiDg" style="width:100%;height:480px;" >
        </table>
    </div>      
	<div id="_loadDialog_userList"></div>
</body> 
</html>
