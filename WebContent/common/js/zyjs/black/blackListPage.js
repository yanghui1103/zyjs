/**
 * 
 */

$(function() {
	blacklistquery();
});

function blacklistquery() {
	$('#blacklistDg').datagrid({
		pagination : true,
		method : "get",
		url : ctx + 'black/blacks/' + $("#blacklistFMarea").val(),
		queryParams : serializeFormToJSON($("#blacklistFM").serializeArray()),
		remoteSort : false,
		columns : [ [ {
			field : 'id',
			hidden : true
		},{
			field : 'temp_str3',
			hidden : true
		}, {
			field : 'temp_str1',
			title : '主体名称',
			width : '30%',
			fixed : true
		}, {
			field : 'oType',
			title : '类型',
			width : '20%'
		}, {
			field : 'temp_str2',
			title : '账号',
			width : '20%'
		}, {
			field : 'createTime',
			title : '操作时间',
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
       	 openExUserDetail(row.temp_str3,row.oType); 
        }     
	});
}


function openExUserDetail(id,type){
	if(type == '企业'){
		$('#_loadDialog_blacklist').dialog({    
		    title: '企业用户详情',    
		    width: '99%',    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    maximizable:true,
		    href: ctx+'esta/gotoDetail/'+id,    
		    modal: true   
		}); 	
	}else{
		$('#_loadDialog_blacklist').dialog({    
		    title: '个人用户详情',    
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
// 增加查询参数，在页面加载时运行
function blackReloadgrid() {
	$('#blacklistDg').datagrid('loadData', {
		total : 0,
		rows : []
	}); // 清空DataGrid行数据
	$('#blacklistDg').datagrid('options').queryParams = serializeFormToJSON($(
			"#blacklistFM").serializeArray());
	$("#blacklistDg").datagrid('reload');
}

function openAuditblack() {
	var row = getSingleTreeGridSelectData($("#blacklistDg"));
	if (row != null) {
		var id = row.id;
		$('#_loadDialog_blacklist').dialog({
			title : '招聘方详情',
			width : '99%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'black/audit/' + id,
			modal : true
		});
	}
}

function openBlackDetail(){
		$('#_loadDialog_blacklist').dialog({
			title : '黑名单详情',
			width : '99%',
			height : 500,
			closed : false,
			cache : false,
			maximizable : true,
			href : ctx + 'black/black/33'  ,
			modal : true
		});
}
