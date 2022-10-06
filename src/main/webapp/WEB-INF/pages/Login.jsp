<%--
  Created by IntelliJ IDEA.
  User: 33199
  Date: 2019/8/1
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<script type="text/javascript" src="statics/js/jquery-1.10.2.min.js"></script>
<link href="statics/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="statics/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<html lang="en">
<head>
    <style type="text/css">
        .login-box-plain {
            border-radius: 6px;
            padding: 10px 10px 1px;
        }
    </style>
    <title>NHU登录</title>
</head>
<body>
<h3>测试登录</h3>
        <form action="/user/userLogin" method="post">
            用户名:<input type="text" name="username"/><br/>
            密  码:<input type="text" name="userpwd"/><br/>
            <input type="submit" value="登录"/><br/>
        </form>
<div class="error"><c:if test="${errorMsg!=null }"><font color="red">${errorMsg}</font></c:if></div>
</body>
</html>
