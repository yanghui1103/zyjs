<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<style type="text/css">
	@media screen and (max-width: 1000px) {
		.fit_form_row {
			float:left;
			margin-bottom: 20px;
			width: 45%;
			margin-right:2%;
		}
		.fit_form_row input {
			width: 250px;
		}
	}
	@media screen and (min-width: 1000px) {
		.fit_form_row {
			float:left;
			margin-bottom: 20px;
			width: 24%;
			margin-right:1%;
		}
		.fit_form_row input {
			width: 250px;
		}
		.fit_form_row select {
			width: 250px;
		}
		
	}
</style>
<script  type="text/javascript">
$(function(){
	var $box_w = $(".fit_form_row").width();
	$("input").width($box_w - 85); 
	$("select").width($box_w - 85); 
})
</script>	
</head> 
</html>