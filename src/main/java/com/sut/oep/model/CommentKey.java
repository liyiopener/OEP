package com.sut.oep.model;

import java.util.Date;

public class CommentKey {
    private Integer cid;

    private Integer uid;

    private Integer floor;

    private Integer replyuid;

    private Date time;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getReplyuid() {
        return replyuid;
    }

    public void setReplyuid(Integer replyuid) {
        this.replyuid = replyuid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}