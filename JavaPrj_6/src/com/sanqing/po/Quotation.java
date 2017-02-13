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

@Entity  @Table(name="tb_quotation")
public class Quotation {			//������Ϣ��
	@Id @Column(length=15)
	private String quotationNO;		//���۱��
	@Column(length=15)
	private String quotationMan;	//������
	@Temporal(TemporalType.DATE)
	private Date quotationTime;		//����ʱ��
	@Column(length=50)
	private String otherInfo;			//������Ϣ
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="productNO")
	private Product product ;		//��Ʒ
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="customerNO")
	private Customer customer;		//�ͻ�
	
	public String getQuotationNO() {
		return quotationNO;
	}
	public void setQuotationNO(String quotationNO) {
		this.quotationNO = quotationNO;
	}
	
	public String getQuotationMan() {
		return quotationMan;
	}
	public void setQuotationMan(String quotationMan) {
		this.quotationMan = quotationMan;
	}
	
	public Date getQuotationTime() {
		return quotationTime;
	}
	public void setQuotationTime(Date quotationTime) {
		this.quotationTime = quotationTime;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
