package com.imonkeyz.demo.model;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jesse.Zhou on 2015/12/18 0018.
 */
@Repository
public class MediaVO {
    /*
    li.select("a").attr("href");//sid
            li.select("a").attr("title");//片名
            li.select("a>img");//图片
            li.select("a>i");//评分
            li.select("a>em");//画质

            //info
            li.select("div.info>h2>em").html();//年份
            li.select("div.info>em").html();//星级
            final String infoEx = li.select("div.info>p").html();//主演
     */
    private int sid;
    private String name;
    private String img;
    private String score;
    private String quality;
    private String year;
    private String star;
    private String staring;
    private String info;
    private String status;
    private String area;
    private String type;
    private String lastest;
    private List<SkyDriveVO> skyDrives;
    private List<List<UrlVO>> playList;
    private List<List<String>> downloadList;

    public MediaVO() {
    }

    public MediaVO(int sid, String name, String img, String info) {
        this.sid = sid;
        this.name = name;
        this.img = img;
        this.info = info;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<List<String>> getDownloadList() {
        return downloadList;
    }

    public void setDownloadList(List<List<String>> downloadList) {
        this.downloadList = downloadList;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLastest() {
        return lastest;
    }

    public void setLastest(String lastest) {
        this.lastest = lastest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<UrlVO>> getPlayList() {
        return playList;
    }

    public void setPlayList(List<List<UrlVO>> playList) {
        this.playList = playList;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public List<SkyDriveVO> getSkyDrives() {
        return skyDrives;
    }

    public void setSkyDrives(List<SkyDriveVO> skyDrives) {
        this.skyDrives = skyDrives;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getStaring() { return staring; }

    public void setStaring(String staring) { this.staring = staring; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MediaVO{" +
                "area='" + area + '\'' +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", score='" + score + '\'' +
                ", quality='" + quality + '\'' +
                ", year='" + year + '\'' +
                ", star='" + star + '\'' +
                ", info='" + info + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", lastest='" + lastest + '\'' +
                ", skyDrives=" + skyDrives +
                ", playList=" + playList +
                ", downloadList=" + downloadList +
                '}';
    }
}
