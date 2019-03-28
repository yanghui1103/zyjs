
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
	
	
	<script type="text/javascript" src="<%=basePath%>common/js/zyjs/esta/estaListPage.js"></script>

</head> 
<body>
	   
      <div id="tb" style="padding:0 5px;">
		<form id="estalistFM">
        	关键词: <input class="easyui-textbox" type="text" name="keyWords" style="width:166px;height:35px;line-height:35px;"></input>
        	<a href="javascript:estaReloadgrid();" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a> 
        	   <shiro:hasRole name="ETLUserAdmin"> 
        	<a href="javascript:stopExtenalCode();" class="easyui-linkbutton" iconCls="icon-remove" >禁用</a> 
        	<a href="javascript:startExtenalCode();" class="easyui-linkbutton" iconCls="icon-remove" >启用</a> 
        	<a href="javascript:initExtenalPwd();" class="easyui-linkbutton" iconCls="icon-edit" >初始化密码</a> 
        	<a href="javascript:openInnerMail();" class="easyui-linkbutton" iconCls="icon-edit" >发送站内信</a> 
        	</shiro:hasRole>
        </form>
        	<input name="area" id="area" value="${area }" type="hidden">
      </div>
      <div id="_loadDialog_estalist"></div>
       <table id="estalistDg" style="width:100%;height:480px;" >
        </table>
</body> 
</html>
