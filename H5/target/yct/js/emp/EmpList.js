$(document).ready(function(){
	
	$("#empList").ligerGrid($.extend(gridOptions, {
		url: 'emp/list',
		columns: [
			{display: '员工编号', name: 'empId', width: 80, align: 'center',hide:true},
			{display: '员工工号', name: 'empNum', width: 140, align: 'center'},
			{display: '姓名', name: 'name', width: 80, align: 'center'},
			{display: '员工状态', name: 'status', width: 80, align: 'center',hide:true},
			{display: '员工状态', name: 'statusStr', width: 80, align: 'center',isSort:false},
			{display: '所属角色编号', name: 'roleId', width: 80, align: 'center',isSort:false,hide:true},
			{display: '所属组织名称', name: 'organizationStr', width: 160, align: 'center',isSort:false},
			{display: '所属角色名称', name: 'roleStr', width: 120, align: 'center',isSort:false},
			{display: '座机', name: 'telphone', width: 150, align: 'center'},
			{display: '手机', name: 'mobilephone', width: 150, align: 'center'},
			{display: 'QQ', name: 'qq', width: 90, align: 'center'},
			{display: '邮箱', name: 'email', width: 150, align: 'center'},
			{display: '用户名', name: 'username', width: 120, align: 'center'},
			{display: '创建时间', name: 'createTime', width: 140, align: 'center'}
		],
		onDblClickRow: addedit('empDlg','empList','jsp/emp/Emp.jsp','info||edit', 'empId')
	}));
	
});


/** 
 * 密码重置
 */
function resetPassword(gridId,url,objKey){//key-主键,形如:empid
	 return function(){
		var grid = liger.get(gridId);
	    var rows = grid.getSelectedRows();
	    if (rows.length == 0) {
	        $.ligerDialog.warn("请选择<font class='orange'>一个</font>要重置密码的员工！");
	        return;
	    }
	    
	    $.ligerDialog.confirm("确定重置该员工密码吗？", resetAction(url, gridId, "empId="+rows[0][objKey]));
	}
}

/**
 * 密码重置按钮事件
 */
var resetAction = function(action,gridId,params){
	return function () {
		  $.ligerDialog.waitting();
		  // 异步提交的回调函数
		  var cb = function (msg) {
			  $.ligerDialog.closeWaitting();
			  if(msg.error != null){
                  $.ligerDialog.error(msg.error.message);
              }else{
			      $.ligerDialog.mess("操作成功！",2);
			       if (gridId) {
			          liger.get(gridId).reload();
			       }
			   }
		  }
		  // 表单异步提交
		$.post(action, params, cb);
	 }
}

