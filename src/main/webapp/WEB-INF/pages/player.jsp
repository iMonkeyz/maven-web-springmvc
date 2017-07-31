<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta name="content-type" content="text/html;charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${videoName}</title>
        <c:import url="common/header.jsp"/>
        <link href="${pageContext.request.contextPath}/js_css/video5/css/video-js.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js_css/video5/js/video.min.js"></script>
    </head>
    <body style="background-color: rgb(0, 0, 0);">
        <div class="container">
            <div class="row text-center">
                <a href="${pageContext.request.contextPath}"><i class="glyphicon glyphicon-home"></i> Back To HomePage</a>
                <h4 style="color: white;font-family: '微软雅黑','Helvetica Neue', Helvetica, Arial, sans-serif">
                    <i class="glyphicon glyphicon-film"></i> ${videoName}
                </h4>
            </div>
            <div class="row">
                <table border="0" style="width: 100%;">
                    <tr>
                        <td align="center" >
                            <video id="really-cool-video"
                                   class="video-js vjs-default-skin"
                                   controls preload="auto"
                                   data-setup='{"controls":true,"autoplay":true}'
                                   width="1024px" height="576px">
                                <source src="${videoSite}${videoName}" type='video/mp4' />
                                <p class="vjs-no-js">
                                    To view this video please enable JavaScript, and consider upgrading to a web browser
                                    that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
                                </p>
                            </video>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="row">
                <hr/>
            </div>
            <div class="row">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <i id="collapseIco" class="glyphicon glyphicon-plus"></i>
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" id="collapseOneTrigger">
                                    Click Here For More Videos
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse">
                            <div class="panel-body">
                                <c:import url="/local?regenerate=false"/>
                            </div>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    var isExpand=false;
                    $(function(){
                        //collapseOneTrigger
                        $("#collapseOneTrigger").click(function(){
                            if(isExpand){
                                $("#collapseIco").removeClass("glyphicon-minus").addClass("glyphicon-plus");
                            }else{
                                $("#collapseIco").removeClass("glyphicon-plus").addClass("glyphicon-minus");
                            }
                            isExpand=!isExpand;
                        });
                    });
                    //$(function () { $('#collapseOne').collapse('hide')});
                </script>
                <%--<c:import url="/local"/>--%>
            </div>
        </div>


    </body>
</html>
