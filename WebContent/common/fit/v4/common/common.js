/******
*  此脚本为前台通用脚本
*	1，含通用配置
*	2，通用的JS方法
*	3，其他
****/
var ctx = "http://localhost:8080/zyjs/";
//var ctx = "http://10.1.9.160:8099/zyjs/";
//var ctx = "http://ejy.bwtech.top:28081/zyjs/";
var prompt_title = "系统提示框";

/****
 * 功能用来菜单打开Tab
 * 
 * @param data
 */
function openNewTab(data){ 
	//判断选项卡是否重复打开  
        if ($('#mainFrame').tabs('exists', data.menu_name)) {  
            $('#mainFrame').tabs('select', data.menu_name);//选中并刷新  
        } else {
		// add a new tab panel
		$('#mainFrame').tabs('add', {
			title : data.menu_name,
			href: ctx+ data.menu_path +"/"+data.menu_url+"/"+data.params,
			closable : true 
		});
        }
  } 

/*****
 * 这个功能用来新打开一个内部网页
 * @param title 标题抬头
 * @param url   内部网址URL
 */
function addNewTab(title, url) {  
    //判断选项卡是否重复打开  
     if ($('#mainFrame').tabs('exists', title)) {  
         $('#mainFrame').tabs('select', title);//选中并刷新  
     } else {  
         var content = createFrame(url); //创建Frame  
         $("#mainFrame").tabs("add", {  
             title: title,  
             content: content,  
             closable: true  
         })  
     }        
 }  

/*****
 * 这个功能用来新打开一个外部网页
 * @param title 标题抬头
 * @param url   外部网址URL
 */
