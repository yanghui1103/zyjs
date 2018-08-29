/**
 * 
 */
$(function() {
	hunterlistquery();
});

function hunterlistquery() {
	$('#hunterlistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'hunter/hunters/' + $("#hunterlistFMarea").val(),
		queryParams : serializeFormToJSON($("#hunterlistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '名称',
			width : '20%',
			fixed : true
		}, {
			field : 'compType',
			title : '性质',
			width : '20%'
		}, {
			field : 'industry',
			title : '行业',
			width : '20%'
		}, {
			field : 'scale',
			title : '规模',
			width : '10%'
		}, {
			field : 'createTime',
			title : '转招聘方时间',
			width : '20%'
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
		striped : true
	// 奇偶行是否区分
	});
}

// 增加查询参数，在页面加载时运行
function hunterReloadgrid() {
	$('#hunterlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#hunterlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#hunterlistFM").serializeArray());
	$("#hunterlistDg").datagrid('reload');
}

function openAuditHunter() {
	var row = getSingleTreeGridSelectData($("#hunterlistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_hunterlist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'hunter/audit/' + id,
			modal : true
		});
	}
}

function openBlackHunter(){
	var row = getSingleTreeGridSelectData($("#hunterlistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_hunterlist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'hunter/black/' + id,
			modal : true
		});
	}
}
