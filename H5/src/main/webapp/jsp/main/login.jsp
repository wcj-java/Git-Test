<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<base href="<%=basePath%>">
<html>
<head>
<title>酷鼎网络科技有限公司</title> 
<script src="js/common/jquery/jquery1.9.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/main/login.js"></script>
<link href="css/main/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>酷鼎网络科技有限公司<sup>@2015-2016</sup></h1>
<div class="login" style="margin-top:50px;">  
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    
		<!--登录-->
		<div class="web_login" id="web_login">
			<div class="login-box">
				<div class="login_form">
					<form action="main/login" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
				    	<input type="hidden" name="did" value="0"/>
				    	<input type="hidden" name="to" value="log"/>
			             <div class="uinArea" id="uinArea">
				             <label class="input-tips" for="u">帐号：</label>
				             <div class="inputOuter" id="uArea">
				                 <input type="text" id="username" name="username" class="inputstyle"/>
				             </div>
			             </div>
			             <div class="pwdArea" id="pwdArea">
			            	 <label class="input-tips" for="p">密码：</label> 
				             <div class="inputOuter" id="pArea">
				                 <input type="password" id="password" name="password" class="inputstyle"/>
				             </div>
			             </div>
					    <div style="padding-left:50px;margin-top:20px;">
					    	<input type="button" value="登 录" style="width:150px;" class="button_blue" id="loginBtn"/>
					    </div>
					</form>
				</div>
			</div>
		 </div>
		 <!--登录end-->
  </div>
</div>
<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body></html>