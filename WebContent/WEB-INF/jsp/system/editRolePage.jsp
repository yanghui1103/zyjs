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
<link href="<%=basePath%>common/zTree/css/zTreeStyle/zTreeStyle.css"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript"
	src="<%=basePath%>common/zTree/js/jquery.ztree.core-3.0.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/zTree/js/jquery.ztree.excheck-3.0.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/zTree/js/jquery.ztree.exedit-3.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/system/editRole.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
.div {
	border: 3px solid #000;
	padding: 4px
}
</style>
<style type="text/css">
ul.rightTools {
	float: right;
	display: block;
}

ul.rightTools li {
	float: left;
	display: block;
	margin-left: 5px
}
</style>
</HEAD>

<BODY>
	<input type="hidden" value=${menuTreeJson }  id="ztreeJson"/>
	<form id="postionFm" method=post
		action="<%=basePath%>system/updateRole?navTabId=page103&callbackType=closeCurrent"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent">
			<input type="hidden" name="fdid" value=${role_id } id="fdid" />
			<input type="hidden" name="temp_str4"  id="temp_str4" />
			<p>
				<label>角色名称：</label> <input name="role_name" value='${role_name }'
					class="required readonly" readonly minlength="2" type="text"
					size="30" maxlength=20 />
			</p>
			<p>
				<label>父角色：</label><input class="required readonly" readonly
					value='${parent_role_name }' type="text" size="30" />
			</p>
		</div>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>父角色菜单</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<div layoutH="59"
						style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">

						<ul id="treeDemo" class="ztree"></ul>
						<div style="display: none">
							<a id="gotoHref" target="ajax" rel="jbsxBox"></a>
						</div>
					</div>


					<div id="jbsxBox" class="unitBox" style="margin-left: 246px;">

						<div class="panel" defH="20">
							<h1>菜单列表</h1>
							<div id="menuListR"></div>
						</div>

						<div class="panel" defH="60">
							<h1>按钮功能列表</h1>
							<div id="operationListR"></div>
						</div>

						<div class="panel" defH="60">
							<h1>页面元素列表</h1>
							<div id="elementListR"></div>
						</div>

						<div class="panel" defH="60">
							<h1>附件列表</h1>
							<div id="attListR"></div>
						</div>
<!-- 						<div class="buttonActive" style="float: right"> -->
<!-- 							<div class="buttonContent"> -->
<!-- 								<button>保存</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>

				</div>

			</div>
		</div>
	</form>

</BODY>
</HTML>