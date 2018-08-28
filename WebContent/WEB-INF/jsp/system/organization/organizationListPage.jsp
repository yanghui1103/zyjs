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
	
	
	<link rel="stylesheet" href="<%=basePath%>common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListPage.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListAdminPage.js"></script>

</head> 
<body>
	<div class="container">
		<div class="left-tree">
		<label class="kv-label">关键词:</label><input type="text" id="key" value="" class="empty" />
			<div style="display:none">
 			<input type="radio" id="name" name="keyType" class="radio first" checked />
				<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio" style="margin-left:36px;" checked />
			</div>
			<div class="zTreeDemoBackground left">
				<ul id="orgTree" class="ztree"></ul>
			</div>
		</div>
		
		<div class="content">
			<div class="easyui-tabs1" style="width:100%;">					
		      <div title="基本信息" data-options="closable:false" class="basic-info">
		      
					<div  class="column"><span class="current">注册信息</span></div>
		      	<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">组织名称</td>
							<td class="kv-content"><span id="name1"></span></td>
							<td class="kv-label">组织编码</td>
							<td class="kv-content"><span id="code"></span></td>
							<td class="kv-label">组织简称</td>
							<td class="kv-content"><span id="simpleName"></span></td>
						</tr>
						<tr>
							<td class="kv-label">类型</td>
							<td class="kv-content"><span id="type"></span></td>
							<td class="kv-label">地址薄显示与否</td>
							<td class="kv-content"><span id="isVisible"></span></td>
							<td class="kv-label">法人/负责人</td>
							<td class="kv-content"><span id="adminer"></span></td>
						</tr>
						
					</tbody>
				</table>
		      	
				<div class="column"><span class="current">联系信息</span></div>
		      	<table class="kv-table">
					<tbody>
						
						<tr>
							<td class="kv-label">联系电话</td>
							<td class="kv-content"><span id="phone"></span></td>
							<td class="kv-label">地址</td>
							<td class="kv-content"><span id="address"></span></td>
							<td class="kv-label">邮编</td>
							<td class="kv-content"><span id="postCode"></span></td>
						</tr>
						
						<tr>
							<td class="kv-label">组织简介</td>
							<td class="kv-content"><span id="summary"></span></td> 
							<input type="hidden" id="id" >
						</tr>
						
					</tbody>
				</table>
		      </div>
		    </div>
		    <div id="tb" style="padding: 0 20px; float: right;position: absolute;top:0px;right:0px">
				<a href="javascript:addOrgPage();" class="easyui-linkbutton" iconCls="icon-add"
					data-options="selected:true">新增</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" >编辑(未做)</a> 
				<a href="javascript:removeOrg();" class="easyui-linkbutton" iconCls="icon-remove" >删除</a> 
			</div>	
		</div>		 
	</div>
	<div id="_loadDialog_orgList"></div>
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
