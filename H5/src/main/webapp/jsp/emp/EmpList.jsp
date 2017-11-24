<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>员工管理</title>
<link rel="stylesheet" href="../../js/common/builds/merged/bsgrid.all.min.css"/>
<link rel="stylesheet" href="../../css/common/example.css"/>
<link rel="stylesheet" href="../../css/common/grid_flexigrid.min.css"/>
<script type="text/javascript" src="../../js/common/jquery/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/js/lang/grid.zh-CN.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/merged/bsgrid.all.min.js"></script>
<script type="text/javascript" src="../../js/common/plugins/layui/layer/layer.js"></script>
<script type="text/javascript" src="../../js/common/bsgrid.js"></script>
</head>
<body style="background-color: #fff;">
<p/>
<form id="searchParams">
   	 姓名:<input type="text" taget="param" name="name"/>
    &emsp;<input type="button" value="查询 " onclick="doSearch();"/>
    &emsp;<input type="button" value="重置" onclick="$('#searchParams input[taget=param]').val('');"/>
    &emsp;<input type="button" onclick="doAdd();" value="添加"/>
</form>

<p/>
<table id="searchTable">
    <tr>
    	<th w_render="checkbox" w_index="empId" width="3%;"><input type="checkbox"/></th>
        <th w_index="empId" width="5%;">主键</th>
        <th w_index="empNum" width="6%;">员编号</th>
        <th w_index="name" width="5%;">姓名</th>
        <th w_index="telphone" width="15%;">电话</th>
        <th w_index="birthday" width="15%;">生日</th>
        <th w_hidden="true" w_index="sex" width="3%;">性别</th>
        <th w_index="sexStr" width="3%;">性别</th>
        <th w_index="qq" width="5%;">QQ</th>
        <th w_hidden="true" w_index="organizationId" width="3%;">所属部门</th>
        <th w_index="organizationStr" width="7%;">所属部门</th>
        <th w_hidden="true" w_index="roleId" width="5%;">职位</th>
        <th w_index="roleStr" width="3%;">职位</th>
        <th w_render="operate" width="10%;">Operate</th>
    </tr>
</table>
<div id="layer-gridForm" style="display: none;">
    <form id="gridForm" class="bsgrid_form">
        <table>
            <tr showType="false">
                <td class="formLabel">ID:</td>
                <td class="formInput"><input name="empId" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel"><span class="require">*</span>员工编号:</td>
                <td class="formInput">
                    <input name="empNum" type="text" editAble="false" />
                    <span class="inputTip" showType="add">Must unique</span>
                </td>
            </tr>
            <tr>
                <td class="formLabel">姓名:</td>
                <td class="formInput"><input name="name" type="text" /></td>
            </tr>
            <tr>
               <!--  <td class="formLabel">电话:</td>
                <td class="formInput"><textarea name="telphone"></textarea></td> -->
                <td class="formLabel">电话:</td>
                <td class="formInput"><input name="telphone" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">生日:</td>
                <td class="formInput"><input name="birthday" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">性别:</td>
                <td>
                	<input name="sex" type="radio" value="0" />男
					<input name="sex" type="radio" value="1" />女
                </td>
            </tr>
            <tr>
                <td class="formLabel">所属部门:</td>
                <td class="formInput">
                	<select name="organizationId" style="width: 64%;">
	                    <option value ="1003">Multiple</option>
	                    <option value ="1001">Multiple2</option>
	                    <option value ="1000">总经理</option>
                	</select>
                </td>
            </tr>
            <tr>
                <td class="formLabel">职位:</td>
                <td class="formInput">
                	<select name="roleId" style="width: 64%;">
	                    <option value ="1003">普通用户</option>
	                    <option value ="1001">普通管理员</option>
	                    <option value ="1000">系统管理员</option>
                	</select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; border-left-width: 0; border-right-width: 0; border-bottom-width: 0;">
                    <input type="button" target="Save" value="确定" onclick="ajaxSubmit();" />
                    &emsp;
                    <input type="button" target="Cancel" value="取消" onclick="$('#layui-layer' + layerGridFormIndex).hide();" />
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    var gridObj,gridFormObject,layerGridFormIndex;
    $(function () {
    	//列表数据显示
    	gridObj = showGrid('searchTable', 'emp/list');
     	//添加，修改的表单
    	showForm('layer-gridForm', '400px', '600px');
    	//初始化表单
        gridFormObject = $.fn.bsgrid_form.init('gridForm', {});
    });
    //表单查询方法
    function doSearch(){
    	searchTable('searchParams', gridObj);
    }
    function ajaxSubmit(){
    	doCommit(gridFormObject,'emp/insert',gridObj,'searchParams');
    }
    //渲染操作栏
    function operate(record, rowIndex, colIndex, options, options) {
        return '<a href="#" onclick="doView(' + rowIndex + ');">查看</a>'
                + '&emsp;<a href="#" onclick="doEdit(' + rowIndex + ');">编辑</a>'
                + '&emsp;<a href="#" onclick="doDelete(' + rowIndex + ');">删除</a>';
    }
    function doAdd() {
        $('#gridForm')[0].reset();
        showFormDialog('add');
    }

    function doView(rowIndex) {
        fillDataAndShowFormDialog('view', rowIndex);
    }

    function doEdit(rowIndex) {
        fillDataAndShowFormDialog('edit', rowIndex);
    }

    function doDelete(rowIndex) {
        var id = gridObj.getColumnValue(rowIndex, 'empId');
        layer.confirm('Delete?', function (index) {
            layer.alert('delete. ID=' + id);
        });
    }

    
</script>
</body>
</html>