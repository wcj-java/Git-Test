<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
	<title>权限分配</title>
	<script type="text/javascript" src="js/role/Power.js"></script>
</head>
<body width="480" height="430">
<form action="role/power" method="post" class="uniform" nomargin="true">
	<table class="unitable">
		<tr>
			<td class="col_2_left">
				角色名称：
			</td>
			<td class="col_2_right" id="roleNameTd">
				${param.roleName}
			</td>
		</tr>
		<tr>
			<td class="col_2_left">
				权限列表：
			</td>
			<td class="col_2_right">
				<div class="form_tree">
					<ul id="powerList" />
				</div>
			</td>
		</tr>
	</table>
	<input type="hidden" id="roleId" value="${param.roleId}" >
</form>
</body>
</html>
