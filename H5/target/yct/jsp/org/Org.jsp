<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
<title>组织信息</title>
<script type="text/javascript" src="js/common/jquery/jquery.validate.js"></script>
</head>
<body width="480" height="390" class="unibody">
	<form action="org/insert" method="post" class="uniform">
		<table class="unitable">
			<tr>
				<td class="col_2_left">组织编号：</td>
				<td class="col_2_right"><input type="text" name="organizationId" id="organizationId" maxlength="10" validate="{required: true,rangelength:[0,10]}" noedit="true" /></td>
			</tr>
			<tr>
				<td class="col_2_left">组织名称：</td>
				<td class="col_2_right"><input type="text" name="organizationName" id="organizationName" maxlength="50" validate="{required: true,rangelength:[0,50]}" /></td>
			</tr>
			<tr>
				<td class="col_2_left">上级组织：</td>
				<td class="col_2_right"><input type="text" name="parentId" id="parentId" ltype="select" url="org/getAll" textField='organizationName' valueField='organizationId' /></td>
			</tr>
			<tr notAdd="true">
				<td class="col_2_left">组织负责人：</td>
				<td class="col_2_right"><input type="text" name="principalId" id="principalId" ltype="select" url="emp/empList?organizationId=$organizationId" textField='name' valueField='empId' /></td>
			</tr>
			<tr>
				<td class="col_2_left">组织描述：</td>
				<td class="col_2_right"><textarea name="description" id="description" maxlength="140" validate="{rangelength:[0,140]}" ></textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>
