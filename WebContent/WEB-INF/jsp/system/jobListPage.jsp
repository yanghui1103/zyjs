<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">  
$(function(){
	renderAuthorityOperateBtnAll($("#panelBar",navTab.getCurrentPanel()),"getOperationsByMenuId","201",false,"panelBar"); 
});
</script>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<%=basePath %>system/jobList/all" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>关键词：</label>
				<input type="text"  value="${param.keyWords}"     name="keyWords" />
			</li> 
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div> 
	</div>
</div>
</form>
<div class="pageContent">
	<div class="panelBar" id="panelBar">
	</div>
	<table class="table" width="100%" layoutH="133">
		<thead>
			<tr>
				<th width="10">序号</th> 
				<th width="100">名称</th> 
				<th width="100">已执行次数</th> 
				<th width="100">频率</th> 
				<th width="100">说明</th> 
				<th width="50">状态</th> 
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${jobList}" varStatus="s">
			<tr target="item_id" rel="${item.fdid}">
				<td>${s.index+1}</td>
				<td>${item.job_name}</td>
				<td>${item.temp_int1}</td>  
				<td>${item.temp_int1}</td>  
				<td>${item.temp_int1}</td>  
				<td>${item.temp_int1}</td>  
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>