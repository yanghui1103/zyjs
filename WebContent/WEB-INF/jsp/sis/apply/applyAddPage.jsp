<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div title="居民申请录入单" data-options="closable:false" class="basic-info">
		<form id="planAddFm">
			<table class="kv-table">
				<tbody>
					<tr>
						<td class="kv-label">姓名</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">身份证号码</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					<tr>
						<td class="kv-label">性别</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">证件签发单位</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					<tr>
						<td class="kv-label">出生日期</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">民族</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					<tr>	
						<td class="kv-label"></td>
						<td class="kv-content">
							<button type="button">读取身份证卡片</button>
							<button type="button">申领概况</button>
						</td>
					</tr>
					
					
					<tr>
						<td class="kv-label">申请类型</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">申请周期</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					
					<tr>
						<td class="kv-label">就业单位类型</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">就业单位</td>
						<td class="kv-content"><input class="easyui-textbox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					<tr>
						<td class="kv-label">缴费开始月份</td>
						<td class="kv-content"><input class="easyui-datebox"
							name="name" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
						<td class="kv-label">缴费结束月份</td>
						<td class="kv-content"><input class="easyui-datebox"
							name="projName" style="width: 70%; paddding-right: 2px"
							data-options="required:true,validType:['length[1,60]']"></td>
					</tr>
					
					<tr>	
						<td class="kv-label"></td>
						<td class="kv-content">
							<button type="button">上传附件</button>
							<button type="button">高拍仪上传附件</button>
						</td>
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