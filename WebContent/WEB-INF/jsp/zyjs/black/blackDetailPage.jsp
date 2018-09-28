<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="easyui-tabs" data-options="tabWidth:112"
		style="width: 100%; height: 250px">
		<div title="基本信息" style="padding: 10px">
			<div title="基本信息" data-options="closable:false" class="basic-info">
				<table class="kv-table">
					<tbody>
				<tr>
					<td class="kv-label">企业名称</td>
					<td class="kv-content"><span id="name1">${esta.name }</span></td>
					<td class="kv-label">电子邮箱</td>
					<td class="kv-content"><span id="code">${esta.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${esta.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">地址</td>
					<td class="kv-content"><span id="type">${esta.address }</span></td>
					<td class="kv-label">性质</td>
					<td class="kv-content"><span id="isVisible">${esta.compType }</span></td>
					<td class="kv-label">行业</td>
					<td class="kv-content"><span id="adminer">${esta.industry }</span></td>
				</tr>
				<tr>
					<td class="kv-label">规模</td>
					<td class="kv-content"><span id="type">${esta.scale }</span></td>
					<td class="kv-label">官网</td>
					<td class="kv-content"><span id="isVisible">${esta.netUrl }</span></td>
					<td class="kv-label">社会信用代码证号</td>
					<td class="kv-content"><span id="adminer">${esta.cardId }</span></td>
				</tr>
				<tr>
					<td class="kv-label">简介</td>
					<td class="kv-content"><span id="type">${hunter.introduction }</span></td>
				</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div title="对主体操作历史" style="padding: 10px">
			<div title="对主体操作历史" data-options="closable:false" class="basic-info">
				<table id="dg" class="easyui-datagrid"  style="width:100%; height: auto">
					<thead>
						<tr>
							<th data-options="field:'itemid',width:250,fixed:true">说明</th>
							<th data-options="field:'itemid2',width:250">操作类型</th>
							<th data-options="field:'itemid3',width:250">操作员</th>
							<th data-options="field:'itemid4',width:250">操作时间</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>拉黑你，是我们的责任</td>
							<td>拉黑</td>
							<td>李四</td>
							<td>2018-08-19 12:12:12</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>