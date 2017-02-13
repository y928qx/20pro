package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityClassService;
import com.sanqing.service.CommodityService;

public class AddToCarAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private CommodityService commodityService;// ҵ���߼���
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
	private int commodityID;

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

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

	public int getCommodityID() {
		return commodityID;
	}

	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		Commodity commodity = commodityService.queryByCommodityID(commodityID);//�����Ʒ��Ϣ
		Map session = ActionContext.getContext().getSession();//���session����
		List<Commodity> car = null;				//����һ�����ﳵ
		if(session.get("car") == null) {	//���session�в����ڹ��ﳵ
				car = new ArrayList<Commodity>();	//�½�һ��ArrayListʵ��
		}else {
			car = (List<Commodity>)session.get("car");//ȡ�ù��ﳵ
		}
		car.add(commodity);//����Ʒ��ӵ����ﳵ��
		session.put("car", car);//�����ﳵ������session��
		return SUCCESS;
	}
}
