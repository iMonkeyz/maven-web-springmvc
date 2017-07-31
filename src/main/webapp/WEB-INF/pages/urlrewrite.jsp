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
<html>
<head>
    <title>URL Rewrite Page</title>
</head>
<body>
    Your parameter id is ${id}.
    <br>
    <c:url var="url" value="/urlrewrite/news?id=${id}"/>
    <a href="${url}">Try JSTL Tag: ${url}</a>
</body>
</html>
