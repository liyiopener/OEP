package com.sut.oep.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private Integer uid;

    private String email;

    private String sex;

    private String company;

    private String occupation;

    private String nickname;

    private String passwd;

    private String createTime;

    private Integer role;

    private String img;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", company='" + company + '\'' +
                ", occupation='" + occupation + '\'' +
                ", nickname='" + nickname + '\'' +
                ", passwd='" + passwd + '\'' +
                ", createTime='" + createTime + '\'' +
                ", role=" + role +
                ", img='" + img + '\'' +
                '}';
    }
}