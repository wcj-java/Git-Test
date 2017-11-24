$(function() {
	
	//判断是否首次登录系统
	var firstLogin = $("#firstLogin").val();
	if(eval(firstLogin)){
	    $.ligerDialog.open($.extend(dialogOptions, {
			id : "pwdResetDlg",
			url : "jsp/emp/PwdReset.jsp",
			allowClose : false,
			buttons : [{
	            id : "okBtn",
	            text : "确定",
	            width : 40,
	            onclick : doOkClick("pwdResetDlg")
	        },{
	            id : "cancelBtn",
	            text : "取消",
	            width : 40,
	            onclick : function(item, g, i){
	                window.location.href = baseUrl + "jsp/main/login.jsp";
	            }
	        }],
	        onLoaded : function(dlg, opt) {
                dlgOnLoad(dlg, opt);
                
                var dlgWin = dlg.jiframe[0].contentWindow;
                var dlgDoc = dlgWin.document;
                var f = dlgDoc.forms[0];
                
                //必输样式
                $("input,textarea,select", f).each(function() {
                    var validate = $(this).attr("validate");
                    if (validate != null && validate.indexOf("required") != -1) {
                        $(this).parents("td").prev("td").prepend("<span class='require orange'>*</span>");
                    }
                });
                
                // ligerForm
                dlgWin.formChange(f);
	        }
		}));
	}
	
	// 布局
	var ll = $("#layout").ligerLayout({
		topHeight : 88,
		space : 1,
		allowTopResize : false,
		bottomHeight : 37,
		allowBottomResize : false,
		leftWidth : 200,
		onHeightChanged : function(options) {
			if (tab){
				tab.addHeight(options.diff);
			}
			if (accordion && options.middleHeight - 40 > 0)
				accordion.setHeight(options.middleHeight - 40);
		}
	});
	
	// 顶部隐藏按钮
	$("#topToggle").click(function(){
		ll.toggleTopCollapse();
		ll.toggleBottomCollapse();
		if($("#top").is(":visible")){
			$(this).css({"top":85,"height":4,"background-image":"url(img/common/switch_up.gif)"});
		}else{
			$(this).css({"top":-4,"height":8,"background-image":"url(img/common/switch_down.gif)"});
		}
	}).hover(function(){
		if($("#top").is(":visible")){
			$(this).css({"top":81,"height":8});
		}else{
			$(this).css({"top":0,"height":8});
		}
	},function(){
		if($("#top").is(":visible")){
			$(this).css({"top":85,"height":4});
		}else{
			$(this).css({"top":-4,"height":8});
		}
	});
	
	var height = $(".l-layout-center").height();

	// 标签页
	$("#framecenter").ligerTab({
		height : height,
		onAfterSelectTabItem : function(tabid){
		    //选中的tab项，对应的菜单栏也高亮
            if($("#"+tabid).size() > 0) {
                var ul = $("#"+tabid).parent().parent(),tab_child = $("#"+tabid).children(".l-body");
                if(!(ul.css("display")=="block")) {
                    $(".l-accordion-content").hide();
                    ul.show();
                }
                if(!(tab_child.hasClass("l-selected"))){
                    $("#"+tabid).parent().children("li").each(function(){
                        if($(this).children(".l-body").hasClass("l-selected"))
                            $(this).children(".l-body").removeClass("l-selected");  
                    });
                    $("#"+tabid).children(".l-body").addClass("l-selected");
                }
            }
		},
		onAfterRemoveTabItem : function(tabid){
		    //移除tab项，对应的菜单也去高亮
            if($("#"+tabid).size() > 0) {
                var ul = $("#"+tabid).parent().parent(),tab_child = $("#"+tabid).children(".l-body");
                tab_child.removeClass("l-selected");
                if($("div.l-selected", ul).size() == 0) {//如果子菜单都没有高亮的，则一级菜单收缩
                    ul.hide();
                    var togglebtn = $(".l-accordion-toggle", ul.prev());
                    togglebtn.removeClass("l-accordion-toggle-open l-accordion-toggle-close-over l-accordion-toggle-open-over").addClass("l-accordion-toggle-close").text("\ue61a");
                }
            }
		}
	});
	// 标签页文字禁止选中
	$("div.l-tab-links").noSelect();

	// 菜单
	$("#accordion").ligerAccordion({
		height : height - 40,
		iconfont : true
	});
	
	//菜单栏伸缩样式
	$(".l-layout-header-toggle").addClass("iconfont").text("\ue605");
	$(".l-layout-collapse-left-toggle").addClass("iconfont").text("\ue604");
	
	// 菜单栏滚动条样式
	$("div.l-scroll").niceScroll({cursorcolor: '#389eca', autohidemode: false});
	
	// 菜单栏文字禁止选中
	$("div.l-layout-left, div#top *").noSelect();

	// 树
	$("ul[id^=subMenu]").each(function(){
		var menu = this;
		var menuId = $(this).attr("id").split("_")[1];
		$(this).ligerTree({
			url : "main/subMenus?menuId=" + menuId,
			checkbox : false,
			treeLine : false,
			autoWidth : true,
			parentIcon : null,
			childIcon : null,
			//iconBaseUrl : 'img/menu',
			nodeWidth : 145,
			btnClickToToggleOnly : false,
			onClick : function(node) {
				if (!node.data.url)
					return;
				tab.addTabItem({
					tabid : node.data.id,
					text : node.data.text,
					url : node.data.url
				});
				this.setSelect($("li#"+node.data.id));
			},
			isLeaf : function(data) {
				if (!data.url) return false;
				return true;
			},
			delay: function(e) {
                var data = e.data;
                if (!data.url){
                    return { url: "main/subMenus?menuId=" + data.id}
                }
                return false;
            }
		});
	});
	
	var tab = $("#framecenter").ligerGetTabManager();
	window.tab = tab;//注册到window上去
	var accordion = $("#accordion").ligerGetAccordionManager();
	var tree = $("#subMenu").ligerGetTreeManager();
	
	$("#pageloading").hide();
	
	//窗体大小调整
	windowResize();
	
	//添加菜单栏和一级菜单图标
	$("div.l-layout-header-inner").prepend("<i class='iconfont main-menu'>&#xe613;</i>");
	//
	var iconFontCode = {"100000":"&#xe600","200000":"&#xe611","300000":"&#xe630","400000":"&#xe61e","500000":"&#xe61f","600000":"&#xe623","700000":"&#xe620"};
	$("div.l-accordion-header-inner").each(function(){
		var id = $(this).parent().next().find("ul").attr("id");
		$(this).prepend("<i class='iconfont'>" + iconFontCode[id.substring(id.indexOf("_")+1)] + "</i>&nbsp;");
	});
	
	//让按钮文字换行
	$("#top_menu span").before("<br />");
	
	//加载“首页”
	$("iframe").attr("src", "jsp/main/home.jsp");//解决IE9 下iframe回收bug，导致 "jQuery"未定义bug
	
	//个人设置
	$("#emp").on("click", addedit('empSetDlg', null, 'jsp/emp/EmpSet.jsp', 'info|edit', null, 'empId='+$("#curOperId").val()));

	//退出
	$("#logout").on("click", function(){
		$.ligerDialog.confirm("确定退出系统么？", function(){
			$.post("main/logout", function(){
				//返回登陆页
				window.location.href = baseUrl + "jsp/main/login.jsp";
			});
		});
	});
	
});

/**
 * 窗口大小调整
 */
function windowResize(){
	if($('body').height() < 500 || $('body').width() < 680){
		window.resizeTo(800, 600);
		window.moveTo((screen.availWidth - 800) / 2, (screen.availHeight - 600) / 2);
	}
	
	$(window).resize(function(){
		windowResize();
	});
}

/**
 * 个人设置提交后，更新用户姓名
 */
function afterSubmit(){
	$.post("emp/get", "empId="+$("#curOperId").val(), function(emp){
		$("#emp").text(emp.name);
	});
}
