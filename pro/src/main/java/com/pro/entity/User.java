package com.pro.entity;

public class User {
    private Integer uid;

    private String uaccount;

    private String upsw;

    private String uname;

    private String uicon;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount == null ? null : uaccount.trim();
    }

    public String getUpsw() {
        return upsw;
    }

    public void setUpsw(String upsw) {
        this.upsw = upsw == null ? null : upsw.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUicon() {
        return uicon;
    }

    public void setUicon(String uicon) {
        this.uicon = uicon == null ? null : uicon.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uaccount=" + uaccount + ", upsw=" + upsw + ", uname=" + uname + ", uicon="
				+ uicon + "]";
	}
    
}