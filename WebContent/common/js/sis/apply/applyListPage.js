/**
 * 
 */

$(function() {
	applylistquery();
});

function applylistquery() {
	$('#applylistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'apply/applys'  ,
		queryParams : serializeFormToJSON($("#applylistFM").serializeArray()),
		remoteSort : false,
		frozenColumns:[[ {
			field : 'id',
			hidden : true
		},{
			field : 'name',
			title : '姓名',
			width : '10%' 
		}]],
		columns : [ [  {
			field : 'address',
			title : '身份证号码',
			width : '10%'
		}, {
			field : 'introduction',
			title : '性别',
			width : '10%'
		}, {
			field : 'typeCode',
			title : '申报类型(区域)',
			width : '20%'
		}, {
			field : 'startDate',
			title : '申报周期',
			width : '20%'
		}, {
			field : 'endDate',
			title : '来源',
			width : '10%'
		}, {
			field : 'f',
			title : '录入时间',
			width : '10%'
		}, {
			field : 'e4',
			title : '录入员',
			width : '10%'
		}  ] ],
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
function applyReloadgrid() {
	$('#applylistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#applylistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#applylistFM").serializeArray());
	$("#applylistDg").datagrid('reload');
}

function openAddapply(){
	$('#_loadDialog_applylist').dialog({
		title : '新增申请',
		width : '100%',
		height : 500,
		closed : false,
		cache : false,
		maximizable : true,
		href : ctx + 'system/gotoIframePage/sis/apply/applyAddPage/-9'  ,
		modal : true
	});
}