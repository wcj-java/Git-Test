<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
	<title>组织管理</title>
	<script type="text/javascript" src="js/org/OrgList.js"></script>
</head>
<body>
<div id="grid_box">
<div id="grid_kong"></div>
<div id="grid_button">
    <div class="liger-button" text="添加" icon="img/icons/add.gif" click="addedit('orgDlg','orgList','jsp/org/Org.jsp');" ></div>
    <div class="liger-button" text="编辑" icon="img/icons/edit.gif" click="addedit('orgDlg','orgList','jsp/org/Org.jsp','update','organizationId');"></div>
    <div class="liger-button" text="删除" icon="img/icons/delete.gif" click="del('orgList','org/delete','organizationId');" ></div>
    <div class="liger-button" text="查询" icon="img/icons/search.gif" click="showUpDownDiv('qryDiv', 320);"></div>
</div>
<div id="grid_down">
	<div id="orgList"></div>
</div>
<div id="qryDiv">
	<form id="qryForm" class="uniform">
		<table class="unitable">
			<tr>
				<td class="col_2_left">
					组织编号：
				</td>
				<td class="col_2_right" exc="true">
					<input type="text" id="organizationId" name="organizationId" />
				</td>
			</tr>
			<tr>
				<td class="col_2_left">
					组织名称：
				</td>
				<td class="col_2_right" vag="true">
				    <input type="text" id="organizationName" name="organizationName" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
                    <div class="liger-button" text="重置" click="qryRst();"></div>
                    <div class="liger-button" text="查询" click="query('orgList', 'qryForm', 'qryDiv');"></div>
				</td>
			</tr>
		</table>
	</form>
</div>
</div>
</body>
</html>