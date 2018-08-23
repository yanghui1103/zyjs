<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="margin:30px 0px;"></div>
	
	<div class="container">
		<div class="content">
			<div  class="column"><span class="current">注册信息</span></div>
		      	<table class="kv-table">
					<tbody>
						<tr>
							<td class="kv-label">姓名</td>
							<td class="kv-content"><span >${user.name }</span></td>
							<td class="kv-label">姓名拼音</td>
							<td class="kv-content"><span id="code">${user.name_pinyin }</span></td>
							<td class="kv-label">用户编码</td>
							<td class="kv-content"><span id="simpleName">${user.code }</span></td>
						</tr>
						<tr>
							<td class="kv-label">性别</td>
							<td class="kv-content"><span id="type">${user.gender }</span></td>
							<td class="kv-label">身份证号码</td>
							<td class="kv-content"><span id="isVisible">${user.card }</span></td>
							<td class="kv-label">人员类型</td>
							<td class="kv-content"><span id="adminer">${user.type }</span></td>
						</tr>
						
					</tbody>
				</table>
		      	
				<div class="column"><span class="current">联系信息</span></div>
		      	<table class="kv-table">
					<tbody>
						
						<tr>
							<td class="kv-label">地址薄可见</td>
							<td class="kv-content"><span id="type">${user.isVisible }</span></td>
							<td class="kv-label">电子邮箱</td>
							<td class="kv-content"><span id="isVisible">${user.email }</span></td>
							<td class="kv-label">联系电话</td>
							<td class="kv-content"><span id="adminer">${user.phone }</span></td>
						</tr>
						<tr>
							<td class="kv-label">地址</td>
							<td class="kv-content"><span id="type">${user.address }</span></td>
							<td class="kv-label">邮编</td>
							<td class="kv-content"><span id="isVisible">${user.postCode }</span></td>
						</tr>
					</tbody>
				</table>
		      </div> 
		
	</div>	
	
</body>
</html>