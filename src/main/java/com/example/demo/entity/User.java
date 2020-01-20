package com.example.demo.entity;

import java.util.Date;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private String photo;
	private Integer helps;
	private Date create;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getHelps() {
		return helps;
	}
	public void setHelps(Integer helps) {
		this.helps = helps;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", photo="
				+ photo + ", helps=" + helps + ", create=" + create + "]";
	}
	
}
