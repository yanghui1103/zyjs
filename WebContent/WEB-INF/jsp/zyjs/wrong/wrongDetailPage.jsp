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
			<span class="current">主体信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">举报者名称</td>
					<td class="kv-content"><span id="name1">张三</span></td>
					<td class="kv-label">被举报者</td>
					<td class="kv-content"><span id="code">南京京东方科技公司</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	
	<div title="举报信息" data-options="closable:false" class="basic-info">
		<div class="column">
			<span class="current">举报信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">举报说明</td>
					<td class="kv-content"><span id="name1">这个家伙不好好讲明白，我要举报他;这个家伙不好好讲明白，我要举报他;这个家伙不好好讲明白，我要举报他;</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>