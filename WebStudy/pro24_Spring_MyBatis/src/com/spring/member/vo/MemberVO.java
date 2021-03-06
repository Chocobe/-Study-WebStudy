package com.spring.member.vo;

import java.time.LocalDate;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private LocalDate joinDate;
	
	public MemberVO() { }
	
	public MemberVO(String id, 
					String pwd, 
					String name, 
					String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	public MemberVO(String id, 
					String pwd, 
					String name, 
					String email, 
					LocalDate joinDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}

	
// id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
// pwd
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
// email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
// joinDate
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
}
