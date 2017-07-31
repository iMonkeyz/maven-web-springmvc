package com.imonkeyz.demo.dao.impl;

import com.imonkeyz.demo.dao.UserDAO;
import com.imonkeyz.demo.model.UserVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse.Zhou on 2015/12/17 0017.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    public UserVO findUserById(Integer id) throws Exception {
        String name="Jesse.zhou";
        String address="威尼国际大厦 1546 室";
        return new UserVO(id,name,address);
    }

    public List<UserVO> findAllUser() throws Exception {
        List<UserVO> users=new ArrayList<UserVO>();
        users.add(new UserVO(1,"Tom","广州"));
        users.add(new UserVO(2,"Jack","上海"));
        return users;
    }
}
