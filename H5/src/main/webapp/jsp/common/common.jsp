<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0);
    
    String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
%>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/common/common.css"/>
<link rel="stylesheet" href="css/common/bui-min.css"/>
<link rel="stylesheet" href="css/common/dpl-min.css"/>
<link rel="stylesheet" href="css/common/main-min.css"/>
<script src="js/common/jquery/jquery1.9.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/common/bui.js"></script>
<script type="text/javascript" src="js/common/config.js"></script>
<script type="text/javascript" src="js/common/main-min.js"></script>
<script type="text/javascript" src="js/common/sea.js"></script>
<script src="js/common/common.js" type="text/javascript"></script>
<script src="js/common/cookie.js" type="text/javascript"></script>
<script src="js/common/format.js" type="text/javascript"></script>
<c:if test="${sessionScope['oper_key'] == null}">
    <script type="text/javascript">
    //检查是否登录
    $(function() {
        if ($("#LoginForm").size() < 1) {
            top.location.href = baseUrl + loginJSP;
        }
    })
    </script>
</c:if>
