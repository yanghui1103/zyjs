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
	<link href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
    <link href="<%=basePath%>common/fit/v4/static/lightblue/css/basic_info.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
	<link rel="stylesheet" href="<%=basePath%>common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>common/fit/v4/static/lightblue/css/providers.css">
	
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/common/common.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" src="<%=basePath%>common/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/ztree/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/position/positionLeftTree.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/position/positionListPage.js"></script>
<style type="text/css">
.messager-body{line-height:50px}.messager-window .messager-icon{margin-left:35px}.messager-window .messager-button{border-top:0;background:#fff}.jq-form{margin:10px;padding:0 9px;background:#f1f1f1;font-size:14px}.jq-form .jq-form-row{padding:0 165px;min-height:45px;line-height:45px}.jq-form .jq-form-row.jq-form-submit{height:80px;line-height:80px}.jq-form .jq-form-row.even{background:#fff}.jq-form .jq-form-row>label{float:left;margin-left:-165px;padding-left:30px;width:135px}.jq-form .jq-form-row .jq-form-control{float:left;width:100%}.jq-form .jq-form-row .jq-form-control .jq-form-input{width:100%;height:31px;padding:0 10px;box-sizing:border-box}.jq-form .jq-form-row .jq-form-control .jq-form-textarea{margin-top:10px;width:100%;height:110px;padding:5px;box-sizing:border-box}.jq-form .jq-form-row .jq-form-tip{float:right;margin-right:-165px;padding-left:20px;width:145px;color:#7f7f7f}.jq-form .jq-form-row .jq-form-tip .important{color:#df0000}.jq-form .jq-form-row.jq-form-time .textbox{width:auto!important;height:30px!important;line-height:30px!important}.jq-form .jq-form-row.jq-form-time .textbox-text{width:314px!important;height:30px!important;line-height:30px!important}
</style>
</head> 
<body>
	<div class="container">
		<div class="left-tree">
		<input type="hidden" value="${sessionScope.CurrentUser.currentOrgId}" id="org_id" />
		<input type="hidden" value="-1" id="org_ids" />
		<label class="kv-label">关键词:</label><input type="text" id="key" value="" class="empty" />
			<div style="display:none">
 			<input type="radio" id="name" name="keyType" class="radio first" checked />
				<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio" style="margin-left:36px;" checked />
			</div>
			<div class="zTreeDemoBackground left">
				<ul id="positionTree" class="ztree"></ul>
			</div>
		</div>
		<div class="content">
			<div class="easyui-tabs1" style="width:100%;">					
		      <div title="岗位列表" data-options="closable:false" class="basic-info">
		      	<div id="_loadDialog_positionList"></div>
		      	<div id="_loadDialog_address"></div>
		      	<table id="positionLiDg" style="width:100%;height:470px" >
       			</table>
		      </div>
		    </div>
		    <div style="padding: 0 20px; float: right;position: absolute;top:0px;right:0px">
				<a href="javascript:addPositionPage();" class="easyui-linkbutton" iconCls="icon-add"
					data-options="selected:true">新增</a> 
				<a href="javascript:openEditPosition()" class="easyui-linkbutton" iconCls="icon-edit" >编辑</a> 
				<a href="javascript:deletePosition();" class="easyui-linkbutton" iconCls="icon-remove" >删除</a> 
			</div>	
		</div>
	</div>
	
</body>
</html>
<script type="text/javascript">
$('.easyui-tabs1').tabs({
    tabHeight: 36,
    onSelect: function() {
    	setTimeout(function() {
  		resizeTabs();
  	},100)
    }
  });
  $(window).resize(function(){
  	$('.easyui-tabs1').tabs("resize");
  	setTimeout(function() {
  		resizeTabs();
  	},100)
  }).resize();
  function resizeTabs() {
		var $body = $('body'),
			$window = $(window);

		if($window.height() > $body.height()) {

			$('.panel-body').height($window.height() - 44);

		}
  }
    </script>
