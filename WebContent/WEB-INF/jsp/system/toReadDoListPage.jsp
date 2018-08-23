<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/" ;
%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm"
	action="<%=basePath %>system/getWaitTodoList/-9/my/-9/-9"
	onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<p> <label>关键词：</label><input type="text" value="${keyWords}"
					name="keyWords" />
			 
			<p>
				<label><input type="radio" name="readOrDo" value="to_do"
					<c:if test="${readOrDo=='to_do' }">checked</c:if> />待办</label> <label><input
					type="radio" name="readOrDo" value="to_read"
					<c:if test="${readOrDo=='to_read' }">checked</c:if> />待阅</label>
			</p>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">查询</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</form>
<div class="pageContent">
	<div class="panelBar" id="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="demo_page4.html" target="navTab"><span>发起沟通</span></a></li> 
		</ul>
	</div>
	<table class="table" width="100%" layoutH="133">
		<thead>
			<tr>
				<th width="10">序号</th>
				<th width="150">标题</th>
				<th width="50">来自系统</th>
				<th width="50">时间</th>
				<th width="50">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${to_list}" varStatus="s">
				<tr target="item_id" rel="${item.fdid}">
					<td>${s.index+1}</td>
					<td>${item.subject}</td>
					<td>${item.app_name}</td>
					<td>${item.create_time2}</td>
					<td><a title="办理" target="navTab" href="demo_page4.html?id=xxx" class="btnEdit">办理</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>