/**
 * 
 */

$(function() {
	fairlistquery();
});

function fairlistquery() {
	$('#fairlistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'fair/fairs/' + $("#fairlistFMarea").val(),
		queryParams : serializeFormToJSON($("#fairlistFM").serializeArray()),
		remoteSort : false,
		frozenColumns:[[ {
			field : 'id',
			hidden : true
		},{
			field : 'name',
			title : '名称',
			width : '20%' 
		}]],
		columns : [ [  {
			field : 'address',
			title : '举办地址',
			width : '20%'
		}, {
			field : 'introduction',
			title : '介绍',
			width : '20%'
		}, {
			field : 'typeCode',
			title : '类型',
			width : '10%'
		}, {
			field : 'startDate',
			title : '开始日期',
			width : '10%'
		}, {
			field : 'endDate',
			title : '结束日期',
			width : '10%'
		}, {
			field : 'status',
			title : '状态',
			width : '10%'
		} ] ],
		fit : false,
		idField : "id",
		pagination : true,
		singleSelect : true,
		rownumbers : true,
		fitColumns : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		striped : true, //奇偶行是否区分                 
        onDblClickRow: function (index, row) {  
       	 openDetail(row.id); 
        }     
	});
}

// 增加查询参数，在页面加载时运行
function fairReloadgrid() {
	$('#fairlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#fairlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#fairlistFM").serializeArray());
	$("#fairlistDg").datagrid('reload');
}

function openDetail(id) {
		$('#_loadDialog_fairlist').dialog({
			title : '招聘会详情',
			width : '100%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'fair/fair/'+id ,
			modal : true
		});
}
 

function openAddfair(){
	var area  = $("#fairlistFMarea").val();
		$('#_loadDialog_fairlist').dialog({
		title : '新增招聘会',
		width : '100%',
		height : 500,
		closed : false,
		cache : false,
		maximizable : true,
		href : ctx + 'fair/fairAdd/'+area,
		modal : true
	});
}
