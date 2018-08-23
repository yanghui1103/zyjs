/**
 * 
 */


$(function(){
		$(".address-select-position").textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					openAddress($("#_loadDialog_address"),$("input[name='positionIds']"),$(".address-select-position"),"P",true);
				}
			}]
		})
		

		$(".address-select-org").textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					openAddress($("#_loadDialog_address"),$("input[name='currentOrgId']"),$(".address-select-org"),"O",false);
				}
			}]
		})
	
		
	});

function addAccount(){ 
	if (!$("#accountAddFm").form('enableValidation')
			.form('validate')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : ctx + "account/account",
		data :  $("#accountAddFm").serialize(),
		success : function(data) {
			promptMessageCallBack(data.res, data.msg,function(){
				accountReloadgrid();
			} );
		},
		dataType : "JSON"
	});
}


