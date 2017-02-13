package com.sanqing.po;

import java.sql.Blob;
import java.util.Date;

public class Commodity implements java.io.Serializable {
	private Integer commodityId;			//��Ʒ���
	private CommodityClass commodityClass;	//��Ʒ����
	private String commodityName;			//��Ʒ����
	private String manufacturer;			//��������
	private String commodityDepict;			//��Ʒ����
	private Double commodityPrice;			//��Ʒ�۸�
	private Double fcPrice;					//�������۸�
	private Integer commodityAmount;		//��Ʒ������
	private Integer commodityLeaveNum;		//��Ʒʣ������
	private Date regTime;					//��Ʒ�ϼ�ʱ��
	private byte[] image;						//��ƷͼƬ

	public Commodity() {
	}

	public Commodity(CommodityClass commodityClass, String commodityName,
			String manufacturer, String commodityDepict, Double commodityPrice,
			Double fcPrice, Integer commodityAmount, Integer commodityLeaveNum,
			Date regTime, byte[] image) {
		this.commodityClass = commodityClass;
		this.commodityName = commodityName;
		this.manufacturer = manufacturer;
		this.commodityDepict = commodityDepict;
		this.commodityPrice = commodityPrice;
		this.fcPrice = fcPrice;
		this.commodityAmount = commodityAmount;
		this.commodityLeaveNum = commodityLeaveNum;
		this.regTime = regTime;
		this.image = image;
	}

	public Integer getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public CommodityClass getCommodityClass() {
		return this.commodityClass;
	}

	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCommodityDepict() {
		return this.commodityDepict;
	}

	public void setCommodityDepict(String commodityDepict) {
		this.commodityDepict = commodityDepict;
	}

	public Double getCommodityPrice() {
		return this.commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Double getFcPrice() {
		return this.fcPrice;
	}

	public void setFcPrice(Double fcPrice) {
		this.fcPrice = fcPrice;
	}

	public Integer getCommodityAmount() {
		return this.commodityAmount;
	}

	public void setCommodityAmount(Integer commodityAmount) {
		this.commodityAmount = commodityAmount;
	}

	public Integer getCommodityLeaveNum() {
		return this.commodityLeaveNum;
	}

	public void setCommodityLeaveNum(Integer commodityLeaveNum) {
		this.commodityLeaveNum = commodityLeaveNum;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}