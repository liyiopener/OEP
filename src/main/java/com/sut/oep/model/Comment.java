package com.sut.oep.model;

public class Comment {
    private Integer commentid;

    private Integer cid;

    private Integer classid;

    private Integer uid;

    private String time;

    private Integer floor;

    private Integer replyuid;

    private String content;

    private User user;

    private Course course;

    private Class aClass;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", cid=" + cid +
                ", classid=" + classid +
                ", uid=" + uid +
                ", time='" + time + '\'' +
                ", floor=" + floor +
                ", replyuid=" + replyuid +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", course=" + course +
                ", aClass=" + aClass +
                '}';
    }
}