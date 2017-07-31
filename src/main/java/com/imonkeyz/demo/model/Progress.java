package com.imonkeyz.demo.model;

import com.imonkeyz.demo.util.NumUtil;
import org.springframework.stereotype.Repository;

/**
 * Created by Jesse.Zhou on 2016/4/8 0008.
 */
@Repository
public class Progress {
    private long bytesRead = 0L;
    private String mbRead = "0";
    private long contentLength = 0L;
    private int items;
    private String percent;
    private String speed;
    private long startReadTime = System.currentTimeMillis();

    public Progress() {
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public String getMbRead() {
        mbRead = NumUtil.divideNumber(bytesRead, 1000000);
        return mbRead;
    }

    public void setMbRead(String mbRead) {
        this.mbRead = mbRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getPercent() {
        percent= NumUtil.getPercent(bytesRead,contentLength);
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getSpeed() {
        speed=NumUtil.divideNumber(NumUtil.divideNumber(bytesRead * 1000, System.currentTimeMillis()- startReadTime),1000);
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public long getStartReadTime() {
        return startReadTime;
    }

    public void setStartReadTime(long startReadTime) {
        this.startReadTime = startReadTime;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "bytesRead=" + bytesRead +
                ", mbRead='" + this.getMbRead() + '\'' +
                ", contentLength=" + contentLength +
                ", items=" + items +
                ", percent='" + this.getPercent() + '\'' +
                ", speed='" + this.getSpeed() + '\'' +
                ", startReadTime=" + startReadTime +
                '}';
    }
}
