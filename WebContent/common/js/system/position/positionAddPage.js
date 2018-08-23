/**
 * 
 */

function addNewPosition(){	 
	if (!$("#positionAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "position/position",
		data : serializeFormToJSON($("#positionAddFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				 $('#positionLiDg').datagrid('reload');  
			} );
		},
		dataType : "JSON"
	});

	
}