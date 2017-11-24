$(document).ready(function(){
    
	$("#orgList").ligerGrid($.extend(gridOptions, {
		url: 'org/page',
		columns: [
			{display: '组织编号', name: 'organizationId', width: 80, align: 'center'},
			{display: '组织名称', name: 'organizationName', width: 200, align: 'center'},
			{display: '上级组织', name: 'parentName', width: 200, align: 'center'},
			{display: '负责人姓名', name: 'principalName', width: 140, align: 'center'},
			{display: '添加时间', name: 'createtime', width: 140, align: 'center'}
		],
		onDblClickRow: addedit('orgDlg','orgList','jsp/org/Org.jsp','info|edit', 'organizationId')
	}));
	
});
