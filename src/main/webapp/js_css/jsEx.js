$(function(){
    $(".aLink").click(function(){
        $.ajax({
            type:"get",
            url:$(this).attr("alt"),
            data:"",
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            success:function(data){
                console.log(data);
                if(data.result){
                    $("#modalTitle").html(data.objValue.name);
                    $("#modalName").html(data.objValue.name);
                    $("#modalImg").attr("src",data.objValue.img);
                    $("#modalYear").html(data.objValue.year);
                    $("#modalStaring").html(data.objValue.staring);
                    $("#modalStatus").html(data.objValue.status);
                    $("#modalArea").html(data.objValue.area);
                    $("#modalType").html(data.objValue.type);
                    $("#modalInfo").html(data.objValue.info);
                    $("#modalScore").html(data.objValue.score);
                    $("#modalLastest").html(data.objValue.lastest);
                    var onlineCount=0;
                    var sHTML="";
                    for(var i=0;i<data.objValue.playList.length;i++){
                        sHTML+="<thead><tr><td><span class='label label-success'>#{"+i+"}在线播放地址</span></td></tr></thead>";
                        var playList=data.objValue.playList[i];
                        onlineCount+=playList.length;
                        for(var j=0;j<playList.length;j++){
                            sHTML=sHTML.replace("\#\{"+i+"\}",playList[j].type);
                            sHTML+="<tr>";
                            if(j+1<playList.length){
                                var displayName=playList[j].displayName;
                                sHTML+="<td><a href='"+playList[j++].url+"'>"+displayName+"</a></td>";
                            }else{
                                sHTML+="<td><a href='"+playList[j].url+"'>"+playList[j].displayName+"</a></td>";
                            }
                            var loop=0
                            while(loop++<2){
                                if(j+1<playList.length){
                                    var displayName=playList[j].displayName;
                                    sHTML+="<td><a href='"+playList[j++].url+"'>"+displayName+"</a></td>";
                                }else{
                                    sHTML+="<td>&nbsp;</td>";
                                }
                            }
                            sHTML+="</tr>";

                        }
                    }
                    if(sHTML==""){
                        sHTML+="<caption class='text-center'><h3>Online Play Not Found !</h3></caption>";
                    }
                    $("#onlineCount").html(onlineCount);
                    $("#onlineTab").empty().append(sHTML);

                    var downloadCount=0;
                    var sHTML="";
                    for(var i=0;i<data.objValue.downloadList.length;i++){
                        downloadCount+=data.objValue.downloadList[i].length;
                        sHTML+="<thead><tr><td><span class='label label-success'>下载地址 "+parseInt(i+1)+"</span></td></tr></thead>";
                        for(var j=0;j<data.objValue.downloadList[i].length;j++){
                            var url=data.objValue.downloadList[i][j];
                            var displayName=url;
                            if(url.indexOf("\|")!=-1){
                                var displayName=url.split("\|")[2];
                            }
                            sHTML+="<tr>" +
                                "<td style='overflow: hidden;text-overflow: ellipsis;'>" +
                                "<a href='"+url+"'>"+decodeURI(displayName)+"</a>" +
                                "</td>" +
                                "</tr>";
                        }
                    }
                    if(sHTML==""){
                        sHTML+="<caption class='text-center'><h3>Download Links Not Found !</h3></caption>";
                    }
                    $("#downloadCount").html(downloadCount);
                    $("#downloadTab").empty().append(sHTML);

                    var sHTML="";
                    for(var i=0;i<data.objValue.skyDrives.length;i++){
                        var obj=data.objValue.skyDrives[i];
                        sHTML+="<tr>" +
                            "<td><a href='"+obj.url+"'>"+(obj.pwd==""?"旋风分享":"百度云盘")+"</a></td>" +
                            "<td class='pwd-content'>"+obj.pwd+"</td>" +
                            "<td class='btn-content text-right'><a class='btn btn-info btn-xs'>Open In New Page</a></td>" +
                            "</tr>";
                    }
                    if(sHTML==""){
                        sHTML+="<caption class='text-center'><h3>SkyDrives Resources Not Found !</h3></caption>";
                    }
                    $("#skydriveCount").html(data.objValue.skyDrives.length);
                    $("#skydriveTab").empty().append(sHTML);

                }else{
                    $("#onlineTab").empty().append("<tr><td>服务器错误:"+data.value+"</td></tr>");
                    $("#downloadTab").empty().append("<tr><td>服务器错误"+data.value+"</td></tr>");
                    $("#skydriveTab").empty().append("<tr><td>服务器错误"+data.value+"</td></tr>");
                }
            }
        });

    });
});