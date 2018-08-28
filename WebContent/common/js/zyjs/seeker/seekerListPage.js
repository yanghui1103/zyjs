/**
 * 
 */

$(function() {
	seekerlistquery();
});

function seekerlistquery() {
	$('#seekerlistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'seeker/seekers/' + $("#seekerlistFMarea").val(),
		queryParams : serializeFormToJSON($("#seekerlistFM").serializeArray()),
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
			field : 'education',
			title : '学历',
			width : '20%'
		}, {
			field : 'cardId',
			title : '身份证',
			width : '20%'
		}, {
			field : 'email',
			title : 'email',
			width : '10%'
		}, {
			field : 'createTime',
			title : '转招聘方时间',
			width : '20%'
		}, {
			field : '意向工作地',
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
function seekerReloadgrid() {
	$('#seekerlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#seekerlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#seekerlistFM").serializeArray());
	$("#seekerlistDg").datagrid('reload');
}

function openAuditseeker() {
	var row = getSingleTreeGridSelectData($("#seekerlistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_seekerlist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'seeker/audit/' + id,
			modal : true
		});
	}
}

function openBlackseeker(){
	var row = getSingleTreeGridSelectData($("#seekerlistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_seekerlist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'seeker/black/' + id,
			modal : true
		});
	}
}
