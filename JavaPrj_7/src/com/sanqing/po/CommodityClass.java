package com.sanqing.po;

import java.util.HashSet;
import java.util.Set;

public class CommodityClass implements java.io.Serializable {
	private Integer commodityClassId;		//��Ʒ������
	private String commodityClassName;		//��Ʒ��������

	public Integer getCommodityClassId() {
		return this.commodityClassId;
	}

	public void setCommodityClassId(Integer commodityClassId) {
		this.commodityClassId = commodityClassId;
	}

	public String getCommodityClassName() {
		return this.commodityClassName;
	}

	public void setCommodityClassName(String commodityClassName) {
		this.commodityClassName = commodityClassName;
	}

	public CommodityClass(Integer commodityClassId) {
		super();
		this.commodityClassId = commodityClassId;
	}

	public CommodityClass() {
		super();
	}
}