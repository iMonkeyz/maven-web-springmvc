<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>${message}</h1>
    <span><fmt:formatDate value="<%=new Date()%>" type="both" pattern="yyyy年MM月dd日 hh小时mm分钟ss秒" /></span>
    <br>
    <a href="all">查看用戶列表</a>
</body>
</html>
