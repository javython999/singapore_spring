package com.myspring.vo;

import java.util.Date;

public class BoardVO {
	private int id;
	private String nickname;
	private Date regdate;
	private String content;
	private String star;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", nickname=" + nickname + ", regdate=" + regdate + ", content=" + content
				+ ", star=" + star + "]";
	}
	
	
	
	
}
