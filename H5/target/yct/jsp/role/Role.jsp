<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
<title>角色信息</title>
<script type="text/javascript" src="js/common/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="js/emp/Emp.js"></script>
</head>
<body width="480" height="390" class="unibody">
	<form action="role/insert" method="post" class="uniform">
		<table class="unitable">
			<tr>
				<td class="col_2_left">角色编号：</td>
				<td class="col_2_right"><input type="text" name="roleId" id="roleId" validate="{required: true,rangelength:[0,10]}" noedit="true" /></td>
			</tr>
			<tr>
				<td class="col_2_left">角色名称：</td>
				<td class="col_2_right"><input type="text" name="roleName" id="roleName" validate="{required: true,rangelength:[0,20]}" /></td>
			</tr>
			<tr>
                <td class="col_2_left">所属组织：</td>
                <td class="col_2_right"><input type="text" name="organizationId" id="organizationId" ltype="select" url="org/getAll" textField='organizationName' valueField='organizationId' onSelected="setRole('parentId');" /></td>
            </tr>
            <tr>
                <td class="col_2_left">上级角色：</td>
                <td class="col_2_right"><input type="text" name="parentId" id="parentId" ltype="select" url="" textField='roleName' valueField='roleId' /></td>
            </tr>
			<tr>
				<td class="col_2_left">角色描述：</td>
				<td class="col_2_right"><textarea name="description" id="description" maxlength="140" validate="{rangelength:[0,140]}"></textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>
