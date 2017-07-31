<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
<div class="container">
  <div class="col-md-8 col-md-offset-2">
    <hr>
    <div class="starter-template text-center"><br><h1>Videos Cache In Server</h1><br></div>
    <div>
      <ul class="list-group">
        <c:forEach items="${videos}" var="v" varStatus="status">
          <li class="list-group-item">
            <span class="badge">${v.lastModifyTime}</span>
            <a href="${v.playURL}">${v.name}</a>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
--%>
<div class="starter-template text-center">
    <h1>There're Some Videos Cache In Server You May Like</h1>
</div>
<ul class="list-group">
    <c:forEach items="${videos_on}" var="v" varStatus="status">
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-10">
                    <i class="glyphicon glyphicon-time"></i> <span class="">${v.lastModifyTime} </span>
                    &nbsp;&nbsp;&nbsp;
                    <i class="glyphicon glyphicon-film"></i> <a href="${pageContext.request.contextPath}/play/${v.name}">${v.displayName}</a>
                </div>
                <div class="col-md-2 text-right">
                    <c:choose>
                        <c:when test="${v.lastModifyDays eq 'Today'}">
                            <span class="text-danger">
                                <i class="glyphicon glyphicon-fire"></i> <strong>[ ${v.lastModifyDays} ]</strong>
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span class="text-success"><strong>[ ${v.lastModifyDays} ]</strong></span>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${isAdmin}">
                        <a href="${pageContext.request.contextPath}/delete/${v.displayName}"><i class="glyphicon glyphicon-trash"></i></a>
                    </c:if>
                </div>
            </div>
        </li>
    </c:forEach>
</ul>
<c:if test="${isAdmin && fn:length(videos_off)>0 }">
<div class="starter-template text-center">
    <h1>Local Videos Those Has Been Deleted</h1><h4 class="text-danger">[ Administrator Operation Only ]</h4></h1>
</div>
<ul class="list-group">
    <c:forEach items="${videos_off}" var="v" varStatus="status">
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-11">
                    <i class="glyphicon glyphicon-film"></i> <a href="${pageContext.request.contextPath}/play/${v.name}">${v.displayName}</a>
                </div>
                <div class="col-md-1 text-right">
                    <a href="${pageContext.request.contextPath}/restore/${v.name}"><i class="glyphicon glyphicon-transfer"></i></a>
                </div>
            </div>
        </li>
    </c:forEach>
</ul>
</c:if>