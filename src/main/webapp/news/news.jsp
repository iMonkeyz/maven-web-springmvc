<%--
  Created by IntelliJ IDEA.
  User: Jesse
  Date: 2017/6/15
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String newsId=request.getParameter("newsId"); %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻</title>
</head>
<body>
    本条新闻id为 ：<%="news".equals(newsId)?"空值，因为您访问的是静态页面news.html":newsId %>

</body>
</html>
