<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
	<title>微水洗车客服运营管理平台</title>
    <script type="text/javascript" src="js/main/index.js"></script>
</head>
<body>
<div id="pageloading"></div>
<div id="topToggle"></div>
<div id="layout">
	<div position="top" id="top">
		<div id="top_logo">
		    <img src="img/login/logo-xiao.png">
			<h2>微水洗车客服运营管理平台</h2></div>
		<div id="top_right">
			<div id="top_menu" class="ver-center">
			    <i class="iconfont help-icon">&#xe616;</i>帮助&nbsp;&nbsp;<img src="img/common/line.png" />
 		        &nbsp;&nbsp;<i class="iconfont about-icon">&#xe619;</i>关于&nbsp;&nbsp;<img src="img/common/line.png" />
		        &nbsp;&nbsp;<div id="logout" class="dv-logout"><i class="iconfont logout-icon">&#xe60f;</i><a>退出</a></div>
			</div>
			<div id="top_oper">
			    <i class="iconfont memu-icon">&#xe603;</i><span id="emp">${sessionScope['oper_key'].name}</span><span>${sessionScope['sysDateTime']}</span>
			</div>
		</div>
	</div>
	<div position="left" id="accordion" title="菜单栏">
		<c:forEach items="${sessionScope['firstMenus'] }" var="menu">
			<div title="${menu.menuName }" class="l-scroll">
				<ul id="subMenu_${menu.menuId }">
			</div>
		</c:forEach>
	</div>
	<div position="center" id="framecenter">
		<div tabid="home" title="首页" >
			<iframe height="100%" width="100%" frameborder="no" border="0"></iframe>
		</div>
	</div>
	<div position="bottom" id="footer">
		© 2015 版权所有：<a target="_blank" href="http://www.cheletong.com/">车乐通</a>
	</div>
</div>
<input type="hidden" id="firstLogin" value="${sessionScope['firstLogin']}">
<input type="hidden" id="curOperId" value="${sessionScope['oper_key'].empId}">
</body>
</html>
