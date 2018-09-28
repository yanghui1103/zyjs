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
	<script type="text/javascript" src="<%=basePath%>common/js/system/account/accountListPage.js"></script>
</head> 
<body>	
        
      <div id="tb" style="padding:0 30px;">
		<form id="accountlistFM">
        	用户姓名: <input class="easyui-textbox" type="text" name="name" style="width:166px;height:35px;line-height:35px;"></input>
        	账号: <input class="easyui-textbox" type="text" name="logName" style="width:166px;height:35px;line-height:35px;"></input>
        <a href="javascript:accountReloadgrid();" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a> 
                <shiro:hasRole name="OPT_ACNT"> 
        <a href="javascript:openAddAccount();" class="easyui-linkbutton" iconCls="icon-add" >新增</a> 
        <a href="javascript:openTransferAccount();" class="easyui-linkbutton" iconCls="icon-edit" >过户</a> 
        <a href="javascript:deleteAccount();" class="easyui-linkbutton" iconCls="icon-remove" >作废</a> 
        </shiro:hasRole>
        </form>
      </div>  
      
       <table id="accountListDg" style="width:100%;height:480px;" >
        </table>
    <div id="_loadDialog_accountlist"></div>  
    <div id="_loadDialog_address"></div>
</body> 
</html>
