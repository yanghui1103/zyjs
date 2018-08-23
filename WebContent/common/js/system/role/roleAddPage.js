/**
 * 
 */
function addNewRole(){ 
	if (!$("#roleAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "role/role",
		data : serializeFormToJSON($("#roleAddFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(data){
					roleReloadgrid();
			} );
		},
		dataType : "JSON"
	});
}
