package com.smhrd.myapp.domain;

public class WebMember {
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	public WebMember(String email, String pw, String tel, String address) {
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	

	public WebMember(String email, String pw) {
		
		this.email = email;
		this.pw = pw;
	}


	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}
	
	
	
	
}
