<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
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
<style type="text/css" media="screen">
.my-uploadify-button {
	background: none;
	border: none;
	text-shadow: none;
	border-radius: 0;
}

.uploadify:hover .my-uploadify-button {
	background: none;
	border: none;
}

.fileQueue {
	width: 400px;
	height: 150px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>
	<script type="text/javascript"> 
		var foreign_id = '023333';
		$(function(){
			$("#uploadify").attr("uploaderOption",getUploaderOption(foreign_id,false,"system/attachment_upload_multi/","*.jpg;*.jpeg;*.gif;*.png;"));
		});  
	</script>
</head>
<body>
	<div class="pageContent" style="margin: 0 10px" layoutH="50">
		<form id="form1" enctype="multipart/form-data">
			<input id="uploadify" type="file" name="files" /> 
		</form>
	</div>
</body>
</html>