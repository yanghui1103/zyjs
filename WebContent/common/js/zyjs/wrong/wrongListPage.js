/**
 * 
 */

$(function() {
	wronglistquery();
});

function wronglistquery() {
	$('#wronglistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'wrong/wrongs/' + $("#wronglistFMarea").val(),
		queryParams : serializeFormToJSON($("#wronglistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'name',
			title : '举报者',
			width : '20%',
			fixed : true
		}, {
			field : 'compType',
			title : '被举报者',
			width : '20%'
		}, {
			field : 'industry',
			title : '举报内容',
			width : '20%'
		}, {
			field : 'scale',
			title : '举报时间',
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
function wrongReloadgrid() {
	$('#wronglistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#wronglistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#wronglistFM").serializeArray());
	$("#wronglistDg").datagrid('reload');
}

function openAuditwrong() { 
		$('#_loadDialog_wronglist').dialog({
			title : '招聘方详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'wrong/audit/' ,
			modal : true
		}); 
}

function openBlackwrong(){ 
		$('#_loadDialog_wronglist').dialog({
			title : '举报详情',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'wrong/wrong/2' ,
			modal : true
		}); 
}
