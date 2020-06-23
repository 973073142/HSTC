package com.pro.entity;

public class CommentWithUserUname {
	
	private int cid;
	
	private int sid;
	
	private int uid;
	
	private String uname;
	
	private int uid2;
	
	private String uname2;
	
	private String ccontent;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUid2() {
		return uid2;
	}

	public void setUid2(int uid2) {
		this.uid2 = uid2;
	}

	public String getUname2() {
		return uname2;
	}

	public void setUname2(String uname2) {
		this.uname2 = uname2;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	@Override
	public String toString() {
		return "CommentWithUserUname [cid=" + cid + ", sid=" + sid + ", uid=" + uid + ", uname=" + uname + ", uid2="
				+ uid2 + ", uname2=" + uname2 + ", ccontent=" + ccontent + "]";
	}
	
	
	

}
