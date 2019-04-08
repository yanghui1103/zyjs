<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div title="基本信息" data-options="closable:false" class="basic-info">
		<div class="column">
			<span class="current">注册信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">姓名</td>
					<td class="kv-content"><span id="name1">${seeker.name }</span></td>
					<td class="kv-label">电子邮箱</td>
					<td class="kv-content"><span id="code">${seeker.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${seeker.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">学历</td>
					<td class="kv-content"><span id="type">${hunter.address }</span></td>
					<td class="kv-label">外语</td>
					<td class="kv-content"><span id="isVisible">${hunter.compType }</span></td>
					<td class="kv-label">外语水平</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
				</tr>
				<tr>
					<td class="kv-label">意向工作地</td>
					<td class="kv-content"><span id="type">${hunter.scale }</span></td>
				</tr>
			</tbody>
		</table>
		
		<div class="column">
			<span class="current">简历信息(含户内其他人员)</span>
		</div>
		
       <table id="poorDetailDg"  >
        </table>
		
		
		<div class="column">
			<span class="current">对贫困户资料操作日志</span>
		</div>
		
       <table id="poorOptDetailDg"  >
        </table>
	</div>
	
<script type="text/javascript">
	$(function(){
		initResumes($('#poorDetailDg'));
		initOpts($('#poorOptDetailDg'));
	});

function initResumes(obj){
	obj.datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'esta/estas/areadq'  ,
		queryParams : serializeFormToJSON($("#poorlistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '求职岗位',
			width : '20%',
			fixed : true
		}, {
			field : 'name',
			title : '姓名',
			width : '10%'
		}, {
			field : 'name',
			title : '身份证号码',
			width : '5%'
		}, {
			field : 'name',
			title : '与户主关系',
			width : '5%'
		}, {
			field : 'name',
			title : '贫困类型',
			width : '5%'
		}, {
			field : 'name',
			title : '录入时间',
			width : '10%'
		}, {
			field : 'name',
			title : '录入员',
			width : '10%'
		}, {
			field : 'name',
			title : '跟踪人',
			width : '10%'
		} , {
			field : 'name',
			title : '大数据推送职位次数',
			width : '10%'
		}  , {
			field : 'name',
			title : '人工推送职位次数',
			width : '10%'
		} ] ],
		fit : false,
		idField : "id",
		pagination : false,
		singleSelect : true,
		rownumbers : true,
		fitColumns : true,
		striped : true
	// 奇偶行是否区分
	});
}


function initOpts(obj){
	obj.datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'esta/estas/areadq'  ,
		queryParams : serializeFormToJSON($("#poorlistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '操作类型',
			width : '20%',
			fixed : true
		}, {
			field : 'name',
			title : '操作说明',
			width : '10%'
		}, {
			field : 'name',
			title : '操作人',
			width : '10%'
		}, {
			field : 'name',
			title : '操作时间',
			width : '10%'
		} ] ],
		fit : false,
		idField : "id",
		pagination : false,
		singleSelect : true,
		rownumbers : true,
		fitColumns : true,
		striped : true
	// 奇偶行是否区分
	});
}
</script>
</body>
</html>