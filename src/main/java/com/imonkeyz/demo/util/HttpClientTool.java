package com.imonkeyz.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jesse.Zhou on 2015/12/18 0018.
 */
public class HttpClientTool {
    /**
     * 获取网页源码并返回可解析document对象
     * @param url
     * @return
     * @throws IOException 解析出错
     */
    public static Document getHtmlDocument(String url) throws IOException {
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        final HttpGet httpGet=new HttpGet(url);
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");//simulate browser's action
        final CloseableHttpResponse response = httpClient.execute(httpGet);
        Document document=null;
        if(response.getStatusLine().getStatusCode()==200){
            final HttpEntity entity = response.getEntity();
            final String responseBody = EntityUtils.toString(entity, "GBK");
            if(!responseBody.isEmpty()){
                document=Jsoup.parse(responseBody.replaceAll("&nbsp;"," "));
            }
        }
        httpClient.close();
        return document;
    }

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
        final String encode = URLEncoder.encode("中国", "GB2312");
        System.out.println(encode);
        System.out.println((int)Math.ceil((double)88/16));
    }
}
