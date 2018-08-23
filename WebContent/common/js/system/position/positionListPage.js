/**
 * 
 */

$(function(){
	positionlistquery();
	

});


function positionlistquery(){
	var orgId = $("#org_id").val();
	$('#positionLiDg').datagrid({ 
		pagination:true,
		method:"get",
	    url:ctx+'position/positions/'+orgId,   
      //  queryParams:   serializeFormToJSON($("#userlistFM").serializeArray()),
	    remoteSort: false, 
        columns: [[
                   { field: 'id', title: 'ID' ,hidden:true  },
                   { field: 'code', title: '编码', width: '20%',fixed:true  },
                   { field: 'name', title: '名称', width: '30%' },
                   { field: 'simpleName', title: '简称', width: '20%' }, 
                   { field: 'temp_str1', title: '所属组织', width: '30%'  }
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
function positionReloadgrid() { 
	$('#positionLiDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
	positionlistquery();
}  

function addPositionPage(){
	var ids = $("#org_ids").val();
	if(ids =='-1'){			
		promptMessage("1","请选择组织机构");
	}else{
		$('#_loadDialog_positionList').dialog({    
		    title: '新增岗位',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'position/openPositionAddPage/'+ids,    
		    modal: true   
		});
	}
}

function deletePosition(){	 
	var row = getSingleGridSelectData($("#positionLiDg"));
	if(row !=null){
		var orgId = $("#org_id").val();
		//增加判断人员和岗位关系表是否有记录，如果有，不能删除该岗位
		promptMessageCallBack("3","是否确认删除该记录",function(){					
			$.ajax({
				type : 'DELETE',
				url : ctx + "position/position/"+row.id+"/"+orgId,
				data : {},
				success : function(data) {
					promptMessageCallBack(data.res, data.msg,function(){
						 $('#positionLiDg').datagrid('reload');  
					} );
				},
				dataType : "JSON"
			});
		});
	}
}

function openEditPosition(){
	var row = getSingleGridSelectData($("#positionLiDg"));
	if(row !=null){				
		$('#_loadDialog_positionList').dialog({    
		    title: '编辑岗位',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'position/openPositionEditPage/'+row.id,    
		    modal: true   
		});
	}
}


 