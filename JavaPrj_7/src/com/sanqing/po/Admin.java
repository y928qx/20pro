package com.sanqing.po;

public class Admin implements java.io.Serializable { // ����Ա��Ϣʵ����
	private Integer adminId;						//����Ա���
	private String username;						//����Ա�û���
	private String password;						//����Ա����

	public Admin() {
	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}