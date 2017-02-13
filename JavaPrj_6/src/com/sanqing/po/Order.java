package com.sanqing.po;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="tb_order")
public class Order {			//������Ϣ��
	@Id @Column(length=10)
	private String orderNO;		//��������
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="customerNO")
	private Customer customer;	//�ͻ�
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="productNO")
	private Product product;	//��Ʒ
	@Column(length=10)
	private int quantity;		//��Ʒ����
	@Temporal(TemporalType.DATE) 
	private Date orderTime;		//������ʱ��
	@Column(length=50)
	private String otherInfo;	//������Ϣ
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
