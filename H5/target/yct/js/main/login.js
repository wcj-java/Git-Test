
$(function(){
    
    //判断是否在对话框中
    if(self.frameElement && self.frameElement.tagName == "IFRAME"){
        top.location.href = baseUrl;
    }
	
	//判断是否已经登录（用户在主页进行后退操作）
	setTimeout(function(){//这里是jquery的一个bug，用setTimeout来修正
		$.post("main/getCurOper", function(oper){
			//如果没有登录
			if(oper == null){
				//更换验证码
				$('#patchcaImg').click(function() {
					$(this).hide().attr('src', 'patchca.img?' + Math.floor(Math.random() * 100)).fadeIn();
				})
				//验证码提示
				.ligerTip({ content: '看不清？点击更换！' });
				
				//取cookie中保留的用登录名
				var cookieName = Cookie.read("operName");
				if(cookieName != null){
					$("#operName").val(cookieName);
				}
				
				//设置焦点
				if($("#operName").val() == ""){
					$("#operName").focus();
				}else if($("#operPwd").val() == ""){
					$("#operPwd").focus();
				}else if($("#checkCode").val() == ""){
					$("#checkCode").focus();
				}
				
				// 登录提交
				$("#loginBtn").click(function() {
					login();
				});
				
				//回车动作
				$(document).bind("keydown", function(event){
					var code = event.keyCode || event.which;
					if (code == 13) {
						login();
					}
				});
				
				// 重置表单
				$("#resetBtn").click(function() {
					$('form')[0].reset();
					$('div.errorMsg').html("");
					$('input', 'form').eq(0).focus();
				})
			} else {
				//隐藏登录表单
				$("#loginTable").hide();
				$("#reLoginTable").show();
				
				//显示登录用户名字
				$("#name").text(oper.name);
				
				// 已成功登录跳转首页
				$("#reLoginBtn").click(function() {
					window.location.href = baseUrl + "jsp/main/index.jsp";
				});
				// 退出
				$("#logoutBtn").click(function() {
					$.post("main/logout", function(){
						//返回登陆页
						window.location.href = baseUrl + "jsp/main/login.jsp";
					});
				});
			}
		}, "JSON");
	}, 0);
	
	//按钮样式
	$(".login_btn").mousedown(function(){
		$(this).addClass("login_btn_l");
	}).hover(function(){
		$(this).addClass("login_btn_l");
	}, function(){
		$(this).removeClass("login_btn_l");
	});
	
	//登录
	var login = function(){
		// 验证必填
		if($("#operName").val() == ""){
			$('div.errorMsg').html(errImg+"请输入用户名");
			return;
		}
		if($("#operPwd").val() == ""){
			$('div.errorMsg').html(errImg+"请输入密码");
			return;
		}
		if($("#checkCode").val() == ""){
			$('div.errorMsg').html(errImg+"请输入验证码");
			return;
		}
		
		//禁用登录按钮
		$("#loginBtn").off().addClass("disable");
		//异步提交表单
		$.post($('form').attr("action"), $('form').serialize(), function(msg){
			//登录失败
			if(msg.error != null){
				$('div.errorMsg').html(errImg+""+msg.error.message);
				
				//恢复按钮可用
				$("#loginBtn").removeClass("disable").click(function() {
					login();
				});
			}
			//登录成功
			else{
				//进入主页
				window.location.href = baseUrl + "jsp/main/index.jsp";
				
				// 写cookie
				if(Cookie.read("operName") == null || Cookie.read("operName") == '' || Cookie.read("operName") != $("#operName").val()){
					Cookie.write("operName", $("#operName").val(), 24*30);
				}
			}
		});
	}
});
