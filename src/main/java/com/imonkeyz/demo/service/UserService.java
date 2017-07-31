package com.imonkeyz.demo.service;

import com.imonkeyz.demo.dao.UserDAO;
import com.imonkeyz.demo.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jesse.Zhou on 2015/12/17 0017.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserVO getUserById(Integer id){
        try {
            return userDAO.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserVO> getAllUser(){
        try {
            return userDAO.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
