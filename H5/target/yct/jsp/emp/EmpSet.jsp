<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
	<title>个人信息设置</title>
	<script type="text/javascript" src="js/emp/EmpSet.js"></script>
    <script type="text/javascript" src="js/common/jquery/jquery.validate.js"></script>
</head>
<body width="470" height="470" class="unibody">
	<form action="emp/empSet" method="post" class="uniform">
		<table class="unitable">
            <tr>
                <td class="col_2_left">工号：</td>
                <td class="col_2_right"><input type="text" name="empNum" id="empNum" maxlength="40" validate="{required: true}" noedit="true" /></td>
            </tr>
            <tr>
                <td class="col_2_left">姓名：</td>
                <td class="col_2_right"><input type="text" name="name" id="name" maxlength="40" validate="{required: true}" /></td>
            </tr>
            <tr>
                <td class="col_2_left">用户名：</td>
                <td class="col_2_right"><input type="text" name="username" id="username" maxlength="40" validate="{required: true}" /></td>
            </tr>
            <tr>
                <td class="col_2_left">性别：</td>
                <td class="col_2_right"><input type="text" name="sex" data="[{text: '男',id: '0' },{text: '女',id: '1' }]" ltype="select" id="sex" maxlength="40" /></td>
            </tr>
            <tr>
                <td class="col_2_left">生日：</td>
                <td class="col_2_right"><input type="text" name="birthday" id="birthday" maxlength="14" ltype="date" format="yyyy-MM-dd" value="1990-01-01" /></td>
            </tr>
            <tr>
                <td class="col_2_left">座机：</td>
                <td class="col_2_right"><input type="text" name="telphone" id="telphone" maxlength="40" validate="{telephone: true}" /></td>
            </tr>
            <tr>    
                <td class="col_2_left">手机：</td>
                <td class="col_2_right"><input type="text" name="mobilephone" id="mobilephone" maxlength="40" validate="{mobilephone: true}" /></td>
            </tr>
            <tr>
                <td class="col_2_left">QQ：</td>
                <td class="col_2_right"><input type="text" name="qq" id="qq" maxlength="20" validate="{rangelength:[5,20]}" /></td>
            </tr>
            <tr>
                <td class="col_2_left">邮箱：</td>
                <td class="col_2_right"><input type="text" name="email" id="email" maxlength="60" validate="{email: true, rangelength:[5,60]}" /></td>
            </tr>
        </table>
        <input type="hidden" name="empId" />
	</form>
</body>
</html>
