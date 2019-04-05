/**
 * 
 */

$(function(){
	estalistquery();
});


function estalistquery(){    
	$('#estalistDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'esta/estas/'+$("#area").val() ,   
        queryParams:   serializeFormToJSON($("#estalistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', hidden:true  },
                   { field: 'name', title: '名称', width: '20%',fixed:true  },
                   { field: 'temp_str1', title: '类型', width: '20%',fixed:true  },
                   { field: 'phone', title: '账号', width: '20%' },
                   { field: 'isdeleted', title: '状态', width: '20%' } ,
                   { field: 'createTime', title: '创建时间', width: '20%' }
               ]],
             fit: true ,    
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
            	 openExUserDetail(row.id,row.temp_str1); 
             }     
	});  
}




//增加查询参数，在页面加载时运行  
function estaReloadgrid() {  
	$('#estalistDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	$('#estalistDg').datagrid('options').queryParams= serializeFormToJSON($("#estalistFM").serializeArray());  
	$("#estalistDg").datagrid('reload');
}  


function openExUserDetail(id,type){
	if(type == '企业'){
		$('#_loadDialog_estalist').dialog({    
		    title: '外部用户详情',    
		    width: '99%',    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'esta/gotoDetail/'+id,    
		    modal: true   
		}); 	
	}else{
		$('#_loadDialog_estalist').dialog({    
		    title: '外部用户详情',    
		    width: '99%',    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'person/person/'+id,    
		    modal: true   
		}); 	
	}
}

function openInnerMail(){
	var row = getSingleTreeGridSelectData($("#estalistDg"));
	if(row !=null){
		$('#_loadDialog_estalist').dialog({    
		    title: '发送站内信',    
		    width: '99%',    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'innerMail/opensendMail/'+row.id+"/"+row.temp_str1,    
		    modal: true   
		}); 	
	}
	
}

function stopExtenalCode(){	 
	var row = getSingleTreeGridSelectData($("#estalistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认禁用该外部用户？",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "esta/esta/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						estalistquery();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}

function startExtenalCode(){	 
	var row = getSingleTreeGridSelectData($("#estalistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认重新启用该外部用户？",function(){					
			$.ajax({
				type : 'PUT',
				url : ctx + "esta/esta/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						estalistquery();
					} );
				},
				dataType : "JSON"
			});
		});
	}
}

function initExtenalPwd(){ 
	var row = getSingleTreeGridSelectData($("#estalistDg"));
	if(row !=null){
		promptMessageCallBack("3","是否确认初始化密码？",function(){					
			$.ajax({
				type : 'PUT',
				url : ctx + "esta/password/"+row.id,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						estalistquery();
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

