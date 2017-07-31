package com.imonkeyz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jesse on 2017/6/15.
 */
@Controller
@RequestMapping(value = "/urlrewrite")
public class URLReWriteController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/news")
    public String test1(@RequestParam String id, ModelMap map) {
        map.addAttribute("id", id);
        return "urlrewrite";
    }
}
