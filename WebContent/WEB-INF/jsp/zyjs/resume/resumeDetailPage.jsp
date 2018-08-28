<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td class="kv-content"><span id="name1">${hunter.name }</span></td>
					<td class="kv-label">身份证号码</td>
					<td class="kv-content"><span id="code">${hunter.email }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="simpleName">${hunter.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">Email</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
					<td class="kv-label">学历</td>
					<td class="kv-content"><span id="type">${hunter.address }</span></td>
					<td class="kv-label">外语</td>
					<td class="kv-content"><span id="isVisible">${hunter.compType }</span></td>
				</tr>
				<tr>
					<td class="kv-label">外语水平</td>
					<td class="kv-content"><span id="type">${hunter.scale }</span></td>
					<td class="kv-label">意向工作地</td>
					<td class="kv-content"><span id="isVisible">${hunter.netUrl }</span></td>
					<td class="kv-label">就业状态</td>
					<td class="kv-content"><span id="isVisible">正在求职</span></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div title="简历信息" data-options="closable:false" class="basic-info">
		<div class="column">
			<span class="current">简历信息</span>
		</div>
		<table class="kv-table">
			<tbody>
				<tr>
					<td class="kv-label">求职职位</td>
					<td class="kv-content"><span id="name1">${hunter.name }</span></td>
					<td class="kv-label">所学专业</td>
					<td class="kv-content"><span id="code">${hunter.email }</span></td>
					<td class="kv-label">从业年限</td>
					<td class="kv-content"><span id="simpleName">${hunter.phone }</span></td>
				</tr>
				<tr>
					<td class="kv-label">工作能力</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
					<td class="kv-label">荣获奖励</td>
					<td class="kv-content"><span id="type">${hunter.address }</span></td>
					<td class="kv-label">期望薪资</td>
					<td class="kv-content"><span id="isVisible">${hunter.compType }</span></td>
				</tr>
				<tr>
					<td class="kv-label">自我评价</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
					<td class="kv-label">其他说明</td>
					<td class="kv-content"><span id="adminer">${hunter.industry }</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>