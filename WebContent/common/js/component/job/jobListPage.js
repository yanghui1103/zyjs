/**
 * 
 */

$(function(){
	joblistquery();
});


function joblistquery(){    
	$('#jobListDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'job/jobs' ,   
        queryParams:   serializeFormToJSON($("#jobListFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', hidden:true  },
                   { field: 'name', title: '名称', width: '10%',fixed:true  },
                   { field: 'desp', title: '描述', width: '30%' },
                   { field: 'isValid', title: '状态', width: '20%' } ,
                   { field: 'runTime', title: '频率', width: '20%' },
                   { field: 'codeData', title: '执行代码', width: '20%' }
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
             striped: true  //奇偶行是否区分                 
	});  
}




//增加查询参数，在页面加载时运行  
function jobReloadgrid() {  
	$('#jobListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#jobListDg').datagrid('options').queryParams= serializeFormToJSON($("#jobListFM").serializeArray());  
	$("#jobListDg").datagrid('reload');
}  

