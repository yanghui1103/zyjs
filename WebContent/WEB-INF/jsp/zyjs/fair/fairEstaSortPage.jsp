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
							<td class="kv-label">名称</td>
							<td class="kv-content"><span id="name1">2018年秋季建筑行业用工专场</span></td>
							<td class="kv-label">举办地</td>
							<td class="kv-content"><span id="code">鄂尔多斯市康巴什会展中心</span></td>
							<td class="kv-label">联系电话</td>
							<td class="kv-content"><span id="simpleName">0477-8591234</span></td>
						</tr>
						<tr>
							<td class="kv-label">开始日期</td>
							<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
							<td class="kv-label">结束日期</td>
							<td class="kv-content"><span id="type">${hunter.address }</span></td>
							<td class="kv-label">创建时间</td>
							<td class="kv-content"><span id="isVisible">${hunter.compType }</span></td>
						</tr>
						<tr>
							<td class="kv-label">创建员</td>
							<td class="kv-content"><span id="type">${hunter.scale }</span></td>
							<td class="kv-label">状态</td>
							<td class="kv-content"><span id="isVisible">${hunter.netUrl }</span></td>
							<td class="kv-label">介绍</td>
							<td class="kv-content"><span id="isVisible">秋季建筑行业用工专场秋季建筑行业用工专场秋季建筑行业用工专场秋季建筑行业用工专场</span></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div title="报名企业" style="padding: 10px">
			<div title="报名企业" data-options="closable:false" class="basic-info">
				<table id="dg" class="easyui-datagrid"  style="width:100%; height: auto">
					<thead>
						<tr>
							<th data-options="field:'itemid',width:250,fixed:true">企业名称</th>
							<th data-options="field:'itemid',width:250">企业性质</th>
							<th data-options="field:'itemid',width:250">所属行业</th>
							<th data-options="field:'itemid',width:250">企业规模</th>
							<th
								data-options="field:'listprice',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}">
								序号</th>
							<th
								data-options="field:'listprice',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}">
								展位号</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>