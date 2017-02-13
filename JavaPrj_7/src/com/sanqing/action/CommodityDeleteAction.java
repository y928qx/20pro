package com.sanqing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.service.CommodityService;

public class CommodityDeleteAction extends ActionSupport{
	private Integer commodityID;//��Ʒ���
	private CommodityService commodityService;//��Ʒҵ���߼����

	public void setCommodityID(Integer commodityID) {
		this.commodityID = commodityID;
	}
	
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public String execute() throws Exception {
		commodityService.deleteCommodity(commodityID);
		return SUCCESS;
	}
}
