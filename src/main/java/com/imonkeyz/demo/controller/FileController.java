package com.imonkeyz.demo.controller;

import com.imonkeyz.demo.common.HResult;
import com.imonkeyz.demo.model.Progress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by Jesse.Zhou on 2016/4/7 0007.
 */
@Controller
public class FileController {

    @RequestMapping(value = "/gotoUploadPage")
    public String gotoUploadPage(){
        return "upload";
    }

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("myfile") CommonsMultipartFile[] files,HttpServletRequest request,ModelMap map){
        if(request.getAttribute("upload_msg")==null) {
            Map<String, String> log = new HashMap<String, String>();
            if (files != null && files.length > 0) {
                for (CommonsMultipartFile file : files) {
                    if (!file.isEmpty()) {
                        saveFile(request, log, file);
                    }
                }
                String msg = log4Display(log);
                map.addAttribute("upload_msg", msg);
            }
        }
        return "upload";
    }

    /**
     * 整理日志
     * @param log
     * @return
     */
    private String log4Display(Map<String, String> log) {
        final Iterator<Map.Entry<String, String>> it = log.entrySet().iterator();
        String msg = "";
        while (it.hasNext()) {
            final Map.Entry<String, String> next = it.next();
            msg += next.getKey() + " -> " + next.getValue() + "<br/>";
        }
        return msg;
    }

    /**
     * 保存文件
     * @param request
     * @param log
     * @param file
     */
    private void saveFile(HttpServletRequest request, Map<String, String> log, CommonsMultipartFile file) {
        final String srcFilename = file.getOriginalFilename();
        final String suffix = srcFilename.substring(srcFilename.lastIndexOf("."));// 取文件格式后
        final String filename = System.currentTimeMillis() + suffix;
        final String path = request.getSession().getServletContext().getRealPath("/files/" + filename);
        String errmsg = null;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            errmsg = e.getMessage();
        }
        log.put(srcFilename, errmsg == null ? filename : errmsg);
    }

    @RequestMapping(value = "/uploadAjax")
    @ResponseBody
    public HResult uploadAjax(@RequestParam("myfile") CommonsMultipartFile[] files, HttpServletRequest request,ModelMap map){
        HResult result=new HResult(true);
        Map<String,String> log=new HashMap<String, String>();
        if(files !=null && files.length>0){
            for (CommonsMultipartFile file : files) {
                if(!file.isEmpty()){
                    saveFile(request,log,file);
                }
            }
        }
        final String msg = log4Display(log);
        result.setObjValue(msg);
        return result;
    }

    @RequestMapping(value = "/uploadProgress/{ms}")
    @ResponseBody
    public HResult processInfo(@PathVariable("ms") String ms, HttpServletRequest request){
        HResult result=new HResult(true);
        final Progress progress = (Progress) request.getSession().getAttribute(ms);
        result.setObjValue(progress);
        if(progress!=null && progress.getPercent().equalsIgnoreCase("100%")){
            request.getSession().removeAttribute(ms);
        }
        return result;
    }

    @RequestMapping(value = "/download/{fileName:.*}")
    public ModelAndView download(@PathVariable("fileName") String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        java.io.BufferedInputStream bis = null;
        java.io.BufferedOutputStream bos = null;

        final String downloadFilePath = request.getSession().getServletContext().getRealPath("/files/" + fileName);
        //System.out.println(downloadFilePath);

        try {

            long fileLength = new File(downloadFilePath).length();
            if(fileLength==0) return null;
            response.setContentType("image/jpeg;");
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downloadFilePath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }


}
