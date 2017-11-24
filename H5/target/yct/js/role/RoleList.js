$(document).ready(function(){
	
	$("#roleList").ligerGrid($.extend(gridOptions, {
		url: 'role/list',
		columns: [
			{display: '角色编号', name: 'roleId', width: 80, align: 'center'},
			{display: '角色名称', name: 'roleName', width: 100, align: 'center'},
			{display: '上级角色名称', name: 'parentStr', width: 100, align: 'center'},
			{display: '所属组织', name: 'organizationStr', width: 160, align: 'center'},
			{display: '角色描述', name: 'description', width: 160, align: 'center'},
            {display: '添加时间', name: 'createtime', width: 140, align: 'center'}
		],
		onDblClickRow: addedit('roleDlg','roleList','jsp/role/Role.jsp','info|edit', 'roleId')
	}));
	
});


/**
 * 权限分配
 */
function power(){
    return function(){
        var grid = liger.get("roleList");
    	if(grid.getSelectedRows().length != 1){
    	    $.ligerDialog.warn("请选择一条要分配权限的角色记录！");
    		return;
    	}
    	var roleId = grid.getSelectedRow()['roleId'];
    	var roleName = grid.getSelectedRow()['roleName'];
    
    	$.ligerDialog.open($.extend(dialogOptions, {
            id : "powerDlg",
            url : "jsp/role/Power.jsp?roleId="+roleId+"&roleName="+encodeURIComponent(encodeURIComponent(roleName)),
            buttons : [{
                id : "okBtn",
                text : "确定",
                width : 40,
                onclick : function(){
                    //加载完成后重设dlg大小和标题
                    var dlg = liger.get("powerDlg");
                    var dlgWin = dlg.jiframe[0].contentWindow;
                    
                    //组装参数
                    var menuIds = [];
                    $(dlgWin.tree.getChecked().concat(dlgWin.tree.getHalfChecked())).each(function(i){
                        menuIds[i] = "menuIds="+ this.data.id;
                    });
                    
                    //异步提交的回调函数
                    var cb = function(msg){
                        if(msg.error != null){
                            $.ligerDialog.error(msg.error.message);
                        }else{
                            dlg.close();
                            $.ligerDialog.mess("操作成功！", 1);
                        }
                    }
                    //表单异步提交
                    $.post($("form", dlgWin.document).attr("action"), menuIds.join('&')+"&roleId="+$("#roleId", dlgWin.document).val(), cb);
                }
            },{
                id : "cancelBtn",
                text : "取消",
                width : 40,
                onclick : function(item, g, i){
                    g.close();
                }
            }],
            onLoaded : dlgOnLoad
        }));
    }
}