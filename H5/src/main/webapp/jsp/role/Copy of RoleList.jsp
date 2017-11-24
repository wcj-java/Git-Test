<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>员工管理</title>
<link rel="stylesheet" href="css/common/grid_jqgrid.min.css"/>
</head>
<body style="background-color: #fff;">
<form id="searchForm">
    XH:<input type="text" name="xh" value="12"/>
    &emsp;
    <input type="button" onclick="doSearch();" value="Search"/>
    &emsp;
    <input type="button" onclick="doAdd();" value="Add"/>
</form>

<p/>
<div id="searchParams_view" style="width: 96%; border: solid 1px #ccc; padding: 10px;">
</div>

<p/>
<table id="searchTable">
    <tr>
        <th w_check="true" width="3%;"></th>
        <th w_index="empId" w_sort="XH,desc" width="5%;">XH</th>
        <th w_index="empId" width="5%;">ID</th>
        <th w_index="name" w_align="left" width="15%;">CHAR</th>
        <th w_index="telphone" w_align="left" w_length="30" width="27%;">TEXT</th>
        <th w_index="birthday" width="15%;">DATE</th>
        <th w_index="empNum" width="15%;">TIME</th>
        <th w_index="NUM" width="5%;">NUM</th>
        <th w_index="ID" w_render="operate" width="10%;">Operate</th>
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
                <td class="formLabel"><span class="require">*</span>XH:</td>
                <td class="formInput">
                    <input name="XH" type="text" editAble="false" />
                    <span class="inputTip" showType="add">Must unique</span>
                </td>
            </tr>
            <tr>
                <td class="formLabel">CHAR:</td>
                <td class="formInput"><input name="name" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">TEXT:</td>
                <td class="formInput"><textarea name="telphone"></textarea></td>
            </tr>
            <tr>
                <td class="formLabel">DATE:</td>
                <td class="formInput"><input name="birthday" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">TIME:</td>
                <td class="formInput"><input name="empNum" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">NUM:</td>
                <td class="formInput"><input name="NUM" type="text" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; border-left-width: 0; border-right-width: 0; border-bottom-width: 0;">
                    <input type="button" value="Save" onclick="doCommit();" />
                    &emsp;
                    <input type="button" value="Cancel" onclick="$('#layui-layer' + layerGridFormIndex).hide();" />
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    var gridObj;
    var gridFormObject;
    var layerGridFormIndex;

    $(function () {
        gridObj = $.fn.bsgrid.init('searchTable', {
            url: 'emp/list',
            pageSizeSelect: true,
            pageSize: 10,
            autoLoad: false,
            beforeSend: function (options, XMLHttpRequest) {
                $('#searchParams_view').html('Search params: ' + gridObj.getPageCondition(gridObj.getCurPage()));
            }
        });

        if ($('#layer-gridForm').length == 1) {
            var gridFormHtml = $("#layer-gridForm").html();
            $("#layer-gridForm").html('');
            layerGridFormIndex = layer.open({
                type: 1,
                title: 'Form',
                shade: false,
                area: ['400px', '380px'],
                content: gridFormHtml,
                cancel: function (index) {
                    $('#layui-layer' + index).hide();
                    return false;
                }
            });
            $('#layui-layer' + layerGridFormIndex).hide();
        }

        // grid form obj, note grid form should init after layer
        gridFormObject = $.fn.bsgrid_form.init('gridForm', {});

        doSearch();

        doAdd();
    });

    function doSearch() {
        var searchParames = $('#searchForm').serializeArray();
        gridObj.search(searchParames);
    }

    function operate(record, rowIndex, colIndex, options, options) {
        return '<a href="#" onclick="doView(' + rowIndex + ');">View</a>'
                + '&emsp;<a href="#" onclick="doEdit(' + rowIndex + ');">Edit</a>'
                + '&emsp;<a href="#" onclick="doDelete(' + rowIndex + ');">Delete</a>';
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

    function fillDataAndShowFormDialog(type, rowIndex) {
        // get record by rowIndex: gridObj.getRecord(rowIndex)
        // get column value by record and index: gridObj.getRecordIndexValue(record, index)
        // get column value by rowIndex and index: gridObj.getColumnValue(rowIndex, index)
        var record = gridObj.getRecord(rowIndex);
        console.log(record);
        $('#gridForm :input').each(function () {
            var input_name = $.trim($(this).attr('name'));
            if (input_name != '') {
                var input_value = gridObj.getRecordIndexValue(record, input_name);
                if ($(this).attr('type') == 'radio' || $(this).attr('type') == 'checkbox') {
                    if ((',' + input_value + ',').indexOf(',' + $(this).val() + ',') > -1) {
                        $.bsgrid.adaptAttrOrProp($(this), 'checked', true);
                    } else {
                        $.bsgrid.adaptAttrOrProp($(this), 'checked', false);
                    }
                } else {
                    $(this).val(input_value);
                }
            }
        });
        showFormDialog(type);
    }

    function showFormDialog(type) {
        gridFormObject.showForm(type);
        if (type == 'view') {
            $('#gridForm :button[value=Save]').hide();
        } else {
            $('#gridForm :button[value=Save]').show();
        }
        layer.title(type, layerGridFormIndex)
        $('#layui-layer' + layerGridFormIndex).show();
    }

    function doDelete(rowIndex) {
        var id = gridObj.getColumnValue(rowIndex, 'ID');
        layer.confirm('Delete?', function (index) {
            layer.alert('delete. ID=' + id);
        });
    }

    function doCommit() {
        var type = gridFormObject.options.formType;
        if (type == 'view') {
            alert('This is view.');
        } else if (type == 'add') {
            alert($('#gridForm').serialize() + '&formType=' + type);
        } else if (type == 'edit') {
            // editAble false not commit
            alert($('#gridForm :not([editAble="false"])').serialize() + '&formType=' + type);
        } else {
            alert('None.');
        }
    }
</script>
</body>
</html>