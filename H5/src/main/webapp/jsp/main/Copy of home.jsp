<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>
<html>
<head>
<title>酷鼎网络有限公司管理后台</title>
</head>
<body>
  <div class="demo-content">
    <div class="row">
      <div class="span16">
        <div id="grid"></div>
      </div>
    </div>
    <script type="text/javascript">
        BUI.use(['bui/grid','bui/data'],function(Grid,Data){
            var Store = Data.Store,
          columns = [
            {title : '员工编号',dataIndex :'empNum', width:100},
            {id: '用户名',title : 'name',dataIndex :'name', width:100},
            {title : '电话',dataIndex : 'telphone',width:200}
          ];
          
 
        var store = new Store({
            url : 'emp/list',
            autoLoad:true,
            pageSize : 30,
            proxy : {
              ajaxOptions : { //ajax的配置项，不要覆盖success,和error方法
                traditional : true,
                type : 'post'
              }
            },
            params : {
              a : ['a1','a2'],
              b : 'b1'
            },
            root : 'data',
            totalProperty : 'totalRows'
          }),
          grid = new Grid.Grid({
            render:'#grid',
            columns : columns,
            loadMask: true,
            store: store,
            // 底部工具栏
            bbar:{
                // pagingBar:表明包含分页栏
                pagingBar:true
            }
          });
 
        grid.render();
      });
    </script>
<!-- script end -->
  </div>
</body>
</html>