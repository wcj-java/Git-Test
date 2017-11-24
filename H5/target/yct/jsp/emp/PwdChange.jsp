<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>修改密码</title>
<script type="text/javascript" src="js/common/jquery/jquery.validate.js"></script>
</head>
<body width="400" height="210" class="unibody">
	<form id="PwdForm" action="emp/modPwd" method="post" class="uniform">
		<input type="hidden" id="empId" name="empId" value="${sessionScope['oper_key'].empId}">
		<table class="unitable">
			<tr>
				<td class="col_2_left">原密码：</td>
				<td class="col_2_right"><input type="password" name="password" id="password" validate="{required: true, rangelength:[6,30]}" /></td>
			</tr>
			<tr>
				<td class="col_2_left">新密码：</td>
				<td class="col_2_right"><input type="password" name="newPassword" id="newPassword" validate="{required: true,rangelength:[6,30]}" /></td>
			</tr>

			<tr>
				<td class="col_2_left">确认密码：</td>
				<td class="col_2_right"><input type="password" id="conPwd" validate="{required: true, rangelength:[6,30], equalTo: '#newPassword'}" /></td>
			</tr>
		</table>
	</form>
</body>
</html>

