<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div title="基本信息" data-options="closable:false" class="basic-info">
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">名称</td>
					<td class="kv-content"><span id="name1">${fair.name }</span></td>
					<td class="kv-label">举办地</td>
					<td class="kv-content"><span id="code">${fair.address }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${fair.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">开始日期</td>
					<td class="kv-content"><span id="adminer">${fair.startDate }</span></td>
					<td class="kv-label">结束日期</td>
					<td class="kv-content"><span id="type">${fair.endDate }</span></td>
					<td class="kv-label">创建时间</td>
					<td class="kv-content"><span id="isVisible">${fair.createTime }</span></td>
				</tr>
				<tr>
					<td class="kv-label">创建员</td>
					<td class="kv-content"><span id="type">${fair.creator }</span></td>
					<td class="kv-label">状态</td>
					<td class="kv-content"><span id="isVisible">${fair.status }</span></td>
					<td class="kv-label">介绍</td>
					<td class="kv-content"><span id="isVisible">${fair.introduction }</span></td>
				</tr>
				<tr>
					<td class="kv-label">主办单位</td>
					<td class="kv-content"><span id="type">${fair.department }</span></td>
					<td class="kv-label">协办单位</td>
					<td class="kv-content"><span id="isVisible">${fair.department2 }</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>