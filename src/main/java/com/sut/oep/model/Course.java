package com.sut.oep.model;

public class Course {
    private Integer cid;

    private Integer kid;

    private String image;

    private Integer tid;

    private String cname;

    private String createTime;

    private String discri;

    public String getDiscri() {
        return discri;
    }

    public void setDiscri(String discri) {
        this.discri = discri;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", kid=" + kid +
                ", image='" + image + '\'' +
                ", tid=" + tid +
                ", cname='" + cname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", discri='" + discri + '\'' +
                '}';
    }
}