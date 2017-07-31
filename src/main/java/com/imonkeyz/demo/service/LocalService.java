package com.imonkeyz.demo.service;

import com.imonkeyz.demo.common.Const;
import com.imonkeyz.demo.model.VideoVO;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileFilter;
import java.util.*;

/**
 * Created by Jesse.Zhou on 2016/1/28 0028.
 */
@Service
public class LocalService {

    /**
     * 查找本地指定 {path} 下的所有*.mp4(h5支持在线播放)的视频
     * @return
     */
    public List<VideoVO> queryLocalVideos() {
        return findLocalVideosBySuffix(".mp4");
    }

    public List<VideoVO> queryLocalDeletedVideos() {
        return findLocalVideosBySuffix(".deleted");
    }

    private List<VideoVO> findLocalVideosBySuffix(final String suffix){
        final File file = new File(Const.LOCAL_VIDEO_PATH);
        final File[] files = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(suffix);
            }
        });
        final List<VideoVO> videos=new ArrayList<VideoVO>();
        for (File f : files) {
            videos.add(new VideoVO(f.getName(),f.lastModified()));
        }
        Collections.sort(videos);
        return videos;
    }

    public boolean deleteLocalVideo(String filename){
        final File file = new File(Const.LOCAL_VIDEO_PATH + filename);
        if(file.exists()){
            final File dstFile = new File(Const.LOCAL_VIDEO_PATH + filename + ".deleted");
            return file.renameTo(dstFile);
        }
        return false;
    }

    public boolean restoreLocalVideo(String filename) {
        final File file = new File(Const.LOCAL_VIDEO_PATH + filename);
        if(file.exists()){
            final File dstFile = new File(Const.LOCAL_VIDEO_PATH + filename.substring(0, filename.lastIndexOf(".deleted")));
            return file.renameTo(dstFile);
        }
        return false;
    }
}
