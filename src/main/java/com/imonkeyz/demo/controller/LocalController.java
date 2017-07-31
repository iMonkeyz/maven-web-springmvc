package com.imonkeyz.demo.controller;

import com.imonkeyz.demo.common.Const;
import com.imonkeyz.demo.common.HResult;
import com.imonkeyz.demo.model.VideoVO;
import com.imonkeyz.demo.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Jesse.Zhou on 2016/1/28 0028.
 */
@Controller
public class LocalController {

    @Autowired
    private LocalService localService;

    @RequestMapping(value="/local",method = RequestMethod.GET)
    public void queryLocal(@RequestParam(required = false,defaultValue = "true") boolean regenerate,HttpServletRequest request, HttpSession session,ModelMap map){
        if (request.getHeader("x-forwarded-for") == null) {
            map.addAttribute("isAdmin",request.getRemoteAddr().equals("127.0.0.1"));
        }else{
            map.addAttribute("isAdmin", request.getHeader("x-forwarded-for").equals("127.0.0.1"));
        }
        if(regenerate){

            session.setAttribute("videos_on",localService.queryLocalVideos());
            session.setAttribute("videos_off",localService.queryLocalDeletedVideos());
        }
    }

    @RequestMapping(value="/play/{videoName:.*}",method = RequestMethod.GET)
    public String play(@PathVariable String videoName, ModelMap map){
        map.addAttribute("videoName",videoName);
        map.addAttribute("videoSite", Const.LOCAL_VIDEO_SITE);
        return "/player";
    }

    @RequestMapping(value = "/delete/{videoName:.*}",method = RequestMethod.GET)
    public String delete(@PathVariable String videoName){
        return localService.deleteLocalVideo(videoName+".mp4")?"redirect:/":"redirect:/404";
    }

    @RequestMapping(value = "/restore/{videoName:.*}",method = RequestMethod.GET)
    public String restore(@PathVariable String videoName){
        return localService.restoreLocalVideo(videoName)?"redirect:/":"redirect:/404";
    }

    /*
    @RequestMapping(value="/local",method = RequestMethod.GET)
    public void queryLocal(@RequestParam(required = false,defaultValue = "true") boolean regenerate,HttpSession session,ModelMap map){
        if(regenerate){
            List<VideoVO> videos=localService.queryLocalVideos();
            //uuidPlayMap in session
            Map<String,String> uuidPlayMap=new HashMap<String, String>();
            //generate uuid for each video
            for (VideoVO video : videos) {
                video.setUuid(UUID.randomUUID().toString());
                uuidPlayMap.put(video.getUuid(), video.getName());
            }
            session.setAttribute("uuidPlayMap",uuidPlayMap);
            session.setAttribute("videos",videos);
        }
    }

    @RequestMapping(value = "/play/{uuid}",method = RequestMethod.GET)
    public String play(@PathVariable String uuid){
        return "player";
    }

    @RequestMapping(value = "/decryption/{uuid}",method = RequestMethod.GET)
    public String play2(@PathVariable String uuid,
                        @RequestHeader(value = "Referer",required = false,defaultValue = "") String referer,
                        @RequestHeader(value = "Range",required = false,defaultValue = "") String range,
                        HttpSession session,
                        ModelMap map){
        if(referer.equals("") || range.equals("") || !range.startsWith("bytes=")){
            //如果发现uuid请求不符合基本条件,则将该uuid永久失效.
            session.removeAttribute(uuid);
            session.removeAttribute("drag:"+uuid);
            System.out.println("无效请求/拦截下载");
            return "404";
        }
        //播放逻辑
        Map<String,String> uuidPlayMap = session.getAttribute("uuidPlayMap")==null?null: (Map<String, String>) session.getAttribute("uuidPlayMap");
        String videoName = uuidPlayMap==null?null:uuidPlayMap.get(uuid);
        if(videoName!=null){
            //session.removeAttribute(uuid);//已经读取成功的uuid将被清除,防止重复读取
            uuidPlayMap.remove(uuid);
            //session.setAttribute("drag:"+uuid,videoName);//并将该uuid存入后续可拖拽进度列表中
            if(session.getAttribute("uuidDragMap") == null){
                session.setAttribute("uuidDragMap",new HashMap<String, String>());
            }
            Map<String,String> uuidDragMap= (Map<String, String>) session.getAttribute("uuidDragMap");
            uuidDragMap.put(uuid,videoName);
            return "redirect:"+Const.LOCAL_VIDEO_SITE+videoName;
        }
        //拖拽逻辑
        Map<String,String> uuidDragMap = session.getAttribute("uuidDragMap")==null?null: (Map<String, String>) session.getAttribute("uuidDragMap");
        videoName=uuidDragMap.get(uuid)==null?null:uuidDragMap.get(uuid);
        if(videoName!=null){
            return "redirect:"+Const.LOCAL_VIDEO_SITE+videoName;
        }
        return "index"; //session not found ,back to index and regenerate all uuid
    }
    */
}