function addExternalTab(title, url) {  
    //判断选项卡是否重复打开  
     if ($('#mainFrame').tabs('exists', title)) {  
         $('#mainFrame').tabs('select', title);//选中并刷新  
     } else {  
         var content = createFrame(url); //创建Frame  
         $("#mainFrame").tabs("add", {  
             title: title,  
             content: content,  
             closable: true  
         })  
     }        
 }  
 //创建Frame  
 function createFrame(url) {  
     var tabHeight = $("#mainFrame").height() ;  
     var s = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';  
     return s;  
 }  
 

 function myformatterMonth(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate(); 
			return y+'-'+(m<10?('0'+m):m);
	} 
 function myformatterAll(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate(); 
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	function myparser(s){
		if (!s) return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	}
	
	/*****
	 * 把form的serializeArray
	 * 传入，形成新的JSON对象，后台对象来接收
	 * @param data
	 * @returns
	 */
	function serializeFormToJSON(data){  
		    var obj = {};
		    $.each(data,function(i,v){
		        obj[v.name] = v.value;
		    }) 
		    return  JSON.parse(JSON.stringify(obj));
	}
	
	/*****
	 * 列表选择记录
	 * 返回行对象
	 * @param obj 指grid对象
	 * 只容许选择单条记录
	 */
	function getSingleGridSelectData(obj){
		var row = obj.datagrid('getSelected');  
		if (row){
			return row ;
		}else{
			promptMessage("1","请选择记录!"); 
			return null ;
		}
	}
	/*****
	 * 列表选择记录
	 * 返回行对象
	 * @param obj 指grid对象
	 * 容许选择多条记录
	 */
	function getMultipleGridSelectData(obj){
		var selRow = obj.datagrid('getSelections');  
		if(selRow.length>0){
			return selRow ;
		}else{
			promptMessage("1","请选择记录!"); 
			return null ;
		}
	}
	
	

	/*****
	 * 列表选择记录
	 * 返回行对象
	 * @param obj 指Treegrid对象
	 * 只容许选择单条记录
	 */
	function getSingleTreeGridSelectData(obj){
		var row = obj.treegrid('getSelected');  
		if (row){
			return row ;
		}else{
			promptMessage("1","请选择记录!"); 
			return null ;
		}
	}
	/*****
	 * 列表选择记录
	 * 返回行对象
	 * @param obj 指Treegrid对象
	 * 容许选择多条记录
	 */
	function getMultipleTreeGridSelectData(obj){
		var selRow = obj.treegrid('getSelections');  
		if(selRow.length>0){
			return selRow ;
		}else{
			promptMessage("1","请选择记录!"); 
			return null ;
		}
	}
	
	/*****
	 * 根据后台返回的数据
	 * 进行提示
	 * @param res 1错误，2成功，3提问，其他警告
	 * @param msg
	 */
	function promptMessage(res,msg){
		if(res == "1"){
			$.messager.alert(prompt_title,msg,"error");
		}else if(res == "2"){
			$.messager.alert(prompt_title,msg,"info");
		}else if(res == "3"){
			$.messager.alert(prompt_title,msg,"question");
		}else{
			$.messager.alert(prompt_title,msg,"warning");
		}
	}
	
	/*****
	 * 其他同上，fn是回调函数
	 * @param res
	 * @param msg
	 * @param fn
	 */
	function promptMessageCallBack(res,msg,fn){
		if(res == "1"){
			$.messager.alert(prompt_title,msg,"error",fn);
		}else if(res == "2"){
			$.messager.alert(prompt_title,msg,"info",fn);
		}else if(res == "3"){
			$.messager.alert(prompt_title,msg,"question",fn);
		}else{
			$.messager.alert(prompt_title,msg,"warning",fn);
		}
	}
	
	/*****
	 * 表单提交后返回数据，
	 * 需要根据res值，刷新dgid页的datagrid重新加载
	 * 并让当前tab做action动作
	 * @param data
	 * @param res
	 * @param dgId datagrid对象
	 * @param action
	 */
	function completeSubmitCall(data,res,dgId,action){
		if(data.res == res ){
			 var tab =  getCurrentTab();
			 var mainTab = getMainFrameTab();
			 var index = mainTab.tabs('getTabIndex',tab);  
			 mainTab.find("#"+dgId+"").datagrid('loadData',{total:0,rows:[]}); 
			 mainTab.find("#"+dgId+"").datagrid('reload'); 
			 mainTab.tabs(action,index );  
	  }
	}
	

	/*****
	 * 表单提交后返回数据，
	 * 需要根据res值，刷新dgid页的datagrid重新加载
	 * 并让当前tab做action动作
	 * @param data
	 * @param res
	 * @param dgId treegrid对象
	 * @param action
	 */
	function completeSubmitCallTreeGd(data,res,dgId,action){
		if(data.res == res ){
			 var tab =  getCurrentTab();
			 var mainTab = getMainFrameTab();
			 var index = mainTab.tabs('getTabIndex',tab);  
			 mainTab.find("#"+dgId+"").treegrid('loadData',{total:0,rows:[]}); 
			 mainTab.find("#"+dgId+"").treegrid('reload'); 
			 mainTab.tabs(action,index );  
	  }
	}
	
	
	/******
	 *  根据操作前缀编码抽取该用户拥有的操作权限按钮
	 * @param obj 放置按钮div
	 * @param action 
	 * @param code 
	 * @param ansy 是否同步
	 * @param barCss  toolBar:页面上方的工具栏,formBar:页面右下角工具栏
	 */
	function renderAuthorityOperateBtnAll(obj, action, code, ansy, barCss) {
		$.post(action+"/"+code,function(data){
			var htmlString = ""; 
			if (data.res != '2') {
			} else {
				if (barCss.indexOf("toolBar")>-1) {
					var list = data.list;
					htmlString = "";
					for (var i = 0; i < list.length; i++) {
						if("jsTodo"==list[i].operate_type){
							htmlString = htmlString + "<a class='easyui-linkbutton' iconCls="
									+ list[i].operate_target
									+ "  href='"+list[i].address+"' id="+list[i].foreign_id+list[i].operate_code+"  >"+list[i].operate_name+"</a>";
						}else{
							htmlString = htmlString + "<a class='easyui-linkbutton' iconCls="
							+ list[i].operate_target
							+ "   href='javascript:addNewTab(\""+list[i].operate_name+"\",\""+ctx+list[i].address+"\")'   ><span> "+list[i].operate_name+"</span></a>";				
						}
					}
					obj.append(htmlString);
					$.parser.parse(obj);
				} else if (barCss.indexOf("formBar")>-1) {
					var list = data.list;
					htmlString = "<div style='position:fixed;right:30px;bottom:20px;' >";
					for (var i = 0; i < list.length; i++) {
						htmlString = htmlString
								+ " <a href=# class=easyui-linkbutton id='"+list[i].foreign_id+list[i].operate_code+"' style='width: 80px'>"+list[i].operate_name+"</a>";
					}
					htmlString = htmlString + "</div>";
					obj.append(htmlString);
					$.parser.parse(obj);
				}
			} 
		}); 
	}
	
	
	
	/****
	 * 返回系统用户当前已经打开Tab
	 * @returns
	 */
	function getCurrentTab(){ 
		return self.parent.$('#mainFrame').tabs('getSelected'); //获得当前tab
	}
	
	/*****
	 * 获取本系统框架页的对象
	 * @returns
	 */
	function getMainFrameTab(){
		return self.parent.$('#mainFrame');	
	}
	
	/*****
	 * 前端数据字典转义
	 * @param value
	 */
	function getDictNameByValue(value){
		var val = "";
		$.ajax({
			type : 'GET',
			url : ctx + "dict/getDictNameByValue/"+value,
			data : {},
			async:false,
			success : function(data) { 
				val =  data.dictName;
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				ajaxError(XMLHttpRequest, textStatus, errorThrown);
				return "";
			},
			dataType : "JSON"
		});
		return val ;
	}
	
	/***
	 * 专门处理ajax请求错误
	 * @param XMLHttpRequest
	 * @param textStatus
	 * @param errorThrown
	 */
	function ajaxError(XMLHttpRequest, textStatus, errorThrown){
		$.messager.alert({
            title: prompt_title,
            ok: '确定',
            icon: 'error',
            cancel: '取消',
            msg: errorThrown
          });
	}