package com.imonkeyz.demo.model;

import org.springframework.stereotype.Repository;

/**
 * Created by Jesse.Zhou on 2015/12/21 0021.
 */
@Repository
public class UrlVO {
    private String type;
    private String displayName;
    private String url;
    private String pwd;

    public UrlVO() {}

    public UrlVO(String displayName, String url) {
        this.displayName = displayName;
        this.url = url;
    }

    public UrlVO(String type, String displayName, String url) {
        this.type = type;
        this.displayName = displayName;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UrlVO{" +
                "type='" + type + '\'' +
                ", displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
