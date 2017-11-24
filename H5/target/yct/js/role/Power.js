
var tree;
$(document).ready(function(){
	//初始化权限列表
	tree = $("#powerList").ligerTree({
		url: "role/getPower?roleId=" + $("#roleId").val(),
		iconFieldName: null,
		checkbox: true,
		slide : false,
		nodeWidth : 105,
		btnClickToToggleOnly : false,
		leafCheckboxEven : false,
		onError : function(data){
			//重新登录
			if(reLogin && reLogin(data))
				return;
		}
	});
	
	//中文转码
	$("#roleNameTd").text(decodeURIComponent($("#roleNameTd").text()));
	
	// form_tree滚动条
    $("div.form_tree").niceScroll({cursorcolor: '#389eca', autohidemode: false});
});
