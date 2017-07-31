<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="utf-8">
    <title></title>

</head>
<body>
    <h1>用户列表</h1>
    <table>
        <tr><td>&nbsp;</td><td>ID</td><td>Name</td><td>Address</td><td>&nbsp;</td></tr>
        <c:choose>
            <c:when test="${list!=null}">
                <c:forEach items="${list}" var="user" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.address}"/></td>
                        <td><a href="get/${user.id}">查看詳情</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <td>1</td>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td><a href="/mvn/user/all">返回列表</a></td>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>
