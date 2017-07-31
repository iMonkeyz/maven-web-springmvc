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
        <div id="container">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div id="dMain">
                    <div class="starter-template text-center">
                        <h1>Try Input A Movie's Name</h1>
                        <form action="query" method="get">
                            <div class="lead input-group">
                                <span class="input-group-addon">Movie's Name</span>
                                <input type="text" class="form-control text-center up-case" placeholder="What's your favorite Movie ?"  name="searchword" id="searchword"/>
                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i> Go Get Me Something</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <c:if test="${mediaVOs !=null }">
                    <!-- search result -->
                    <div id="dResult">
                        <div class="starter-template text-center">
                            <h1>Search Result</h1>
                            <c:if test="${mediaVOs.size()==0}">
                                <br><h1 class="text-danger">NULL</h1><br/><h1>Try Something Else .</h1>
                            </c:if>
                        </div>
                        <ul class="mlist">
                            <c:forEach items="${mediaVOs }" var="media" varStatus="status">
                                <li>
                                    <div class="col-md-3 text-right">
                                        <a class="p">
                                            <img src="${media.img }">
                                        </a>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="info">
                                            <h5 style="white-space:nowrap;overflow: hidden;text-overflow: ellipsis;">
                                                <span class="label label-primary">${media.year }</span>&nbsp;<a class="aLink" alt="${media.sid }" href="javascript:void(0);" data-toggle="modal" data-target="#myModal"><strong>${media.name }</strong></a>
                                            </h5>
                                            <div style="white-space:nowrap;overflow: hidden;text-overflow: ellipsis;">${media.staring}</div>
                                            <div>${media.status}&nbsp;&nbsp;&nbsp;${media.area}</div><div>${media.type}</div>
                                            <br>
                                            <div>
                                                <span class="label label-success">${media.score }</span>
                                                <span class="label label-danger">${media.lastest }</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    <div class="text-center">
                        <nav>
                            <ul class="pagination">
                                <c:forEach items="${pages}" var="page" varStatus="status">
                                    <li class="${page.displayName == currentPage?'active':''}"><a href="${page.displayName == currentPage?'javascript:void(0);':(page.url == 'query'? 'javascript:void(0);':page.url) }">${page.displayName }</a></li>
                                </c:forEach>
                                <li class="disabled"><a>${totalCount} 条数据 , ${currentPage}/${totalPages} 页</a></li>
                            </ul>
                        </nav>
                    </div>
                </c:if>
                <c:if test="${mediaVOs == null}">
                    <%--<div class="starter-template text-center"><br><h1>There Should Be Something Here</h1><br></div>--%>
                    <c:import url="/local"/>
                </c:if>
            </div>
            <div class="col-md-2"></div>
        </div>
        <div class="clear"></div>
        <%--<c:import url="/local"/>--%>
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
