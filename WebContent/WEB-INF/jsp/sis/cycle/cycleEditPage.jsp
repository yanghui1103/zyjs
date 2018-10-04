<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div title="操作" data-options="closable:false" class="basic-info">
		<form id="planAddFm">
			<table class="kv-table">
				<tbody>
					<tr>
						<td class="kv-label">周期名称</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">申报类型</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					<tr>
						<td class="kv-label">开始日期</td>
						<td class="kv-content"><input class="easyui-datebox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">截至日期</td>
						<td class="kv-content"><input class="easyui-datebox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
				</tbody>
			</table>
		</form>
		</br>
		<div style="float: right; margin-right: 30px;">
			<button class="easyui-linkbutton" type=button iconCls="icon-add"
				data-options="selected:true" onclick="planAdd();"
				style="width: 150px">保存</button>
		</div>
	</div>

</body>
</html>