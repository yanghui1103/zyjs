/**
 * 
 */

$(function(){
	hunterlistquery();
});


function hunterlistquery(){    
	$('#hunterlistDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'hunter/hunters/${param}'  ,   
        queryParams:   serializeFormToJSON($("#hunterlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', hidden:true  },
                   { field: 'name', title: '名称', width: '20%',fixed:true  },
                   { field: 'name', title: '类型', width: '20%',fixed:true  },
                   { field: 'name', title: '账号', width: '20%' },
                   { field: 'name', title: '状态', width: '20%' } ,
                   { field: 'name', title: '创建时间', width: '20%' }
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
            	 openUserDetail(row.id); 
             }     
	});  
}




//增加查询参数，在页面加载时运行  
function hunterReloadgrid() {  
	$('#hunterlistDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#hunterlistDg').datagrid('options').queryParams= serializeFormToJSON($("#hunterlistFM").serializeArray());  
	$("#hunterlistDg").datagrid('reload');
}  

