/**
 * 
 */


$(function(){
	rolelistquery();
});


function rolelistquery(){    
	$('#roleListDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'role/roles' ,   
        queryParams:   serializeFormToJSON($("#rolelistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'name', title: '名称', width: '40%',fixed:true  },
                   { field: 'temp_str1', title: '正在使用人数', width: '20%' },
                   { field: 'creator', title: '创建者', width: '20%' }, 
                   { field: 'createTime', title: '创建日期', width: '20%' } 
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
             striped: true //奇偶行是否区分      
	});  
}




//增加查询参数，在页面加载时运行  
function roleReloadgrid() {  
	$('#roleListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#roleListDg').datagrid('options').queryParams= serializeFormToJSON($("#rolelistFM").serializeArray());  
	$("#roleListDg").datagrid('reload');
}  


function deleteRole(){	 
	var row = getSingleTreeGridSelectData($("#roleListDg")); 
	if(parseInt(row.temp_str1)>0){
		promptMessage("1","此角色关联有效账户，故不得删除。");
		return ;
	}
	if(row !=null){
		promptMessageCallBack("3","是否确认删除该角色？",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "role/role/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						roleReloadgrid();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}
/*****
 * 打开分配功能权限
 */
function openRole2AuthPage(){
	var row = getSingleTreeGridSelectData($("#roleListDg")); 
	$('#_loadDialog_rolelist').dialog({    
	    title: '分配功能权限',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'role/authsOfRole/'+  row.id  ,    
	    modal: true   
	});
}


function openAddRole(){
	$('#_loadDialog_rolelist').dialog({    
	    title: '分配权限',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'system/gotoIframePage/system/role/roleAddPage/-9',    
	    modal: true   
	});
}


/*****
 * 打开分配data权限
 */
function openRole2DataAuthPage(){
	var row = getSingleTreeGridSelectData($("#roleListDg")); 
	$('#_loadDialog_rolelist').dialog({    
	    title: '分配数据权限',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'role/dataAuthsOfRole/'+  row.id  ,    
	    modal: true   
	});
}



/*****
 * 打开分配菜单权限
 */
function openRole2MenuPage(){
	var row = getSingleTreeGridSelectData($("#roleListDg")); 
	$('#_loadDialog_rolelist').dialog({    
	    title: '分配菜单权限',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'role/openMenusOfRole/'+  row.id  ,    
	    modal: true   
	});
}

function openAssignAccount(){
	var row = getSingleTreeGridSelectData($("#roleListDg")); 
	$('#_loadDialog_rolelist').dialog({    
	    title: '分配账号',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    maximizable:true,
	    href: ctx+'role/openAccountOfRole/'+  row.id  ,    
	    modal: true   
	});
}

