<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.bw.fit.common.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
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
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/custom/lightblue/easyui-lang-zh_CN.js"></script>
	
</head>
<body>
	<div style="float:right;padding:0px 1px">
        <shiro:hasRole name="OP_DDICT"> 
		<a class="easyui-linkbutton" iconcls="icon-add" onclick="javascript:addDictDlg();">增加</a>
		<a class="easyui-linkbutton" iconcls="icon-edit" onclick="javascript:editDictDlg();">修改</a>
		<a class="easyui-linkbutton" iconcls="icon-remove" onclick="javascript:deleteDict();">删除</a>
		</shiro:hasRole>	
	</div>
	<div id="_loadDialog_dictList"></div>
	<table title="数据字典列表" id="dataDictTreeGd"  class="easyui-treegrid" style="width:100%;height:100%"
			data-options="
				url: '<%=basePath %>dict/getDataDictList/0',
				method: 'get',
				lines: true,
				rownumbers: true,
				idField: 'id',
				treeField: 'dict_name'
			">
		<thead>
			<tr>
				<th data-options="field:'id'" hidden=true></th>
				<th data-options="field:'dict_name'" width="30%">名称</th>
				<th data-options="field:'dict_value'" width="25%" align="right">值</th>
				<th data-options="field:'num'" width="15%">序号</th>
				<th data-options="field:'can_add'" width="10%">可增加</th>
				<th data-options="field:'can_edit'" width="10%">可修改</th>
				<th data-options="field:'can_del'" width="10%">可删除</th>
			</tr>
		</thead>
	</table>

	<script type="text/javascript" src="<%=basePath%>common/js/system/dict/dictListPage.js"></script>
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
