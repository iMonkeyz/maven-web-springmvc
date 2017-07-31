package com.imonkeyz.demo.model;

import org.springframework.stereotype.Component;

/**
 * Created by Jesse.Zhou on 2015/12/17 0017.
 */
@Component
public class UserVO {
    private Integer id;
    private String name;
    private String address;

    public UserVO() {
    }

    public UserVO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
