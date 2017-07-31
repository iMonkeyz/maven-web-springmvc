<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <title></title>
        <c:import url="common/header.jsp"/>
    </head>
    <body>
        <div class="container">
            <div class="col-md-8 col-md-offset-2">
                <div class="row"><h1>&nbsp;</h1></div>
                <div class="row">
                    <div class="page-header">
                        <h1>Oops ! Sorry About This...</h1>
                        <h1>You Just Can't Download The Video !</h1>
                    </div>
                </div>
                <div class="row text-right"><a href="${pageContext.request.contextPath}"><i class="glyphicon glyphicon-home"></i> Back To HomePage</a></div>
            </div>
        </div>
    </body>
</html>
