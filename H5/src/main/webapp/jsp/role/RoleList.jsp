<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>员工管理</title>
<link rel="stylesheet" href="../../js/common/builds/merged/bsgrid.all.min.css"/>
<link rel="stylesheet" href="../../css/common/example.css"/>
<link rel="stylesheet" href="../../css/common/grid_flexigrid.min.css"/>
<link rel="stylesheet" href="../../js/common/builds/merged/grid.simple.min.css"/>
<script type="text/javascript" src="../../js/common/jquery/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/js/lang/grid.zh-CN.min.js"></script>
<script type="text/javascript" src="../../js/common/builds/merged/bsgrid.all.min.js"></script>
<script type="text/javascript" src="../../js/common/plugins/layui/layer/layer.js"></script>
<script type="text/javascript" src="../../js/common/builds/merged/grid.simple.min.js"></script>
<script type="text/javascript" src="../../js/common/bsgrid.js"></script>
</head>
<style type="text/css">
        #searchTable_fixedDiv {
            padding: 0;
            border-width: 0;
            width: 98%;
            overflow-y: auto;
            margin-bottom: -1px;
        }
        #searchTable {
            width: auto;
        }
        #searchTable_pt_outTab {
            border-top-width: 1px;
        }
    </style>
<table id="searchTable">
    <tr>
        <th w_index="XH" w_sort="XH,asc" width="5%;">XH</th>
        <th w_index="ID" w_sort="ID" width="5%;">ID</th>
        <th w_index="CHAR" w_align="left" width="15%;">CHAR</th>
        <th w_index="TEXT" w_align="left" width="30%;">TEXT</th>
        <th w_index="DATE" width="15%;">DATE</th>
        <th w_index="TIME" width="15%;">TIME</th>
        <th w_index="NUM" width="5%;">NUM</th>
        <th w_render="operate" width="10%;">Operate</th>
    </tr>
</table>
<script type="text/javascript">
    var gridObj;
    var fixedGridHeight = 200;
    var fixedGridLock = false;
    $(function () {
        $.fn.bsgrid.defaults.extend.afterRenderGridMethods['fixedHeader'] = fixedHeader;

        gridObj = $.fn.bsgrid.init('searchTable', {
            url: '../common/json.jsp',
            // autoLoad: false,
            pageSizeSelect: true,
            pageSize: 10
        });

        $('#searchTable').wrap('<div id="searchTable_fixedDiv"></div>');
        $('#searchTable_fixedDiv').height(fixedGridHeight);
        fixedHeader('first');
        $(window).resize(function () {
            fixedHeader();
        });
    });

    function fixedHeader(iFirst) {
        if (fixedGridLock) {
            return;
        }
        fixedGridLock = true;
        if ($.trim(iFirst) != 'first') {
            $('#searchTable thead tr:eq(0)').remove();
        }
        if (fixedGridHeight < $('#searchTable').height()) {
            $('#searchTable_fixedDiv').height(fixedGridHeight);
            $('#searchTable').width($('#searchTable_fixedDiv').width() - 18);
        } else {
            $('#searchTable_fixedDiv').height($('#searchTable').height());
            $('#searchTable').width($('#searchTable_fixedDiv').width() - 1);
        }
        $('#searchTable thead tr:eq(0)').clone(true).prependTo('#searchTable thead');
        $('#searchTable thead tr:eq(0)').css({'z-index': 10, position: 'fixed'}).width($('#searchTable thead tr:last').width());

        var thObjs = $('#searchTable thead tr:eq(1) th');
        thObjs.each(function (i) {
            var thObj = $(this);
            $('#searchTable thead tr:eq(0) th:eq(' + i + ')').height(thObj.height() + 1).width(thObj.width() + 1);
        });
        fixedGridLock = false;
    }

    function operate(record, rowIndex, colIndex, options) {
        return '<a href="#" onclick="alert(\'ID=' + gridObj.getRecordIndexValue(record, 'ID') + '\');">Operate</a>';
    }
</script>
</body>
</html>