/**
 * 
 */

$(function(){
	userlistquery();
});


function userlistquery(){    
	$('#userLiDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'user/users' ,   
        queryParams:   serializeFormToJSON($("#userlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'name', title: '名称', width: '20%',fixed:true  },
                   { field: 'gender', title: '性别', width: '20%' },
                   { field: 'type', title: '人员类型', width: '20%' }, 
                   { field: 'phone', title: '联系电话', width: '20%' }, 
                   { field: 'code', title: '编码', width: '20%'  }
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
function userReloadgrid() {  
	$('#userLiDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#userLiDg').datagrid('options').queryParams= serializeFormToJSON($("#userlistFM").serializeArray());  
	$("#userLiDg").datagrid('reload');
}  


function openUserDetail(id){
	$('#_loadDialog_userList').dialog({    
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


function openAddUser(){
	$('#_loadDialog_userList').dialog({    
	    title: '新增用户',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'system/gotoIframePage/system/user/userAddPage/-9' ,
	    modal: true   
	}); 		
}


function deleteUser(){	 
	var row = getSingleTreeGridSelectData($("#userLiDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认删除该用户？",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "user/user/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						userReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}