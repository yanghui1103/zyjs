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

		<div title="报名企业" style="padding: 10px">
			<div title="报名企业" data-options="closable:false" class="basic-info">
			
			<div style="float: left;margin-top:1px" >
				<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			 		style="width: 150px">保存</button>
			</div>
				<table id="hunterOfFdg" class="easyui-datagrid"  style="width:100%; height: auto" data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				method: 'get',
				onClickCell: onClickCell,
				onEndEdit: onEndEdit
				">
					<thead>
						<tr>
							<th data-options="field:'id',hidden:true "></th>
							<th data-options="field:'name',width:250,fixed:true,align:'center'">企业名称</th>
							<th data-options="field:'compType',width:200,align:'center'">企业性质</th>
							<th data-options="field:'industry',width:250,align:'center'">所属行业</th>
							<th data-options="field:'scale',width:250,align:'center'">企业规模</th>
							<th
								data-options="field:'serialNumber',width:100,align:'center',editor:{type:'numberbox',options:{precision:0}}">
								序号</th>
							<th
								data-options="field:'ptCode',width:100,align:'center',editor:{type:'textbox'}">
								展位号</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<input id="fairIdf" value="${fair.id }" type="hidden">
	<script type="text/javascript">
	$(function(){
		hfquery();
	});

	function  hfquery() {
		$('#hunterOfFdg').datagrid({
			pagination : true,
			method : "get",
			url : ctx + 'fair/hunters/' + $("#fairIdf").val(),
			queryParams : null ,
			remoteSort : false,
			fit : false,
			idField : "id",
			pagination : true,
			singleSelect : true,
			rownumbers : true,
			fitColumns : true,
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			striped : true 
		});
	}

		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#hunterOfFdg').datagrid('validateRow', editIndex)){
				$('#hunterOfFdg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (editIndex != index){
				if (endEditing()){
					$('#hunterOfFdg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					var ed = $('#hunterOfFdg').datagrid('getEditor', {index:index,field:field});
					if (ed){
						($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
					}
					editIndex = index;
				} else {
					setTimeout(function(){
						$('#hunterOfFdg').datagrid('selectRow', editIndex);
					},0);
				}
			}
		}
		function onEndEdit(index, row){
			var ed = $(this).datagrid('getEditor', {
				index: index,
				field: 'productid'
			});
			row.productname = $(ed.target).combobox('getText');
		}
	</script>
</body>
</html>