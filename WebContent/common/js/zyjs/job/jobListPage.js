/**
 * 职位管理JS
 * 
 */

/**
 * 
 */

$(function() {
	jobplistquery();
});

function jobplistquery() {
	$('#jobplistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'fair/jobs/' + $("#jobplistFMarea").val(),
		queryParams : serializeFormToJSON($("#jobplistFM").serializeArray()),
		remoteSort : false,
		frozenColumns:[[ {
			field : 'id',
			hidden : true
		},{
			field : 'name',
			title : '名称',
			width : '40%' 
		}]],
		columns : [ [  {
			field : 'temp_str1',
			title : '发布企业',
			width : '20%'
		}, {
			field : 'personNum',
			title : '招聘人数',
			width : '20%'
		}, {
			field : 'temp_str2',
			title : '招聘会',
			width : '10%'
		},  {
			field : 'temp_str3',
			title : '投递人数',
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
function jobpReloadgrid() {
	$('#jobplistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#jobplistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#jobplistFM").serializeArray());
	$("#jobplistDg").datagrid('reload');
}

function openDetail(id) {
		$('#_loadDialog_jobplist').dialog({
			title : '职位详情',
			width : '100%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'fair/job/'+id ,
			modal : true
		});
}




function deletejobp(){
	var row = getSingleTreeGridSelectData($("#jobplistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认下架此职位？",function(){					
			$.ajax({
				type : 'PUT',
				url : ctx + "fair/delJob/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						jobpReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}
