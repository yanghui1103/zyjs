<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>信息管理系统</title> 
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/common/common.js"></script>
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
	<link href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/platform.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/custom/lightblue/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript">
		function logout(){
			$.ajax({
				url:ctx+"system/logout",
				type:'post',
				success:function(){
					window.location.href=ctx+"system/login"
				}
			});
		}
		function accountInfo(){
			$('#_loadDialog_AccountInfo').dialog({    
			    title: '账户详情',    
			    width: 800,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    maximizable:true,
			    href: ctx+'user/openUserDetail/${sessionScope.CurrentUser.userId }' ,    
			    modal: true   
			}); 
		}
	</script>
</head> 
<body  scroll=yes>
    <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img src="<%=basePath%>common/fit/v4/static/lightblue/images/main/main_logo.png" alt="logo">
            </div> 
            <div class="pf-user">
                <div class="pf-user-photo">
                    <img src="<%=basePath%>common/fit/v4/static/lightblue/images/main/user.png" alt="">                   
                </div>
                <h4 class="pf-user-name ellipsis"></h4>
                <i class="iconfont xiala">&#xe607;</i>
                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:accountInfo();">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">[${sessionScope.CurrentUser.name }]账户</span>
                            </a>
                        </li>
<!--                          <li class="pf-modify-pwd"> -->
<!--                             <a href="http://www.uimaker.com"> -->
<!--                                 <i class="iconfont">&#xe6f8;</i> -->
<!--                                 <span class="pf-opt-name">消息<i class="mailtext">[10]</i></span> -->
<!--                             </a> -->
<!--                         </li> -->
                        <li class="pf-modify-pwd">
                            <a href="http://www.uimaker.com">
                                <i class="iconfont">&#xe634;</i>
                                <span class="pf-opt-name">安全</span>
                            </a>
                        </li>
                        <li class="pf-logout">
                            <a href="javascript:logout();">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="pf-bd">
            <div class="pf-sider-wrap">
              <!-- <div id="pf-sider">
                  <h2 class="pf-model-name">
                      <span class="iconfont">&#xe633;</span>
                      <span class="pf-name">组织管理</span>
                      <span class="toggle-icon"></span>
                  </h2>

                  <ul class="sider-nav">
                       <li class="current">
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">供应商组织</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">采购组织</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">专家库</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">注册供应商</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">RFI动态信息</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">资质过期</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                       </li>
                   </ul> 
              </div> -->
            </div>
            

            <div id="pf-page">
            </div>
        </div>

        <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>信息管理系统&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>CopyRight&nbsp;2016&nbsp;&nbsp;**.com&nbsp;版权所有</span>
              <i class="iconfont" >&#xe6ff;</i>
              <div id="_loadDialog_AccountInfo"></div>
            </div>
        </div>
    </div>

    <div id="mm" class="easyui-menu tabs-menu" style="width:120px;display:none;">
         <div id="mm-tabclose">关闭</div>
         <div id="mm-tabcloseall">关闭所有</div>
         <div id="mm-tabcloseother">关闭其他</div> 
    </div>
    
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/static/lightblue/js/menu.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/static/lightblue/js/main.js"></script>
    <!--[if IE 7]>
      <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
        
      </script>
    <![endif]-->  

    
    <script type="text/javascript">
    $(window).resize(function(){
          $('.tabs-panels').height($("#pf-page").height()-46);
          $('.panel-body').not('.messager-body').height($(".easyui-dialog").height)
    }).resize();

    var page = 0,
        pages = ($('.pf-nav').height() / 70) - 1;

    if(pages === 0){
      $('.pf-nav-prev,.pf-nav-next').hide();
    }
    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){


      if($(this).hasClass('disabled')) return;
      if($(this).hasClass('pf-nav-next')){
        page++;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == pages){
          $(this).addClass('disabled');
          $('.pf-nav-prev').removeClass('disabled');
        }else{
          $('.pf-nav-prev').removeClass('disabled');
        }
        
      }else{
        page--;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == 0){
          $(this).addClass('disabled');
          $('.pf-nav-next').removeClass('disabled');
        }else{
          $('.pf-nav-next').removeClass('disabled');
        }
        
      }
    })

    // setTimeout(function(){
    //    $('.tabs-panels').height($("#pf-page").height()-46);
    //    $('.panel-body').height($("#pf-page").height()-76)
    // }, 200)
    function replace(doc, style) {


      $('link', doc).each(function(index, one) {

        var path = $(one).attr('href').replace(/(static\/)\w+(\/css)/g, '$1' + style + '$2').replace(/(custom\/)\w+(\/)/g, '$1' + style + '$2'),
          sheet;

        if(doc.createStyleSheet) {

          sheet = doc.createStyleSheet(path);
          setTimeout(function() {

            $(one).remove();

          }, 500)

        } else {

          sheet = $('<link rel="stylesheet" type="text/css" href="' + path + '" />').appendTo($('head', doc));
          sheet = sheet[0];
          sheet.onload = function() {

            $(one).remove();

          }

        }

      })

      $('img', doc).each(function(index, one) {

        var path = $(one).attr('src').replace(/(static\/)\w+(\/images)/g, '$1' + style + '$2');

        $(one).attr('src', path);

      })

    }
    $('.skin-item').click(function() {

      var color = $(this).data('color');
      replaceAll(color);

    })
    function replaceAll(style) {

      $('iframe').each(function(index, one) {

        try {

          replace(one.contentWindow.document, style)

        } catch(e) {

          console.warn('origin cross');

        }

      })

      replace(document, style)

    }
    </script>
</body> 
</html>
