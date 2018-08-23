var menus = '';
var SystemMenu ='';
$(function(){
	$.ajax({url: ctx +"account/menus",
			type:'get',
			async:false,
			success:function(data){
				menus = data ;
			}
	});
});
 SystemMenu = [{
	title: '系统管理',
	icon: '&#xe63f;',
	isCurrent: true,
	menu:  menus 
}];