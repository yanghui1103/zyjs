<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/common/common.js"></script>
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
	<link href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/platform.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>	
</head>
<body>
	
    <div class="container">
       <table id="orgListDg" style="width:100%;height:554px" title="全体组织列表" data-options="
                rownumbers:true,
                singleSelect:false,
                autoRowHeight:false,
                pagination:true,
                fitColumns:true,
                striped:true,
                checkOnSelect:true,
                selectOnCheck:true,
                collapsible:true,
                toolbar:'#tb',
                pageSize:10">           
        </table>
      <div id="tb" style="padding:0 30px;">
        供应商编码: <input class="easyui-textbox" type="text" name="code" style="width:166px;height:35px;line-height:35px;"></input>
        供应商名称: <input class="easyui-textbox" type="text" name="name" style="width:166px;height:35px;line-height:35px;"></input>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
      </div>
    </div>



    <script type="text/javascript">
    function cmpquery(){    
    	$('#orgListDg').datagrid({ 
    		pagination:true,
    	    url:ctx+'org/organizations' , 
    	    method:"GET",
            queryParams:   serializeFormToJSON($("#companylistFM").serializeArray()),
    	    toolbar:$("div[name='companylisttb']"),
    	    remoteSort: false, 
            columns: [[
                       { field: 'fdid', title: 'ID' ,hidden:true  },
                       { field: 'name', title: '组织名称', width: '25%',fixed:true  },
                       { field: 'company_type_name', title: '类型', width: '25%' }, 
                       { field: 'parent_company_name', title: '父组织', width: '25%' }, 
                       { field: 'company_address', title: '地址', width: '25%' }
                   ]],
                 fit: true,    
                 idField: "fdid",
                 pagination: true,
                 singleSelect:true,
                 rownumbers: true, 
                 fitColumns:true,
                 pageNumber: 1,
                 pageSize: 20,
                 pageList: [ 20, 30, 40, 50],
                 striped: true //奇偶行是否区分                    
    	});  
    }
        $(function(){
        	cmpquery();
        });
    </script>
</body>
</html>