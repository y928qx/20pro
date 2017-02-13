package com.sanqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity @Table(name="tb_customer")
public class Customer {			//�ͻ���Ϣ��
	@Id @Column(length=20)
	private String customerNO;	//�ͻ����
	@Column(length=15)
	private String customerName;//�ͻ�����
	@Column(length=15)
	private String phone;		//�ͻ��绰
	@Column(length=30)
	private String address;		//�ͻ���ַ
	@Column(length=15)
	private String relationman;	//�ͻ���ϵ��
	@Column(length=30)
	private String otherInfo;	//������Ϣ
	public Customer(){}
	public Customer(String customerNO) {
		this.customerNO = customerNO;
	}
	public String getCustomerNO() {
		return customerNO;
	}
	public void setCustomerNO(String customerNO) {
		this.customerNO = customerNO;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRelationman() {
		return relationman;
	}
	public void setRelationman(String relationman) {
		this.relationman = relationman;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
