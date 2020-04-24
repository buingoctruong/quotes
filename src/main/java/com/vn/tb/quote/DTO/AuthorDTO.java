package com.vn.tb.quote.DTO;

public class AuthorDTO {
	public String name;
	public String nickName;
	public String avatar;
	public int numQuotes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getNumQuotes() {
		return numQuotes;
	}
	public void setNumQuotes(int numQuotes) {
		this.numQuotes = numQuotes;
	}
}
