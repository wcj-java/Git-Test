//登录
	var login = function(){
		//异步提交表单
		$.post($('form').attr("action"), $('form').serialize(), function(msg){
			//登录失败
			console.log(msg);
			if(msg.errorCode != 0){
				$('div.errorMsg').html(errImg+""+msg.message);
			}
			//登录成功
			else{
				//进入主页
				window.location.href = $("base").attr("href") + "jsp/main/index.jsp";
				// 写cookie
				if(Cookie.read("operName") == null || Cookie.read("operName") == '' || Cookie.read("operName") != $("#operName").val()){
					Cookie.write("operName", $("#operName").val(), 24*30);
				}
			}
		});
	}
	$(document).ready(function(){
		$("#loginBtn").click(function() {
			login();
		});
	});
