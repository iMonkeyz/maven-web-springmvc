package com.imonkeyz.demo.listener;

import com.imonkeyz.demo.model.Progress;
import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.http.HttpSession;

/**
 * Created by Jesse.Zhou on 2016/4/8 0008.
 */
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;
    private String ms;
    public FileUploadProgressListener() {}

    public FileUploadProgressListener(HttpSession session) {
        this.session = session;
        final Progress process = new Progress();
        session.setAttribute("upload_progress",process);
    }
    public FileUploadProgressListener(HttpSession session,String ms) {
        this.session = session;
        this.ms=ms;
        final Progress process = new Progress();
        //session.setAttribute("upload_progress",process);
        if(ms!=null){
            session.setAttribute(ms,process);
        }
    }

    public void update(long pBytesRead, long pContentLength, int pItems) {
        //final Progress progress = (Progress) session.getAttribute("upload_progress");
        if(ms!=null){
            final Progress progress = (Progress) session.getAttribute(ms);
            progress.setBytesRead(pBytesRead);
            progress.setContentLength(pContentLength);
            progress.setItems(pItems);
            //session.setAttribute("upload_progress",process);
            session.setAttribute(ms,progress);
        }
    }
}
