package com.imonkeyz.demo.model;

import org.springframework.stereotype.Repository;

/**
 * Created by Jesse.Zhou on 2015/12/18 0018.
 */
@Repository
public class SkyDriveVO {
    private String url;
    private String pwd;

    public SkyDriveVO() {
    }

    public SkyDriveVO(String url, String pwd) {
        this.url = url;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SkyDriveVO{" +
                "pwd='" + pwd + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
