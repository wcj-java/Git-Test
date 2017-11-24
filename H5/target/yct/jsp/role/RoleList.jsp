<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
	<title>角色管理</title>
	<script type="text/javascript" src="js/role/RoleList.js"></script>
</head>
<body>
<div id="grid_box">
<div id="grid_kong"></div>
<div id="grid_button">
    <div class="liger-button" text="添加" icon="img/icons/add.gif" click="addedit('roleDlg','roleList','jsp/role/Role.jsp');" data-disabled="true" path="/role/insert"></div>
    <div class="liger-button" text="编辑" icon="img/icons/edit.gif" click="addedit('roleDlg','roleList','jsp/role/Role.jsp','update','roleId');" data-disabled="true" path="/role/update"></div>
    <div class="liger-button" text="删除" icon="img/icons/delete.gif" click="del('roleList','role/delete','roleId');" data-disabled="true" path="/role/delete"></div>
    <div class="liger-button" text="权限分配" width="100" icon="img/icons/role.gif" click="power();" data-disabled="true" path="/role/power"></div>
    <div class="liger-button" text="查询" icon="img/icons/search.gif" click="showUpDownDiv('qryDiv', 320);"></div>
</div>
<div id="grid_down">
	<div id="roleList"></div>
</div>
<div id="qryDiv">
	<form id="qryForm" class="uniform">
		<table class="unitable">
			<tr>
				<td class="col_2_left">
					角色编号：
				</td>
				<td class="col_2_right" exc="true">
					<input name="roleId" id="roleId" type="text"/>
				</td>
			</tr>
			<tr>
				<td class="col_2_left">
					角色名称：
				</td>
				<td class="col_2_right" vag="true">
					<input name="roleName" id="roleName" type="text" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
                    <div class="liger-button" text="重置" click="qryRst();"></div>
                    <div class="liger-button" text="查询" click="query('roleList', 'qryForm', 'qryDiv');"></div>
				</td>
			</tr>
		</table>
	</form>
</div>
</div>
</body>
</html>