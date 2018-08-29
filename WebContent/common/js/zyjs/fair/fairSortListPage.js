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
			title : '举办地址',
			width : '20%'
		}, {
			field : 'industry',
			title : '介绍',
			width : '20%'
		}, {
			field : 'scale',
			title : '类型',
			width : '10%'
		}, {
			field : 'createTime',
			title : '开始日期',
			width : '20%'
		}, {
			field : 'status',
			title : '结束日期',
			width : '10%'
		}, {
			field : 'createTime',
			title : '录入时间',
			width : '20%'
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
function fairReloadgrid() {
	$('#fairlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#fairlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#fairlistFM").serializeArray());
	$("#fairlistDg").datagrid('reload');
}

function openSortFair(){
	$('#_loadDialog_fairlist').dialog({
		title : '招聘会企业排序',
		width : 800,
		height : 500,
		closed : false,
		cache : false,
		maximizable : true,
		href : ctx + 'fair/fairSort/11' ,
		modal : true
	});
}