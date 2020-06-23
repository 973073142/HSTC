package com.pro.entity;

public class Comment {
    private Integer cid;
    
    private Integer sid;

    private Integer uid;

    private Integer uid2;

    
    private String ccontent;

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

    public Integer getUid2() {
        return uid2;
    }

    public void setUid2(Integer uid2) {
        this.uid2 = uid2;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", sid=" + sid + ", uid=" + uid + ", uid2=" + uid2 + ", ccontent=" + ccontent
				+ "]";
	}
    
    
}