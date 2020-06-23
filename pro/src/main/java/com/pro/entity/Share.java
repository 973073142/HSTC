package com.pro.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Share {
    private Integer sid;

    private Integer uid;

    private String stitle;

    private String scontent;

    private String simg1;

    private String simg2;

    private String simg3;

    private String simg4;

    private String simg5;

    private String simg6;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;

    private Integer slike;

    private Integer scollect;
    /**
     *    	多表查询
     */
    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle == null ? null : stitle.trim();
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent == null ? null : scontent.trim();
    }

    public String getSimg1() {
        return simg1;
    }

    public void setSimg1(String simg1) {
        this.simg1 = simg1 == null ? null : simg1.trim();
    }

    public String getSimg2() {
        return simg2;
    }

    public void setSimg2(String simg2) {
        this.simg2 = simg2 == null ? null : simg2.trim();
    }

    public String getSimg3() {
        return simg3;
    }

    public void setSimg3(String simg3) {
        this.simg3 = simg3 == null ? null : simg3.trim();
    }

    public String getSimg4() {
        return simg4;
    }

    public void setSimg4(String simg4) {
        this.simg4 = simg4 == null ? null : simg4.trim();
    }

    public String getSimg5() {
        return simg5;
    }

    public void setSimg5(String simg5) {
        this.simg5 = simg5 == null ? null : simg5.trim();
    }

    public String getSimg6() {
        return simg6;
    }

    public void setSimg6(String simg6) {
        this.simg6 = simg6 == null ? null : simg6.trim();
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Integer getSlike() {
        return slike;
    }

    public void setSlike(Integer slike) {
        this.slike = slike;
    }

    public Integer getScollect() {
        return scollect;
    }

    public void setScollect(Integer scollect) {
        this.scollect = scollect;
    }

	@Override
	public String toString() {
		return "Share [sid=" + sid + ", uid=" + uid + ", stitle=" + stitle + ", scontent=" + scontent + ", simg1="
				+ simg1 + ", simg2=" + simg2 + ", simg3=" + simg3 + ", simg4=" + simg4 + ", simg5=" + simg5 + ", simg6="
				+ simg6 + ", sdate=" + sdate + ", slike=" + slike + ", scollect=" + scollect + ", user=" + user + "]";
	}
    
}