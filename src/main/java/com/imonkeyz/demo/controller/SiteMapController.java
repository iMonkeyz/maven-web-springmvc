package com.imonkeyz.demo.controller;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Jesse on 2017/4/24.
 */
@Controller
public class SiteMapController {

    @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
    public void generateSiteMapCatalog(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/xml;charset=utf-8");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        String fileName = "D:/u01/hybris/bin/custom/ext/pns/ecommerce/pnsstorefront/web/webroot/sitemap.xml";
        Document doc = DocumentHelper.parseText(readFileByLines(new File(fileName)));

        XMLWriter writer = new XMLWriter(response.getOutputStream(), format);
        writer.write(doc);
        writer.close();

    }


    @RequestMapping(value = "/sitemap/{fileName:.*}")
    public void generateSiteMapFile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/xml;charset=utf-8");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        File file = new File("D:/u01/hybris/bin/custom/ext/pns/ecommerce/pnsstorefront/web/webroot/sitemap/" + fileName);
        try {
            if ( file.exists() ) {
                String text = readFileByLines(file);
                Document doc = DocumentHelper.parseText(text);
                XMLWriter writer = new XMLWriter(response.getOutputStream(), format);
                writer.write(doc);
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{fileName}.rss")
    public void getRss(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request filename: " + fileName);
    }


    public String readFileByLines(File file) throws Exception {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                sb.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }

}
