package com.sut.oep.model;

public class Kinds {
    private Integer kid;

    private String kinfo;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKinfo() {
        return kinfo;
    }

    public void setKinfo(String kinfo) {
        this.kinfo = kinfo == null ? null : kinfo.trim();
    }
}