package com.imonkeyz.demo.controller;

import com.imonkeyz.demo.common.Const;
import com.imonkeyz.demo.common.HResult;
import com.imonkeyz.demo.model.MediaVO;
import com.imonkeyz.demo.service.CaptureService;
import com.imonkeyz.demo.util.EncodingTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesse.Zhou on 2015/12/18 0018.
 */
@Controller
public class CaptureController {

    /*
    public final static String HOST="http://www.xiamp4.com";
    public final static String SID_PREFIX="/Html/GP";
    public final static String SID_SUFFIX=".html";
    public final static String SEARCH_URL="/search.asp?searchword=";
    public final static String SEARCH_PAGE="&searchtype=-1&page=";
    public final static Integer PER_PAGE=16;
    */

    @Autowired
    private CaptureService captureService;

    @RequestMapping(value="/query",method = RequestMethod.GET)
    public String queryByName(@RequestParam(required = false) String searchword,
                               @RequestParam(required = false,defaultValue = "1") String page,
                               @RequestParam(required = false,defaultValue = "0") int searchtype,
                               ModelMap model) {
        if(searchword!=null && !"".equals(searchword)){
            final Map<String, Object> map;
            try {
                map = captureService.queryByName(searchword,page,searchtype);
                final Object pages = map.get("pages");
                model.addAttribute("mediaVOs",map.get("medias"));
                model.addAttribute("pages",map.get("pages"));
                model.addAttribute("totalCount",map.get("totalCount"));
                model.addAttribute("totalPages",map.get("totalPages"));
                model.addAttribute("currentPage",page);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/vod/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public HResult queryBySid(@PathVariable int sid){
        HResult result=new HResult(true);
        try {
            final MediaVO mediaVO = captureService.queryBySid(sid);
            result.setObjValue(mediaVO);
        } catch (IOException e) {
            e.printStackTrace();
            result.setResult(false);
            result.setValue(e.getMessage());
        }
        return result;
    }
}

