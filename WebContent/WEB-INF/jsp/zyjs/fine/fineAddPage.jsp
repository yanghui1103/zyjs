<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="float: right;margin-right:30px;margin-top:5px" >
		<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			onclick="addNewFine();"  style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="fineAddFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>名称</div>
			<input class="easyui-textbox" name="title" data-options="required:true,validType:['length[0,200]']"  style="width: 80%;paddding-right:2px"   >
		</div> 
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>链接地址</div>
			<input class="easyui-textbox" name="path" data-options="validType:['length[0,4000]']"  style="width: 80%;paddding-right:2px"   >
		</div>
	</form>
	<script type="text/javascript">
	function myformatter(date){
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
    
    function addNewFine(){
		promptMessageCallBack("3", "是否确认新增优选记录？", function() {
			$.ajax({
				type : 'POST',
				url : ctx + "fine/fine",
				data : ($("#fineAddFm").serialize()),
				success : function(data) {
					promptMessage(data.res, data.msg);
				},
				dataType : "JSON"
			});
		});		
    }
	</script>
</body>
</html>