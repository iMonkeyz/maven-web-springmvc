package com.imonkeyz.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Jesse.Zhou on 2016/5/23 0023.
 */
@Controller
public class ResourceController {

    private Map<String,Map<String,List<String>>> allowUrls;


    @RequestMapping(value = "/json")
    public void json(){
        System.out.println(allowUrls);
    }

    public void setAllowUrls(Map<String, Map<String, List<String>>> allowUrls) {
        this.allowUrls = allowUrls;
    }
}
