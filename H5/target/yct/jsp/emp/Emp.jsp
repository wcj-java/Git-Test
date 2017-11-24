<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
<title>员工信息</title>
<script type="text/javascript" src="js/common/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="js/emp/Emp.js"></script>
</head>
<body width="760" height="380" class="unibody">
	<form action="emp/insert" method="post" class="uniform">
		<table class="unitable">
			<tr>
			    <td class="col_4_left">工号：</td>
                <td class="col_4_right"><input type="text" name="empNum" id="empNum" maxlength="40" validate="{required: true}" /></td>
				<td class="col_4_left">姓名：</td>
				<td class="col_4_right"><input type="text" name="name" id="name" maxlength="40" validate="{required: true}" /></td>
			</tr>
			<tr>
				<td class="col_4_left">性别：</td>
				<td class="col_4_right"><input type="text" name="sex" data="[{text: '男',id: '0' },{text: '女',id: '1' }]" ltype="select" id="sex" maxlength="40" /></td>
				<td class="col_4_left">生日：</td>
				<td class="col_4_right"><input type="text" name="birthday" id="birthday" maxlength="14" ltype="date" format="yyyy-MM-dd" value="1990-01-01" /></td>
			</tr>
			<tr>
			    <td class="col_4_left">所属组织：</td>
                <td class="col_4_right"><input type="text" id="organizationId" validate="{required: true}" ltype="select" url='org/getAll' textField='organizationName' valueField='organizationId' onSelected="setRole('roleId');" /></td>
				<td class="col_4_left">所属角色：</td>
				<td class="col_4_right"><input type="text" id="roleId" validate="{required: true}" ltype="select" url='role/roleList' textField='roleName' valueField='roleId' /></td>
			</tr>
			<tr>
			    <td class="col_4_left">用户名：</td>
                <td class="col_4_right"><input type="text" name="username" id="username" maxlength="40" validate="{required: true}" /></td>
                <td class="col_4_left">状态：</td>
                <td class="col_4_right"><input type="text" name="status" data="[{text: '正常',id: '0' },{text: '注销',id: '1' },{text: '暂时冻结',id: '2' }]" ltype="select" id="status" /></td>
            </tr>
			<tr>
                <td class="col_4_left">座机：</td>
                <td class="col_4_right"><input type="text" name="telphone" id="telphone" maxlength="40" validate="{telephone: true}" /></td>
				<td class="col_4_left">手机：</td>
				<td class="col_4_right"><input type="text" name="mobilephone" id="mobilephone" maxlength="40" validate="{mobilephone: true}" /></td>
			</tr>
			<tr>
                <td class="col_4_left">QQ：</td>
                <td class="col_4_right"><input type="text" name="qq" id="qq" maxlength="20" validate="{rangelength:[5,20]}" /></td>
				<td class="col_4_left">邮箱：</td>
				<td class="col_4_right"><input type="text" name="email" id="email" maxlength="60" validate="{email: true, rangelength:[5,60]}" /></td>
			</tr>
		</table>
		<input type="hidden" name="empId" />
	</form>
</body>
</html>
