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
					<td class="kv-label">去往他的简历中心</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>