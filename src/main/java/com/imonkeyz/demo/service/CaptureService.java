package com.imonkeyz.demo.service;

import com.imonkeyz.demo.common.Const;
import com.imonkeyz.demo.controller.CaptureController;
import com.imonkeyz.demo.model.MediaVO;
import com.imonkeyz.demo.model.SkyDriveVO;
import com.imonkeyz.demo.model.UrlVO;
import com.imonkeyz.demo.util.EncodingTool;
import com.imonkeyz.demo.util.HttpClientTool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesse.Zhou on 2015/12/18 0018.
 */
@Service
public class CaptureService {
    /**
     * 按SID查找影片信息,返回结果唯一
     * @param sid 影片唯一ID
     * @return
     * @throws IOException
     */
    public MediaVO queryBySid(int sid) throws IOException {
        String url=Const.HOST + Const.SID_PREFIX + sid + Const.SID_SUFFIX;
        final Document document = HttpClientTool.getHtmlDocument(url);
        final Elements infoEx = document.select("div#main>div.view>div.info");
        //final int sid = Integer.parseInt(document.select("div#SOHUCS").get(0).attr("sid"));//id
        final String img = document.select("div.pic>img").get(0).attr("src");//img
        final String name = infoEx.select("h1").get(0).text();//片名
        final String info = "剧情介绍："+document.select("div.endtext").text();
        MediaVO media=new MediaVO(sid,name,img,info);
        for (Element li : infoEx.select("ul>li")) {
            final String line = li.text().replaceAll(Jsoup.parse("&nbsp;").text(),"");
            if(line.startsWith("上映年代：")){
                if(line.contains("状态：")){
                    String year=line.substring(0, line.indexOf("状态："));
                    String status = line.substring(line.indexOf("状态："));
                    media.setYear(year);
                    media.setStatus(status);
                }
            }
            if(line.startsWith("类型：")){
                media.setType(line);
            }
            if(line.startsWith("主演：")){
                media.setStaring(line);
            }
            if(line.startsWith("地区：")){
                media.setArea(line);
            }
            if(line.startsWith("更新日期：")){
                media.setLastest(line);
            }
        }
        //final String score = HttpClientTool.getHtmlDocument("http://www.xiamp4.com/inc/ajax.asp?id=" + sid + "&action=videoscore&timestamp=1450678380468").text();
        //media.setScore(score);
        media.setQuality(name);//详细页面的name和quality是一样的.

        final Elements skyDrives = document.select("div.skydrive>ul>li>a");//云盘
        final Elements playList = document.select("div.mox");//在线
        final Elements downloadList = document.select("script");//下载

        media.setSkyDrives(parseSkyDrives(skyDrives));
        media.setPlayList(parsePlayList(playList));
        media.setDownloadList(parseDownloadList(downloadList));
        return media;
    }

    /**
     * 按NAME查找影片信息,返回结果集
     * @param searchword 搜索片名
     * @param page 跳转页
     * @return
     * @throws IOException
     */
    public Map<String,Object> queryByName(String searchword,String page,int searchtype) throws IOException {
        //searchword= URLEncoder.encode(EncodingTool.encodeStr(searchword), "GB2312");
        searchword= URLEncoder.encode(searchword, "GB2312");//远程服务器搜索中文需要编码为 gb2312
        String url= Const.HOST+Const.SEARCH_URL+searchword;//"http://www.xiamp4.com"+"/search.asp?searchword="+name
        if(page!=null&&!page.isEmpty()){
            url+=Const.SEARCH_PAGE+page;//"&searchtype=-1&page="+page;
        }
        final Document document = HttpClientTool.getHtmlDocument(url);

        Map<String,Object> map=new HashMap<String, Object>();
        List<MediaVO> medias=new ArrayList<MediaVO>();
        List<UrlVO> pages=new ArrayList<UrlVO>();
        //影片列表
        for (Element li : document.select("ul.mlist>li")) {
            MediaVO media=new MediaVO();
            final int sid = Integer.parseInt(li.select("a").attr("href").replaceAll(Const.HOST, "").replaceAll(Const.SID_PREFIX, "").replaceAll(Const.SID_SUFFIX, ""));//sid
            final String name = li.select("a").attr("title");//片名
            final String img = li.select("a>img").attr("src");//图片
            final String score = li.select("a>i").text().replaceAll("\\s", "");//评分
            final String quality = li.select("a>em").text();//画质
            //info
            final String year = li.select("div.info>h2>em").text();//年份
            final String star = li.select("div.info>em").text();//星级
            //
            final Elements infos = li.select("div.info>p");//信息
            for (Element info : infos) {
                if(info.text().startsWith("主演：")){
                    media.setStaring(info.text());
                }
                for (Element i : info.select("i")) {
                    if(i.text().startsWith("状态：")){
                        media.setStatus(i.text());
                    }
                    if(i.text().startsWith("地区：")){
                        media.setArea(i.text());
                    }
                    if(i.text().startsWith("类型：")){
                        media.setType(i.text());
                    }
                    if(i.text().startsWith("更新：")){
                        media.setLastest(i.text());
                    }
                }
            }

            media.setSid(sid);
            media.setName(name);
            media.setImg(img);
            media.setScore(score);
            media.setQuality(quality);
            media.setYear(year);
            media.setStar(star);

            medias.add(media);
        }
        //获取分页
        final int totalCount = Integer.parseInt(document.select("div.movielist>div.pagepre>p>span").text());
        final int totalPages = (int) Math.ceil((double) totalCount / Const.PER_PAGE);
        for(Element a : document.select("div#pages>a")){
            pages.add(new UrlVO(a.text(),"query"+URLDecoder.decode(a.attr("href"),"gb2312")));
        }
        map.put("medias",medias);
        map.put("pages",pages);
        map.put("totalCount",totalCount);
        map.put("totalPages",totalPages);
        return map;
    }

    /**
     * 解析在线播放地址
     * @param playList
     * @return
     */
    private List<List<UrlVO>> parsePlayList(Elements playList) {
        List<List<UrlVO>> list=new ArrayList<List<UrlVO>>();
        for (Element play : playList) {
            final Elements node = play.select("div.play-list");
            if(node!=null&&node.size()>0){
                List<UrlVO> l=new ArrayList<UrlVO>();
                for (Element a : play.select("div.play-list>a")) {
                    l.add(new UrlVO(play.select("div.title>span").get(0).text(),a.attr("title"),Const.HOST+a.attr("href")));
                }
                list.add(l);
            }
        }
        return list;
    }

    /**
     * 解析下载地址
     * @param downloadList
     * @return
     */
    private List<List<String>> parseDownloadList(Elements downloadList) {
        List<List<String>> list= new ArrayList<List<String>>();
        for (Element dl : downloadList) {
            if(dl.html().startsWith("var GvodUrls")){
                final String[] splited = dl.html().split("###");
                List<String> l=new ArrayList<String>();
                for (String s : splited) {
                    String url=s.replaceAll("var GvodUrls = \"","").replaceAll("\";", "");
                    l.add(url);
                }
                list.add(l);
            }
        }
        return list;
    }

    /**
     * 解析云盘地址
     * @param skyDrives
     * @return
     */
    private List<SkyDriveVO> parseSkyDrives(Elements skyDrives){
        List<SkyDriveVO> list=new ArrayList<SkyDriveVO>();
        for (Element skyDrive : skyDrives) {
            String skyURL = skyDrive.attr("href");
            String password=skyDrive.attr("href").startsWith("http://pan.baidu.com")?skyDrive.html():"";
            list.add(new SkyDriveVO(skyURL,password));
        }
        return list;
    }

}
