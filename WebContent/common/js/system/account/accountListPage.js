/**
 * 
 */

$(function(){
	accountlistquery();
});


function accountlistquery(){    
	$('#accountListDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'account/accounts' ,   
        queryParams:   serializeFormToJSON($("#accountlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'temp_str2', title: 'ID' ,hidden:true  },
                   { field: 'id', hidden:true  },
                   { field: 'name', title: '用户姓名', width: '30%',fixed:true  },
                   { field: 'logName', title: '账号', width: '30%' },
                   { field: 'isdeleted', title: '状态', width: '20%' } ,
                   { field: 'temp_str3', title: '创建时间', width: '20%' }
               ]],
             fit: false ,    
             idField: "temp_str1",
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
function accountReloadgrid() {  
	$('#accountListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#accountListDg').datagrid('options').queryParams= serializeFormToJSON($("#accountlistFM").serializeArray());  
	$("#accountListDg").datagrid('reload');
}  


function openUserDetail(id){
	$('#_loadDialog_accountlist').dialog({    
	    title: '用户详情',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'user/openUserDetail/'+id,    
	    modal: true   
	}); 	
}




function deleteAccount(){	 
	var row = getSingleTreeGridSelectData($("#accountListDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认作废该账户？",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "account/account/"+row.temp_str2,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						accountReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}


function openAddAccount(){
	$('#_loadDialog_accountlist').dialog({    
	    title: '账户新增',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'system/gotoIframePage/system/account/accountAddPage/-9',    
	    modal: true   
	}); 	
}

function openTransferAccount(){
	var row = getSingleTreeGridSelectData($("#accountListDg"));
	$('#_loadDialog_accountlist').dialog({    
	    title: '账户过户',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'account/openAccountTransferPage/'+row.temp_str2,    
	    modal: true   
	}); 	
}