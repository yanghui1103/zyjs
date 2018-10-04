/**
 * 
 */

$(function() {
	kindlistquery();
});

function kindlistquery() {
	$('#kindlistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'kind/kinds' ,
		queryParams : serializeFormToJSON($("#kindlistFM").serializeArray()),
		frozenColumns:[[ {
			field : 'id',
			hidden : true
		},{
			field : 'name',
			title : '类型名称',
			width : '20%' 
		},{
			field : 'address',
			title : '所属旗区',
			width : '10%'
		}]],
		columns : [ [   {
			field : 'introduction',
			title : '简短描述',
			width : '30%'
		}, {
			field : 'introduction',
			title : '状态',
			width : '20%'
		}, {
			field : 'endDate',
			title : '是否审核',
			width : '10%'
		}  ] ],
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
function kindReloadgrid() {
	$('#kindlistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#kindlistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#kindlistFM").serializeArray());
	$("#kindlistDg").datagrid('reload');
}

function openDetail(id) {
		$('#_loadDialog_kindlist').dialog({
			title : '招聘会详情',
			width : '100%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'kind/kind/'+id ,
			modal : true
		});
}
  