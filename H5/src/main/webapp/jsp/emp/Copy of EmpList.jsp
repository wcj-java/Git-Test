<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>员工管理</title>
<link rel="stylesheet" href="../../js/common/builds/merged/bsgrid.all.min.css"/>
<link rel="stylesheet" href="../../css/common/example.css"/>
<link rel="stylesheet" href="../../css/common/grid_jqgrid.min.css"/>
<script type="text/javascript" src="../../js/common/jquery/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/js/lang/grid.zh-CN.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/merged/bsgrid.all.min.js"></script>
<script type="text/javascript" src="../../js/common/plugins/layui/layer/layer.js"></script>
</head>
<body style="background-color: #fff;">
<p/>
<form id="searchParams">
   	 姓名:<input type="text" name="name"/>
    &emsp;<input type="button" value="查询 (方式 1)" onclick="doSearch(1);"/>
    &emsp;<input type="button" value="查询 (方式 2)" onclick="doSearch(2);"/>
    &emsp;<input type="button" value="查询 (方式 3)" onclick="doSearch(3);"/>
    &emsp;<input type="button" value="清除参数" onclick="$('#searchParams input[name=xh]').val('');doSearch();"/>
    &emsp;<input type="button" onclick="doAdd();" value="Add"/>
</form>

<p/>
<table id="searchTable">
    <tr>
    	<th w_render="checkbox" w_index="ID" width="3%;"><input type="checkbox"/></th>
        <th w_index="empId" width="5%;">XH</th>
        <th w_index="empNum" width="5%;">ID</th>
        <th w_index="name" width="15%;">CHAR</th>
        <th w_index="telphone" width="30%;">TEXT</th>
        <th w_index="birthday" width="15%;">DATE</th>
        <th w_index="TIME" width="15%;">TIME</th>
        <th w_index="NUM" width="5%;">NUM</th>
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
                <td class="formLabel"><span class="require">*</span>XH:</td>
                <td class="formInput">
                    <input name="XH" type="text" editAble="false" />
                    <span class="inputTip" showType="add">Must unique</span>
                </td>
            </tr>
            <tr>
                <td class="formLabel">CHAR:</td>
                <td class="formInput"><input name="empNum" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">TEXT:</td>
                <td class="formInput"><textarea name="name"></textarea></td>
            </tr>
            <tr>
                <td class="formLabel">DATE:</td>
                <td class="formInput"><input name="telphone" type="text" /></td>
            </tr>
            <tr>
                <td class="formLabel">TIME:</td>
                <td class="formInput"><input name="birthday" type="text" /></td>
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
            url: '../../emp/list',
            // autoLoad: false,
            pageSizeSelect: true,
            pageSize: 10,
            displayBlankRows: false, // 不显示空白行
            rowHoverColor: true, //划过行变色
            stripeRows: true, //间隔行色
            pagingToolbarAlign: 'center'//底部工具条居中对齐
            
        });
     	// 表格的checkbox选择
    	if($('#searchTable thead tr th:eq(0) input[type=checkbox]').length == 1) {
    	    $('#searchTable thead tr th:eq(0) input[type=checkbox]').change(function () {
                var checked = $.bsgrid.adaptAttrOrProp($(this), 'checked') ? true : false;
                $.bsgrid.adaptAttrOrProp($('#searchTable tbody tr td:nth-child(1)>input[type=checkbox]'), 'checked', checked);
    	    });
    	}
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
    });
    

    function checkbox(record, rowIndex, colIndex, options) {
    	return '<input type="checkbox" value="' + gridObj.getColumnValue(rowIndex, gridObj.getColumnModel(colIndex).index) + '"/>';
    }

    function getCheckedIds() {
    	var records = getCheckedRecords();
        var ids = '';
        for(var i = 0; i < records.length; i++) {
        	ids += ',' + gridObj.getRecordIndexValue(records[i], 'ID');
        }
        alert(ids.length > 0 ? ids.substring(1) : '');
    }
    
    function getCheckedRecords() {
        var records = new Array();
        $('#searchTable tbody tr').each(function() {
        	if($(this).find('td:eq(0)>input:checked').length == 1){
        		records[records.length] = gridObj.getRowRecord($(this));
        	}
        });
        return records;
    }
    
    function doSearch(style) {
        // 提供以下三种带参数方式，可任选其中任意一种
        var searchParames = '';
        if (style == 1) {
            searchParames = $('#searchParams').serializeArray();      // jQuery推荐方式
        } else if (style == 2) {
            searchParames = 'xh=' + $('#searchParams input[name=xh]').val();
        } else if (style == 3) {
            searchParames = {'xh': $('#searchParams input[name=xh]').val()}
        }
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