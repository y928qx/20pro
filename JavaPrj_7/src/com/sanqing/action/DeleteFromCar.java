package com.sanqing.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityClassService;
import com.sanqing.service.CommodityService;

public class DeleteFromCar extends ActionSupport{
	private int commodityID;
	private CommodityService commodityService;// ҵ���߼���
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
	public int getCommodityID() {
		return commodityID;
	}

	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	
	public CommodityService getCommodityService() {
		return commodityService;
	}
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}
	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}
	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}
	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}
	public String execute() throws Exception {
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		Map session = ActionContext.getContext().getSession();//���session����
		List<Commodity> car = (List<Commodity>)session.get("car");//ȡ�ù��ﳵ
		Iterator<Commodity>  it = car.iterator();
		for(int i = car.size();it.hasNext();i--){
			Commodity com = it.next();
			if(com.getCommodityId() == commodityID) {
				 int index = car.indexOf(com); 
				 it.remove();        //���д����ǹؼ���
			}
		}
		session.put("car",car);//�����¹��ﳵ���浽session��
		return SUCCESS;
	}
}
