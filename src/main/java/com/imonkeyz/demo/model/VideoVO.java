package com.imonkeyz.demo.model;

import com.imonkeyz.demo.common.Const;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jesse.Zhou on 2016/1/28 0028.
 */
@Repository
public class VideoVO implements Comparable {

    private String name;
    private String uuid;
    private Long lastModifyLong;

    public VideoVO() {
    }

    public VideoVO(String name, Long lastModifyLong) {
        this.name = name;
        this.lastModifyLong = lastModifyLong;
    }

    public VideoVO(String name, String uuid, Long lastModifyLong) {
        this.name = name;
        this.uuid = uuid;
        this.lastModifyLong = lastModifyLong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getLastModifyLong() {
        return lastModifyLong;
    }

    public void setLastModifyLong(Long lastModifyLong) {
        this.lastModifyLong = lastModifyLong;
    }

    public String getLastModifyTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.getLastModifyLong()));
    }

    public String getLastModifyDays() throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //时间先取整再计算当前时间
        final long lastTime = sdf.parse(sdf.format(new Date(this.getLastModifyLong()))).getTime();
        final long nowTime = sdf.parse(sdf.format(new Date())).getTime();
        final long l = nowTime - lastTime;
        final int days = (int)Math.floor((double) l / (24 * 3600 * 1000L));
        return days>9?"Long Ago":(days==0?"Today":days+" Days Ago");
    }

    public String getDisplayName(){
        return this.getName().substring(0,this.getName().lastIndexOf("."));
    }
    /*public String getPlayURL(){
        return Const.LOCAL_VIDEO_SITE+this.getName();
    }*/

    public int compareTo(Object o) {
        final VideoVO o1 = (VideoVO) o;
        return -this.getLastModifyLong().compareTo(o1.getLastModifyLong());//desc
    }

    @Override
    public String toString() {
        return "VideoVO{" +
                "name='" + name + '\'' +
                "uuid='" + uuid + '\'' +
                ", lastModifyLong=" + lastModifyLong +
                ", lastModifyTime='" + this.getLastModifyTime() + '\'' +
                '}';
    }

    public boolean getIsValid(){
        return true;
    }

}
