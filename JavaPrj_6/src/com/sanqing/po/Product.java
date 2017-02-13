package com.sanqing.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="tb_product")
public class Product {				//��Ʒ��Ϣ��
	@Id @Column(length=15)
	private String productNO;		//��Ʒ���
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="producttypeNO")
	private ProductType productType;//��Ʒ����
	@Column(length=20)
	private String productName;		//��Ʒ����
	@Column(length=20)
	private String producingArea;	//��Ʒ��������
	@Column(length=20)
	private String productOwner;	//��Ʒ������
	@Column(length=20)
	private String unit;			//��Ʒ��λ
	@Column
	private double price;			//��Ʒ�۸�
	@Column
	private int quantity;			//��Ʒ����
	@Column(length=50)
	private String otherInfo;		//������Ϣ
	
	public String getProductNO() {
		return productNO;
	}
	public void setProductNO(String productNO) {
		this.productNO = productNO;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProducingArea() {
		return producingArea;
	}
	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}
	
	public String getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
}
