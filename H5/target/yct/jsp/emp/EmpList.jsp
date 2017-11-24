<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
<title>员工管理</title>
<script type="text/javascript" src="js/emp/EmpList.js"></script>
<script type="text/javascript" src="js/emp/Emp.js"></script>
</head>
<body>
	<div id="grid_box">
		<div id="grid_kong"></div>
		<div id="grid_button">
			<div class="liger-button" text="添加" icon="img/icons/add.gif" click="addedit('empDlg','empList','jsp/emp/Emp.jsp');"></div>
			<div class="liger-button" text="编辑" icon="img/icons/edit.gif" click="addedit('empDlg','empList','jsp/emp/Emp.jsp','update','empId');"></div>
			<div class="liger-button" text="删除" icon="img/icons/delete.gif" click="del('empList','emp/delete','empId');"></div>
			<div class="liger-button" text="重置密码" icon="img/icons/pwd.gif" click="resetPassword('empList','emp/resetPwd','empId');" width="105"></div>
			<div class="liger-button" text="查询" icon="img/icons/search.gif" click="showUpDownDiv('qryDiv', 600);"></div>
		</div>
		<div id="grid_down">
			<div id="empList"></div>
		</div>
		<div id="qryDiv">
			<form id="qryForm" class="uniform">
				<table class="unitable">
					<tr>
						<td class="col_4_left">员工工号：</td>
						<td class="col_4_right" exc="true"><input type="text" id="empNum" name="empNum" /></td>
						<td class="col_4_left">员工姓名：</td>
						<td class="col_4_right" vag="true"><input type="text" id="name" name="name" /></td>
					</tr>
					<tr>
						<td class="col_4_left">所属组织：</td>
		                <td class="col_4_right"><input type="text" id="organizationId" validate="{required: true}" ltype="select" data="[{organizationName: '全部',organizationId: '-1' }]" url='org/getAll' textField='organizationName' valueField='organizationId' onSelected="setRole('roleId');" /></td>
		                <td class="col_4_left">所属角色：</td>
		                <td class="col_4_right"><input type="text" id="roleId" validate="{required: true}" ltype="select" url='role/roleList' textField='roleName' valueField='roleId' /></td>
					</tr>
					<tr>
                        <td class="col_4_left">状态：</td>
                        <td class="col_4_right"><input type="text" name="status" id="status" ltype="select" data="[{text: '全部',id: '-1' },{text: '正常',id: '0' },{text: '注销',id: '1' },{text: '暂时冻结',id: '2' }]" /></td>
                        <td class="col_4_left"></td>
                        <td class="col_4_right"></td>
                    </tr>
					<tr>
						<td colspan="4">
							<div class="liger-button" text="重置" click="qryRst();"></div>
							<div class="liger-button" text="查询" click="query('empList', 'qryForm', 'qryDiv');"></div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>