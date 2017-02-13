package com.ibeifeng.action;

import java.util.List;
import java.util.Map;

import com.ibeifeng.dao.CommodityDAO;
import com.ibeifeng.po.Commodity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommodityAddAction  extends ActionSupport{
	private String commodityName;
	private Double price;
	private Double agio;
	
	private boolean success;
	private String msg;
	
	private CommodityDAO commodityDAO;
	
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAgio() {
		return agio;
	}

	public void setAgio(Double agio) {
		this.agio = agio;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CommodityDAO getCommodityDAO() {
		return commodityDAO;
	}

	public void setCommodityDAO(CommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;
	}

	public String execute() throws Exception {
		//��Ʒ���Ʋ����ظ����������ȸ��ݸ���Ʒ��������ѯ�Ƿ��Ѿ�������������Ʒ
		List<Commodity> commodities = commodityDAO.findByCommodityName(commodityName);
		//���������
		if(commodities.size() == 0) {
			//ʵ������������ֵ
			Commodity commodity = new Commodity();
			commodity.setCommodityName(commodityName);
			commodity.setPrice(price);
			commodity.setAgio(agio);
			//���б���
			commodityDAO.save(commodity);
			success = true;
			msg = "��Ʒ¼��ɹ�!";
		}
		//�������
		else {
			success = false;
			msg = "��Ʒ¼��ʧ�ܣ�����Ʒ�Ѿ�����!";
		}
		return this.SUCCESS;
	}
	
}
