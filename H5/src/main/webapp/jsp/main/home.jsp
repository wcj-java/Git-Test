<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>酷鼎网络有限公司管理后台</title>
</head>
<body>
<!-- 搜索页 ================================================== -->
    <div class="row">
      <div class="span24">
        <form id="searchForm" class="form-horizontal" tabindex="0" style="outline: none;">
          <div class="row">
            <div class="control-group span8">
              <label class="control-label">供应商编码：</label>
              <div class="controls">
                <input type="text" name="a" class="control-text">
              </div>
            </div>
            <div class="control-group span8">
              <label class="control-label">供应商编码：</label>
              <div class="controls">
                <input type="text" name="b" class="control-text">
              </div>
            </div>
            <div class="control-group span8">
              <label class="control-label">供应商编码：</label>
              <div class="controls">
                <input type="text" name="c" class="control-text">
              </div>
            </div>
          </div>
          <div class="row">
            <div class="control-group span10">
              <label class="control-label">起始日期：</label>
              <div class="controls bui-form-group" data-rules="{dateRange : true}">
                <input name="start" data-tip="{text : '起始日期'}" data-rules="{required:true}" data-messages="{required:'起始日期不能为空'}" class="input-small calendar" type="text"><label>&nbsp;-&nbsp;</label>
                <input name="end" data-rules="{required:true}" data-messages="{required:'结束日期不能为空'}" class="input-small calendar" type="text">
              </div>
            </div>
            <div class="form-actions span5">
              <button id="btnSearch" type="submit" class="button button-primary">搜索</button>
            </div>
          </div>
          
        </form>
        
      </div>
    </div> 
    <div class="search-grid-container">
      <div id="grid">
    </div> 
    <script type="text/javascript">
    var columns = [
                   { title: '供货商编码',width: 100,  sortable: false, dataIndex: 'empNum'},
                   { title: '供货商姓名', width: 100, sortable: true, dataIndex: 'name', selectable: true },
                   /* { title: '供货商来源', width: 150, sortable: false, dataIndex: 'te', selectable: true ,renderer:function(value,obj){
                       return value+':'+obj.d;
                   }}, */
                   { title: '渠道ID',width: 100, sortable: true,  dataIndex: 'd',  showTip: true },
                   { title: '供货商地址', width: 100,sortable: true,  dataIndex: 'e'},
                   { title: '联系方式1',width: 100, sortable: true,  dataIndex: 'f'},
                   { title: '操作1', width: 300, dataIndex: 'g',renderer:function(value,obj){
                   
                     return '<span class="grid-command">删除</span>';
                   }}
                 ];
    var bars = {
            btnCls : 'button button-primary button-small',
            text:'命令一',
            handler : function(){
              alert('命令一123')
            }
        }
    
$(document).ready(function(){
	BaseGrid('emp/list',columns,'','grid');
})

    </script>
<!-- script end -->
  </div>
</body>
</html>