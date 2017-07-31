<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>Welcome To Imonkeyz's Lab</title>
        <c:import url="common/header.jsp"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Movie Download URL Capturer 1.0</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/gotoUploadPage">Upload</a></li>
                        <li><a href="/hybris">Hybris Project Toolkit</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <h1>&nbsp;</h1>
        <div class="container">
            server error.
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <hr>
                    <footer class="footer text-right">
                        <p>&copy; By iMonkeyz</p>
                    </footer>
                </div>
                <c:import url="common/modal.jsp"/>
            </div>
        </div>
    </body>
</html>
