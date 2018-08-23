<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.bw.fit.common.util.*"
	isELIgnored="false" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%><jsp:include page="/common.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="easyui-panel" 
		style="width: 100%;height:100%; max-width: 100%; padding: 20px 20px;">
		<div style="margin-bottom: 20px">
			<input class="easyui-filebox" data-options="accept:'${fileType }',multiple:false,buttonText: '选择文件'"
				style="width: 50%">
				<input type="hidden" value="${foreignId }" id="upLoadAttachmentFid"/>
				<input type="hidden" value="${auth }" id="upLoadAttachmentAuth"/>
				<input type="hidden" value="${user_id }" id="att_current_user_id"/>
		<c:if test="${auth =='2' }">
			<button class="easyui-linkbutton" type=button onclick="upLoadAttachmentFile()"
				style="width: 80px">上传</button> 
		</c:if>
		</div>		
	<table id="sysAttachmentListDg"></table>
	</div>
	<script type="text/javascript">
	function upLoadAttachmentFile() {  
		var fileObj =  document.querySelector('input[type=file]').files[0];
		var FileController =  ctx + 'systemPlus/upLoadAttachmentFile';
		// FormData 对象  
		var form = new FormData(); 
		form.append("foreignId", $("#upLoadAttachmentFid").val()); // 文件对象
		form.append("file", fileObj); // 文件对象
		// XMLHttpRequest 对象
		var xhr = new XMLHttpRequest();
		xhr.open("post", FileController, true); 
		xhr.send(form);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				promptMessage(data.res, data.msg);
			}
		}
	}

	$(function(){
		upAttachQuery();
	});

	function upAttachQuery(){    
		var upLoadAttachmentAuth = $("#upLoadAttachmentAuth").val();
		var att_current_user_id = $("#att_current_user_id").val() ;
		$('#sysAttachmentListDg').datagrid({ 
			pagination:true,
		    url:ctx+'systemPlus/attachmentList/-9' ,   
	        queryParams:  null , 
		    remoteSort: false, 
	        columns: [[
	                   { field: 'fdid', title: 'ID' ,hidden:true  },
	                   { field: 'before_name', title: '文件名称', width: '20%',fixed:true  },
	                   { field: 'file_size', title: '文件大小', width: '15%' }, 
	                   { field: 'creator', title: '上传者', width: '15%' }, 
	                   { field: 'create_time', title: '上传时间', width: '15%' },
	                   {field:'operate',title:'操作',align:'center',width:$(this).width()*0.1,  
	                	       formatter:function(value, row, index){  	                	    	   	
	                		           var str ="";
	                		           if(parseInt(upLoadAttachmentAuth)>0){
		                		           str = str + '<a href=<%=basePath%>systemPlus/download/'+row.fdid+'   name="downFile" class="easyui-linkbutton" ></a>';
		                		           str = str + '<a href="#" onclick="viewFile("'+row.fdid+'")" name="viewFile" class="easyui-linkbutton" ></a>';
	                		           }
	                		           if(parseInt(upLoadAttachmentAuth)>1 && att_current_user_id == row.creator){
	                		           		str = str + '<a href="#" onclick="deleteFile(\''+row.fdid+'\')" name="deleteFile" class="easyui-linkbutton" ></a>';
	                		           }
	                		           return str;  
	                		   }}  

	               ]],
	             fit: true,    
	             idField: "fdid",
	             pagination: false,
	             singleSelect:true,
	             rownumbers: true, 
	             fitColumns:true,
	             pageNumber: 1,
	             pageSize: 20,
	             pageList: [ 20, 30, 40, 50],
	             striped: true ,//奇偶行是否区分                    
	             onLoadSuccess:function(data){     
	            	         $("a[name='downFile']").linkbutton({text:'下载',plain:true,iconCls:'icon-add'});   
	            	         $("a[name='viewFile']").linkbutton({text:'预览',plain:true,iconCls:'icon-search'});   
	            	         $("a[name='deleteFile']").linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});    
	             }

		});  
	}
	
	function deleteFile(fdid){ 
		promptMessageCallBack("3","是否确认删除该附件?",function(){
			$.post(ctx+"systemPlus/deleteAttachment/"+fdid,function(data){
				promptMessage(data.res,data.msg);
				$('#sysAttachmentListDg').datagrid('loadData',{total:0,rows:[]}); //清空DataGrid行数据
				upAttachQuery(); 
			});
		});	

	}
	</script>
</body>
</html>