/**
 * 
 */
$(function(){
		$(".address-select").textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					openAddress($("#_loadDialog_address"),$("input[name='temp_str1']"),$(".address-select"),'O',true);
				}
			}]
		})
	});

function editPosition(){
	if (!$("#positionEditFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'post',
		url : ctx + "position/position",
		data : serializeFormToJSON($("#positionEditFm")
				.serializeArray()),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				 $('#positionLiDg').datagrid('reload');  
			} );
		},
		dataType : "JSON"
	});
}