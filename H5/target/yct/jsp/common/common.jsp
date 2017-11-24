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

<link href="img/common/favicon.ico" rel="shortcut icon" type="image/x-icon" >
<link href="css/common/Index.css" rel="stylesheet" type="text/css" />

<script src="js/common/require.js" type="text/javascript"></script>
