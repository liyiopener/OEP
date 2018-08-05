package com.sut.oep.model;

public class Class {
    private Integer classid;

    private Integer cid;

    private String vedeo;

    private String title;

    private String refreshTime;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getVedeo() {
        return vedeo;
    }

    public void setVedeo(String vedeo) {
        this.vedeo = vedeo == null ? null : vedeo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime == null ? null : refreshTime.trim();
    }

    @Override
    public String toString() {
        return "Class{" +
                "classid=" + classid +
                ", cid=" + cid +
                ", vedeo='" + vedeo + '\'' +
                ", title='" + title + '\'' +
                ", refreshTime='" + refreshTime + '\'' +
                '}';
    }
}