<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<body>
<div class="pageHeader">
	<div class="formBar">
		<form id="upFm" action="<%=basePath%>system/doUpload"
			method="post" enctype="multipart/form-data"
			onsubmit="return dwzSearch(this, 'dialog');">
			<input type="file" name="file" id="file"  />
			<button>submit</button>
		</form>
	</div>
	<div class="subBar">
		<ul>
			<li></li>
		</ul>
	</div>
</div> 
</body>
<%-- <c:import url="../_frag/pager/pagerForm.jsp"></c:import> --%>
<!-- <form method="post" rel="pagerForm" -->
<%-- 	action="<%=basePath%>system/attachmentList" --%>
<!-- 	onsubmit="return navTabSearch(this)"></form> -->
<!-- <div class="pageContent"> -->
<!-- 	<div class="panelBar" id="panelBar"></div> -->
<!-- 	<table class="table" width="100%" layoutH="133"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<!-- 				<th width="120">名称</th> -->
<!-- 				<th width="60">大小</th> -->
<!-- 				<th width="100">上传人</th> -->
<!-- 				<th width="100">上传时间</th> -->
<!-- 				<th width="50">操作</th> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<%-- 			<c:forEach var="item" items="${attList}" varStatus="s"> --%>
<%-- 				<tr target="id" rel="${item.fdid}"> --%>
<%-- 					<td>${item.company_name}</td> --%>
<%-- 					<td>${item.company_type_name}</td> --%>
<%-- 					<td>${item.parent_company_name}</td> --%>
<%-- 					<td>${item.company_address}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->

<%-- 	<c:import url="../_frag/pager/panelDialogBar.jsp"></c:import> --%>
<!-- </div> -->