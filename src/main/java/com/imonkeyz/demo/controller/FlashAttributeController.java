package com.imonkeyz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jesse on 2017/6/13.
 */
@Controller
public class FlashAttributeController {

    @RequestMapping(value = "/method1")
    public String method1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("rdv","this is a flash attribute");
        redirectAttributes.addAttribute("rdv2","this is a flash attribute 2");
        return "redirect:/method2";
    }

    @RequestMapping(value = "/method2")
    public String method2(HttpServletRequest request, ModelMap map){
        String rdv = request.getParameter("rdv");
        String rdv2 = request.getParameter("rdv2");
        System.out.println(rdv);
        System.out.println(rdv2);
        return "index";
    }
}
