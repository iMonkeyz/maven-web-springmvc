<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Jesse
  Date: 2017/6/15
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>URL Rewrite Page</title>
</head>
<body>
    <ul>
        <li>新闻</li>
        <ul>
            <li><a href="/news/news.html">新闻</a></li>
            <li>
                <c:url value="/news/news.jsp?newsId=1" var="tempNewsUrl"/>
                <a href="${tempNewsUrl}">新闻1</a>
            </li>
            <li>
                <c:url value="/news/news.jsp?newsId=2" var="tempNewsUrl"/>
                <a href="${tempNewsUrl}">新闻2</a>
            </li>
            <li>
                <c:url value="/news/news.jsp?newsId=3" var="tempNewsUrl"/>
                <a href="${tempNewsUrl}">新闻3</a>
            </li>
        </ul>
    </ul>
</body>
</html>
