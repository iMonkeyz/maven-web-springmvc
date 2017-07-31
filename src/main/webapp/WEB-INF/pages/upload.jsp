<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <title>File Upload</title>
        <c:import url="common/header.jsp"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js_css/plugins/ajaxfileupload.js"></script>
        <script type="text/javascript">
            var oTimer=null;
            function getProgress(ms){
                $.get("${pageContext.request.contextPath}/uploadProgress/"+ms,function(data){
                    if(data.result){
                        var percent=data.objValue.percent;
                        $("#upload_progress").attr("aria-valuenow",parseFloat(percent)).css("width",percent);
                        $("#upload_progress_text").html(percent);
                        if(parseInt(percent)==100){
                            window.clearInterval(oTimer);
                            //$("#upload_progress").attr("aria-valuenow",100).css("width","100%");
                            //$("#upload_progress_text").html("100%");
                        }
                    }
                    //"Progress{bytesRead=12812288, mbRead='12.81', contentLength=12850299, items=1, percent='99.7%', speed='2578.44', startReadTime=1460105923832}"
                });
                /*
                $.ajax({
                    type:"GET",
                    dataType:"json",
                    url:"${pageContext.request.contextPath}/uploadProgress",
                    data:new Date().getTime(),
                    success:function(data,status){
                        back=data;
                        //console.log(data);
                    },
                    error:function(err,status){
                        console.log(err);
                    }
                });
                */
            }

            function ajaxFileUpload(){
                var ms=new Date().getTime();
                oTimer = setInterval("getProgress("+ms+")", 1000);
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/uploadAjax?ms="+ms,
                    secureuri:false,
                    fileElementId:"myfile",
                    type:"POST",
                    dataType:"text",
                    success: function (data,status){
                        $("#result1").html(data);
                    },
                    error: function (data,status){
                        alert(data);
                    }
                });
            }

            $(function(){
                $("img").click(function(){
                    window.location="${pageContext.request.contextPath}/download/"+$(this).attr("alt");
                });
            });
        </script>
    </head>
    <body>
        <div class="container">

            <div class="row">
                <h1>Common File Upload</h1>
                <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="ms"/>
                    File to Upload:<br/>
                    File1 -> <input type="file" name="myfile"><br/>
                    File2 -> <input type="file" name="myfile"><br/>
                    &nbsp;<input type="submit" value="upload">
                </form>
                <pre id="result"></pre>
                <script>
                    $(function(){
                        $("#result").html("${upload_msg }");
                    });
                </script>
            </div>
            <div class="row">
                <h1>Ajax File Upload</h1>
                File to Upload:<br/>
                File1 -> <input type="file" name="myfile" id="myfile"><br/>
                <input type="button" value="upload" onclick="ajaxFileUpload();"/>

                <div id="result1">123</div>
                <div class="progress">
                    <div id="upload_progress" class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                        <span id="upload_progress_text"></span><span class="sr-only">20% Complete</span>
                    </div>
                </div>

                <div class="progress">
                    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                        <span class="sr-only">100% Complete</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <img src="${pageContext.request.contextPath}/files/1460448990281.jpg" alt="1460448990281.jpg" width="200" height="120"/>
                <img src="${pageContext.request.contextPath}/files/1460448990281_thumbnails.jpg" alt="1460448990281_thumbnails.jpg" width="200" height="120"/>
                <img src="${pageContext.request.contextPath}/files/1460448968892.jpg" alt="1460448968892.jpg" width="200" height="120"/>
                <img src="${pageContext.request.contextPath}/files/1460448986088.jpg" alt="1460448986088.jpg" width="200" height="120"/>
                <a href="${pageContext.request.contextPath}/download/1460431348108.exe">01-war3_v1.20e_52pk.exe</a>
                <a href="${pageContext.request.contextPath}/download/1460429390243.exe">JDK1.X.exe</a>
            </div>
        </div>
    </body>
</html>
