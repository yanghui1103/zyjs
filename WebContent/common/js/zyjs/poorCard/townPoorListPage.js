/**
 * 
 */

$(function() {
	townPoorlistquery();
});

function townPoorlistquery() {
	$('#townPoorlistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'poor/poors/' + $("#townPoorlistFMarea").val(),
		queryParams : serializeFormToJSON($("#towntownPoorlistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '户主姓名',
			width : '10%',
			fixed : true
		}, {
			field : 'cardId',
			title : '户主身份证号码',
			width : '10%'
		}, {
			field : 'major',
			title : '户籍',
			width : '10%'
		}, {
			field : 'years',
			title : '归属旗区',
			width : '10%'
		}, {
			field : 'years',
			title : '归属社区',
			width : '10%'
		}, {
			field : 'welware',
			title : '住址',
			width : '10%'
		}, {
			field : 'createTime',
			title : '贫困类型',
			width : '10%'
		}, {
			field : 'welware',
			title : '信息采集人',
			width : '10%'
		}, {
			field : 'welware',
			title : '跟踪人',
			width : '10%'
		}, {
			field : 'cc',
			title : '大数据推送职位次数',
			width : '10%'
		} , {
			field : 'cc',
			title : '人工推送职位次数',
			width : '10%'
		}, {
			field : 'cc',
			title : '是否脱困',
			width : '10%'
		}] ],
		fit : true,
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
function townPoorReloadgrid() {
	$('#townPoorlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#townPoorlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#townPoorlistFM").serializeArray());
	$("#townPoorlistDg").datagrid('reload');
}

function openAudittownPoor() {
	var row = getSingleTreeGridSelectData($("#townPoorlistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_townPoorlist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'poor/audit/' + id,
			modal : true
		});
	}
}