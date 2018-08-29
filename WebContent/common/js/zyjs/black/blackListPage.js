/**
 * 
 */

$(function() {
	blacklistquery();
});

function blacklistquery() {
	$('#blacklistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'black/blacks/' + $("#blacklistFMarea").val(),
		queryParams : serializeFormToJSON($("#blacklistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '主体名称',
			width : '20%',
			fixed : true
		}, {
			field : 'compType',
			title : '类型',
			width : '20%'
		}, {
			field : 'industry',
			title : '账号',
			width : '20%'
		}, {
			field : 'scale',
			title : '入网时间',
			width : '30%'
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
function blackReloadgrid() {
	$('#blacklistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#blacklistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#blacklistFM").serializeArray());
	$("#blacklistDg").datagrid('reload');
}

function openAuditblack() {
	var row = getSingleTreeGridSelectData($("#blacklistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_blacklist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'black/audit/' + id,
			modal : true
		});
	}
}

function openBlackDetail(){
		$('#_loadDialog_blacklist').dialog({
			title : '黑名单详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'black/black/33'  ,
			modal : true
		});
}