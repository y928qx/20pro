package com.sanqing.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityClassService;
import com.sanqing.service.CommodityService;

public class GoIndex extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
	private CommodityService commodityService;// ҵ���߼���
	private List<Commodity> commodities;// ��Ʒ��Ϣ�б�

	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	public void setCommodityClassService(
			CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}

	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public String execute() throws Exception {
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		commodities = commodityService.queryByRegTime(9);//�������µľ�����Ʒ��¼
		return SUCCESS;
	}
}
