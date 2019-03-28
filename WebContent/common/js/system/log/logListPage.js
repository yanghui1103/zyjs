/**
 * 
 */

$(function(){
	listquery();
});


function listquery(){    
	$('#logListDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'log/logs' ,   
        queryParams:   serializeFormToJSON($("#loglistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  }, 
                   { field: 'creator', title: '操作人', width: '10%',fixed:true  },
                   { field: 'logType', title: '类型', width: '20%' },
                   { field: 'operateFunction', title: '执行方法', width: '30%' } ,
                   { field: 'result', title: '返回值', width: '20%' },
                   { field: 'createTime', title: '执行时间', width: '20%' }
               ]],
             fit: false ,    
             idField: "id",
             pagination: true,
             singleSelect:true,
             rownumbers: true, 
             fitColumns:true,
             pageNumber: 1,
             pageSize: 10,
             pageList: [ 10,20, 30, 40, 50],
             striped: true, //奇偶行是否区分                 
             onDblClickRow: function (index, row) {  
            	 openLogDetail(row.id); 
             }     
	});  
}




//增加查询参数，在页面加载时运行  
function  reloadgrid() {  
	$('#logListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#logListDg').datagrid('options').queryParams= serializeFormToJSON($("#loglistFM").serializeArray());  
	$("#logListDg").datagrid('reload');
}  
 
function openLogDetail(){	 
	var row = getSingleTreeGridSelectData($("#logListDg"));
	$('#_loadDialog_loglist').dialog({    
	    title: '日志详情',    
	    width: '90%',    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'log/log/'+row.id ,    
	    modal: true   
	}); 	

	
}