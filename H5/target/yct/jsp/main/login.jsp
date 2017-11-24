<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/common.jsp"%>

<html>
<head>
<title>运营管理平台</title>
</head>
<body>
    <div class="login">
        <div class="title">约聚商户平台</div>
        <div class="div_Warning">
            <div class="close">
                <i class="iconfont error">&#xe60d;</i>
            </div>
            <span>Enter any username and password.</span>
        </div>
        <div class="ipt_wrap">
            <input id="txtUser" type="text" class="ipt" placeholder="管理员姓名" tabindex="1" />
        </div>
        <div class="ipt_wrap">
            <input id="txtPass" type="password" class="ipt" placeholder="管理员密码" tabindex="2" />
            <button id="btnLogin" class="btn blue" tabindex="3">登录</button>
        </div>
        <div class="copyright">第一次使用商户平台？<span id="spnRegister">立即注册</span></div>
        <div class="div_Logo"></div>
    </div>
</body>
</html>
<script>
	var ua = window.navigator.userAgent,browser={ie:false,ver:null};
	if (/MSIE ([^;]+)/.test(ua)){
        browser.ver = RegExp["$1"];
        browser.ie = parseInt(browser.ver);
    }
	if(browser.ie == 6 || browser.ie == 7){
		alert("您所使用的IE浏览器版本过低，请升级到IE8以上，推荐使用Chrome或360浏览器!");
	}			
</script>