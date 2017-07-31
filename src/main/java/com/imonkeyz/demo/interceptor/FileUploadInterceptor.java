package com.imonkeyz.demo.interceptor;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Jesse.Zhou on 2016/4/7 0007.
 */
public class FileUploadInterceptor implements HandlerInterceptor {
    private long maxSize;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request!=null && ServletFileUpload.isMultipartContent(request)) {
            //ServletRequestContext ctx = new ServletRequestContext(request);
            Map<String, String> result = new HashMap<String, String>();
            final Iterator<Map.Entry<String, List<MultipartFile>>> iterator = ((DefaultMultipartHttpServletRequest) request).getMultiFileMap().entrySet().iterator();
            while(iterator.hasNext()){
                final Map.Entry<String, List<MultipartFile>> next = iterator.next();
                final List<MultipartFile> files = next.getValue();
                for (MultipartFile file : files) {
                    final long size = file.getSize();
                    if(file.getSize()>maxSize){
                        result.put(file.getOriginalFilename(),file.getSize()+" 文件超限制");
                    }
                }
            }
            if(result.size()>0){
                final Iterator<Map.Entry<String, String>> it = result.entrySet().iterator();
                String msg = "";
                while (it.hasNext()) {
                    final Map.Entry<String, String> next = it.next();
                    msg += next.getKey() + " -> " + next.getValue() + "<br/>";
                }
                request.setAttribute("upload_msg", msg);
            }
            /*long requestSize = ctx.contentLength();
            if (requestSize > maxSize) {
                //throw new MaxUploadSizeExceededException(maxSize);
                request.setAttribute("upload_msg","文件大小超限!");
            }*/
        }
        return true;
    }

    private String getFileKB(long byteFile){
        if(byteFile==0)
            return "0KB";
        long kb=1024;
        return ""+byteFile/kb+"KB";
    }
    private String getFileMB(long byteFile){
        if(byteFile==0)
            return "0MB";
        long mb=1024*1024;
        return ""+byteFile/mb+"MB";
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}