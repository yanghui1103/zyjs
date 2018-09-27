/**
 * 
 */

$(function() {
	resumelistquery();
});

function resumelistquery() {
	$('#resumelistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'resume/resumes/' + $("#resumelistFMarea").val(),
		queryParams : serializeFormToJSON($("#resumelistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'temp_str1',
			title : '姓名',
			width : '20%',
			fixed : true
		}, {
			field : 'jobName',
			title : '求职岗位',
			width : '20%'
		}, {
			field : 'major',
			title : '专业',
			width : '20%'
		}, {
			field : 'years',
			title : '从业年限',
			width : '10%'
		}, {
			field : 'welware',
			title : '期望薪资',
			width : '20%'
		}, {
			field : 'createTime',
			title : '创建时间',
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
function resumeReloadgrid() {
	$('#resumelistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#resumelistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#resumelistFM").serializeArray());
	$("#resumelistDg").datagrid('reload');
}


function openDetail(id){ 
		$('#_loadDialog_resumelist').dialog({
			title : '简历详情',
			width : '99%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'resume/resume/'+id ,
			modal : true
		});
}
