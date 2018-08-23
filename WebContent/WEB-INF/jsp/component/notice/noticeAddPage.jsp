<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>plugins/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/common/common.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div>
    <textarea id="myEditor" style="width:100%;height:380px"></textarea>
</div>
 
<script type="text/javascript">
$(function(){  
    //富文本编辑器  
    UE.getEditor('myEditor')  
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;  
    UE.Editor.prototype.getActionUrl = function(action){  
        if(action == '/editor/upload/file'){  
            return ctx +'/editor/upload/file';  
        }else{  
            var ac =  this._bkGetActionUrl.call(this, action);  
            return ac ;
        }  
    }  
});  
</script>
</body>
</html>