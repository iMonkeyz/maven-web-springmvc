package com.imonkeyz.demo.dao;

import com.imonkeyz.demo.model.UserVO;

import java.util.List;

/**
 * Created by Jesse.Zhou on 2015/12/17 0017.
 */
public interface UserDAO {
    public UserVO findUserById(Integer id) throws Exception;
    public List<UserVO> findAllUser() throws Exception;
}
