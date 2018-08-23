/**
 * 
 */

function addNewUser(){ 
	if (!$("#userAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "user/user",
		data : serializeFormToJSON($("#userAddFm")
				.serializeArray()),
		success : function(data) {
			promptMessage(data.res, data.msg );
		},
		dataType : "JSON"
	});
}
