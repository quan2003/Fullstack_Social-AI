package com.viuniteam.socialviuni.entity;

import java.util.List;

public class jwtInfo {
	 String token;
	  List<String> role;
	  String username;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> roles) {
		this.role = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
