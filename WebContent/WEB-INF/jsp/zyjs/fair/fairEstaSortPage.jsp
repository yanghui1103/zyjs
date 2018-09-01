<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
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
	<div class="easyui-tabs" data-options="tabWidth:112"
		style="width: 100%; height: auto">
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
			<div style="float: right;margin-top:5px" >
				<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
					onclick="updateSortHunter();"  style="width: 150px">保存</button>
				</div>
	
				<table id="hunterOfFdg" class="easyui-datagrid"  style="width:100%; height: auto" data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				method: 'get',
				url:'<%=basePath %>fair/hunters/${fair.id }', 
				onClickCell: onClickCell
				">
					<thead>
						<tr>
							<th data-options="field:'id',hidden:true "></th>
							<th data-options="field:'name',width:250,fixed:true,align:'center'">企业名称</th>
							<th data-options="field:'compType',width:200,align:'center'">企业性质</th>
							<th data-options="field:'industry',width:250,align:'center'">所属行业</th>
							<th data-options="field:'scale',width:250,align:'center'">企业规模</th>
							<th
								data-options="field:'serialNumber',validType:['length[0,4]'],width:100,align:'center',editor:{type:'numberbox',options:{precision:0}}">
								序号</th>
							<th
								data-options="field:'ptCode',validType:['length[0,10]'],width:100,align:'center',editor:{type:'textbox'}">
								展位号</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<input id="fairIdf" value="${fair.id }" type="hidden">
	<script type="text/javascript">
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
				field: 'id'
			});
		}
		

		function getChanges(){
			var rows = $('#hunterOfFdg').datagrid('getChanges');
			return rows  ;
		}
		
		function updateSortHunter(){
			var fairId = $("#fairIdf").val();
			var rows = getChanges();
			if(rows != null){
				for(var i=0;i<rows.length;i++){
					save(rows[i].id,rows[i].serialNumber,rows[i].ptCode,fairId)
				}
			}

		}
		
		function save(id,number,ptcode,fairId){
			$.ajax({
				type : 'PUT',
				url : ctx + "fair/sortSave/"+id+"/"+fairId+"/"+number+"/"+ptcode,
				data : {},
				success : function(data) {
					if(data.res !='2'){
						promptMessage(data.res, data.msg);
					}
				},
				dataType : "JSON",
				error:function(e){
					promptMessage("1","排序时发生异常");
				}
			});
		}
	</script>
</body>
</html>