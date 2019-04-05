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
					<td class="kv-label">职位名称</td>
					<td class="kv-content"><span id="name1">${job.name }</span></td>
					<td class="kv-label">学历要求</td>
					<td class="kv-content"><span id="code">${job.education }</span></td>
					<td class="kv-label">需要人数</td>
					<td class="kv-content"><span id="simpleName">${job.personNum }</span></td>
				</tr>
				<tr>
					<td class="kv-label">工作描述</td>
					<td class="kv-content"><span id="adminer">${job.describe }</span></td>
					<td class="kv-label">专业要求</td>
					<td class="kv-content"><span id="isVisible">${job.major }</span></td>
					<td class="kv-label">其他要求</td>
					<td class="kv-content"><span id="type">${job.requirement }</span></td>
				</tr>
				<tr>
					<td class="kv-label">福利</td>
					<td class="kv-content"><span id="type">${job.welfare }</span></td>
					<td class="kv-label">工作内容</td>
					<td class="kv-content"><span id="isVisible">${job.workContent }</span></td>
					<td class="kv-label">工作地点</td>
					<td class="kv-content"><span id="isVisible">${job.workPlace }</span></td>
				</tr>
				<tr>
					<td class="kv-label">薪资</td>
					<td class="kv-content"><span id="type">${job.welfarePrice }</span></td>
					<td class="kv-label">联系电话</td>
					<td class="kv-content"><span id="isVisible">${job.contactPhone }</span></td>
					<td class="kv-label">上架时间</td>
					<td class="kv-content"><span id="isVisible">${job.createTime }</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>