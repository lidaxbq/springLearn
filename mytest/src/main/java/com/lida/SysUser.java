package com.lida;

public class SysUser implements Comparable<SysUser> {
	private String username;
	private String password;


	public SysUser() {
	}

	public SysUser(String username, String password) {
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "SysUser{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}


	@Override
	public int compareTo(SysUser o) {
		return 0;
	}
}