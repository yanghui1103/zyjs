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
<link rel="stylesheet"
	href="<%=basePath%>common/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>common/zTree/js/jquery.ztree.core-3.0.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/fit/orgStructure.js"></script>
<style type="text/css">
.container {
	min-height: 380px;
	min-width: 50%;
	overflow: hidden;
}

.left_c {
	box-sizing: border-box;
	width: 30%;
	float: left;
	height: 502px;
	overflow: scroll;
	white-space: nowrap;
}

.right_c {
	box-sizing: border-box;
	width: 70%;
	float: left;
	border: 1px solid #ddd;
	background-color: #fff;
	font-size: 14px
}

.search {
	margin: 10px;
	overflow: hidden;
}

.search h2 {
	float: left;
	width: 10%;
	line-height: 28px;
}

.search_center {
	float: left;
	width: 70%;
}

.search_center .search_input {
	display: block;
	width: 90%;
	height: 26px;
	line-height: 26px;
	padding: 0 10px;
}

.search_center label {
	display: inline-block;
	margin: 5px 10px 0 0;
	line-height: 26px;
}

.search_center label input {
	float: left;
	margin: 6px 5px 0 0;
}

.search_btn {
	float: left;
	width: 20%;
	height: 28px;
	line-height: 28px;
}

.main {
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	overflow: hidden;
	height: 420px;
}

.left {
	box-sizing: border-box;
	float: left;
	width: 40%;
	overflow: scroll;
	height: 280px;
}

.left h2 {
	font-size: 14px;
	line-height: 26px;
	font-weight: bold;
	border-bottom: 1px solid #ddd;
	background-color: #f5f5f5;
	padding-left: 10px;
}

.left li {
	position: relative;
	line-height: 22px;
	padding: 0 10px;
	white-space: nowrap;
}

.left li.active, .left li.active:hover {
	background-color: #7cc5e5;
	border-color: #b8d0d6;
}

.left li:hover {
	background-color: #f5f5f5;
	border-color: #ddd;
}

.middle {
	float: left;
	box-sizing: border-box;
	width: 20%;
	text-align: center;
	border-left: 1px solid #ddd;
	border-right: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	min-height: 280px;
}

.middle button {
	width: 70%;
	margin: 20px auto 0;
}

.btn {
	float: left;
	height: 30px;
	width: 100%;
	text-align: center;
	margin: 10px 0 0;
}

.ms {
	box-sizing: border-box;
	float: left;
	width: 90%;
	border: 1px solid #ddd;
	padding: 10px;
	margin: 10px 5%;
	line-height: 24px;
}

.container ul.data-list {
	width: 100%;
	height: 100%;
	border: 1px solid #e5e5e5;
	float: left;
}

.container ul.data-list li {
	line-height: 32px;
	padding: 0px 10px;
}

.container ul.data-list li:hover {
	background-color: #C5EFFF;
	color: #252525;
	cursor: pointer;
	font-weight: bold;
}

.container ul.data-list li.selected {
	background-color: #0095E8;
	color: #fff;
}
</style>

</HEAD>

<BODY>
	<div class="container">
		<div class="left_c">
			<ul id="orgStrutsTree" class="ztree"></ul>
		</div>
		<div class="right_c">
			<form method=post action="<%=basePath%>system/searchObjByKeyWds"
				onsubmit="return dwzSearch(this, 'dialog');">
				<div style="display: none">
					<input id="orgTreeJSON" value=${orgTreeJSON } name=temp_str3
						type="hidden" /> <input id="selectMulti" name="menu_name"
						value='${selectMulti}' type="hidden" /> <input name="dict_name"
						value=${comps_str } type="hidden" /><input name=desp
						value=${objTypeString } type="hidden" /><input id="uuid"
						value="${uuid}" name="UUID" type="hidden" /> <input
						class="elementId" data-fdid="${elementId}" value="${elementId}"
						name="elementId" type="text" />
				</div>
				<div class="search">
					<h2>关键字</h2>
					<div class="search_center">
						<input class="search_input" type="text" name="keyWords"
							id="keyWords" value="${param.keyWords }" placeholder="输入关键字">
						<c:forEach var="item" items="${objType}" varStatus="s">
							<label><input type="checkbox" value="${item.temp_str2}"
								${item.temp_str4} name="temp_str1">${item.temp_str3}</label>
						</c:forEach>
					</div>
					<button class="search_btn">搜索</button>
				</div>
				<input type="hidden" value="${comps_str}" name="temp_str2"
					id="temp_str2" />
			</form>
			<div class="main">
				<div id=left_d class="left">
					<h2>待选列表</h2>
					<ul class="data-list" id="lList">
						<c:forEach var="item" items="${waitList}" varStatus="s">
							<label><li value="${item.fdid}" data-id="${item.fdid}"
								data-name="${item.keyWords}" remark="${item.desp}">${item.keyWords}</li></label>
						</c:forEach>
					</ul>
				</div>
				<div class="middle button-box">
					<button type="button" name="button" id="add">添 加</button>
					<button type="button" name="button" id="remove">删 除</button>
				</div>
				<div class="left right"  class="">
					<h2>已选列表</h2>
					<ul class="data-list" id="rList" >

					</ul>
					<!-- 					<ul id=right_ul> -->
					<%-- 						<c:forEach var="item" items="${selectedList}" varStatus="s"> --%>
					<%-- 							<label><li value="${item.fdid}" --%>
					<%-- 								data-name="${item.keyWords}" remark="${item.desp}">${item.keyWords}</li></label> --%>
					<%-- 						</c:forEach> --%>
					<!-- 					</ul> -->
				</div>

				<div class="btn">
					<button type=button onclick="returnSelected()">确认</button>
					<button type=button onclick="closeP()">关闭</button>
				</div>
				<div id="userMiaoshu" class="ms">无描述</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			var lList = $("#lList", $.pdialog.getCurrent());
			var llList = document.getElementById("lList");
			var rList = $("#rList", $.pdialog.getCurrent());
			var items = $(".data-list li", $.pdialog.getCurrent());
			for (var i = 0; i < items.length; i++) {
				items[i].onclick = itemsclick;
				// items[i].ondblclick = itemsdblclick;
			}
			function itemsdblclick() {
				if (this.parentNode === llList) {
					rList.append(this);
				} else {
					lList.append(this);
				}
			}
			function itemsclick() {
				$("li",$.pdialog.getCurrent()).removeClass("selected");
				var classname = this.className;
				if (classname === "selected") {
					this.className = "";
				} else {
					this.className = "selected";
				}
			}
			function itemsMove() {
				var items = $(".data-list li.selected", $.pdialog.getCurrent());
				// start
				var selectMulti = $("#selectMulti", $.pdialog.getCurrent()).val(); 
				if("false" == selectMulti && items.length !=1){
					alertMsg.info("只能选择一条记录");
					return ;
				}
				// end
				
				for (var i = 0; i < items.length; i++) {
					if (this.id === "add") {
						rList.append(items[i]);
					} else {
						lList.append(items[i]);
					}
				}
				$(".right_c", $.pdialog.getCurrent()).initUI();
			}
			
			function isZeroRight(){
				// 右侧是否零个
				var len = $("#rList li", $.pdialog.getCurrent()).length; 
				return len ;
			}
			
			$("#add", $.pdialog.getCurrent()).on("click", itemsMove);
			$("#remove", $.pdialog.getCurrent()).on("click", itemsMove);
		});
	</script>
</html>
</body>
</html>