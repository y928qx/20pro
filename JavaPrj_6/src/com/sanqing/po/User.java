package com.sanqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="tb_user")
public class User {				//�û���Ϣ��
	@Id @Column(length=18)
	private String username;	//�û���
	@Column(length=18)
	private String password;	//�û�����
	@Column
	private int grade;			//�û�����
	
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
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
