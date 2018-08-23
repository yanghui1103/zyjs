/**
 * 
 */

function updateDict(){
	if (!$("#dicteditFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'post',
		url : ctx + "dict/dict",
		data : serializeFormToJSON($("#dicteditFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				 $('#dataDictTreeGd').treegrid('reload');  
			} );
		},
		dataType : "JSON"
	});
}



