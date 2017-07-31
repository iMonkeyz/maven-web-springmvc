package com.imonkeyz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jesse.Zhou on 2016/2/2 0002.
 */
@Controller
public class HomepageController {

    @RequestMapping(value = "/")
    public String redirect2Homepage(){
        return "index";
    }
}
