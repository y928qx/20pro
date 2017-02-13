package com.sanqing.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Commodity;
import com.sanqing.service.CommodityService;

public class ShowImg extends ActionSupport{
	private CommodityService commodityService;// ÒµÎñÂß¼­²ã
	private int CommodityID;
	private ByteArrayInputStream inputStream;

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	
	public int getCommodityID() {
		return CommodityID;
	}

	public void setCommodityID(int commodityID) {
		CommodityID = commodityID;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute() throws Exception {
		Commodity commodity = commodityService.queryByCommodityID(CommodityID);
		inputStream=new ByteArrayInputStream(commodity.getImage()); 
		return SUCCESS;
	}
}
