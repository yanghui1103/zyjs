/**
 * 
 */

$(function() {
	cyclelistquery();
});

function cyclelistquery() {
	$('#cyclelistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'cycle/cycles/' + $("#cyclelistFMarea").val(),
		queryParams : serializeFormToJSON($("#cyclelistFM").serializeArray()),
		remoteSort : false,
		frozenColumns:[[ {
			field : 'id',
			hidden : true
		},{
			field : 'name',
			title : '周期名称',
			width : '20%' 
		}]],
		columns : [ [  {
			field : 'address',
			title : '开始日期',
			width : '10%'
		}, {
			field : 'introduction',
			title : '结束日期',
			width : '10%'
		}, {
			field : 'typeCode',
			title : '申报类型(区域)',
			width : '30%'
		}, {
			field : 'startDate',
			title : '录入时间',
			width : '10%'
		}, {
			field : 'endDate',
			title : '录入员',
			width : '10%'
		}, {
			field : 'status',
			title : '状态',
			width : '10%'
		} ] ],
		fit : true,
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
function cycleReloadgrid() {
	$('#cyclelistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#cyclelistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#cyclelistFM").serializeArray());
	$("#cyclelistDg").datagrid('reload');
}

function openDetail(id) {
		$('#_loadDialog_cyclelist').dialog({
			title : '招聘会详情',
			width : '100%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'cycle/cycle/'+id ,
			modal : true
		});
}
 
function openAddcycle(){
	$('#_loadDialog_cyclelist').dialog({
		title : '新增周期',
		width : '99%',
		height : 500,
		closed : false,
		cache : false,
		maximizable : true,
		href : ctx + 'system/gotoIframePage/sis/cycle/cycleEditPage/-9',
		modal : true
	});
}

function openAddApply(){
	$('#_loadDialog_cyclelist').dialog({
		title : '新增周期',
		width : '99%',
		height : 500,
		closed : false,
		cache : false,
		maximizable : true,
		href : ctx + 'system/gotoIframePage/sis/apply/applyAddPage/-9',
		modal : true
	});
	
}
 