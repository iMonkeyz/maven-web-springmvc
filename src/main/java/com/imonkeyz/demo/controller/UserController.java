package com.imonkeyz.demo.controller;

import com.imonkeyz.demo.dao.UserDAO;
import com.imonkeyz.demo.model.CartEntryData;
import com.imonkeyz.demo.model.UserVO;
import com.imonkeyz.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jesse.Zhou on 2015/12/15 0015.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/welcome",method = RequestMethod.GET)
    public String welcome(ModelMap model){
        model.addAttribute("message","Welcome to MAVEN SpringMVC Demo");
        return "welcome";
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable Integer id,ModelMap model){
        model.addAttribute("user",userService.getUserById(id));
        return "list";
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String getAll(ModelMap model){
        model.addAttribute("list",userService.getAllUser());
        return "list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody List<UserVO> users) {
        for (UserVO user : users) {
            System.out.println(user.toString());
        }
    }

    @RequestMapping(value="/updateQuantityBatch", method = { RequestMethod.POST, RequestMethod.GET })
    public void updateQuantityBatch (@RequestBody final List<CartEntryData> cartEntryDatas) {
        for (CartEntryData cartEntryData : cartEntryDatas)
        {
            System.out.println(cartEntryData.toString());
        }
    }
}
