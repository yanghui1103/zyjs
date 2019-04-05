/**
 * 
 */

$(function() {
	finelistquery();
});

function finelistquery() {
	$('#finelistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'fine/fines/' + $("#finelistFMarea").val(),
		queryParams : serializeFormToJSON($("#finelistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		},{
			field : 'path',
			hidden : true
		}, {
			field : 'title',
			title : '主题',
			width : '50%',
			fixed : true
		}, {
			field : 'createTime',
			title : '发布时间',
			width : '20%'
		}, {
			field : 'creator',
			title : '发布者',
			width : '30%'
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
       	 openDetail(row.path); 
        }     
	});
}


function openDetail(path){
		$('#_loadDialog_finelist').dialog({    
		    title: '详情',    
		    width: '99%',    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    content:"<iframe scrolling='auto' frameborder='0' src='"+path+"' style='width:100%; height:100%; display:block;'></iframe>",    
		    modal: true   
		}); 	
}
// 增加查询参数，在页面加载时运行
function fineReloadgrid() {
	$('#finelistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#finelistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#finelistFM").serializeArray());
	$("#finelistDg").datagrid('reload');
}


function firstFine(){
	var row = getSingleTreeGridSelectData($("#finelistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认置顶？",function(){					
			$.ajax({
				type : 'PUT',
				url : ctx + "fine/update/0/"+row.id,
				data : {"_method":"PUT"},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						fineReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}


function deleteFine(){
	var row = getSingleTreeGridSelectData($("#finelistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认删除此记录？",function(){					
			$.ajax({
				type : 'PUT',
				url : ctx + "fine/update/1/"+row.id,
				data : {"_method":"PUT"},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						fineReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}