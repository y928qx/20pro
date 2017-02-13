package com.sanqing.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {
	private Integer userId;			//�û����
	private String username;		//�û���
	private String password;		//����
	private String name;			//����
	private Byte sex;				//�Ա�
	private String address;			//סַ
	private String phone;			//��ϵ�绰
	private String post;			//�ʼĵ�ַ
	private String email;			//Email��ַ
	private Date regTime;			//ע��ʱ��
	private String regIpAddress;	//ע��IP��ַ

	public User() {
	}

	public User(String username, String password, String name, Byte sex,
			String address, String phone, String post, String email,
			Date regTime, String regIpAddress) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.post = post;
		this.email = email;
		this.regTime = regTime;
		this.regIpAddress = regIpAddress;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return this.sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getRegIpAddress() {
		return this.regIpAddress;
	}

	public void setRegIpAddress(String regIpAddress) {
		this.regIpAddress = regIpAddress;
	}

}