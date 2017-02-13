package com.sanqing.service.impl;

import java.util.List;

import com.sanqing.dao.CommodityDAO;
import com.sanqing.page.Page;
import com.sanqing.page.PageUtil;
import com.sanqing.page.Result;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityService;

public class CommodityServiceImpl implements CommodityService{
	private CommodityDAO commodityDAO;//ע�����ݷ��ʲ�
	public void setCommodityDAO(CommodityDAO commodityDAO) {
		this.commodityDAO = commodityDAO;//�������ݷ��ʲ�
	}
	public void addCommodity(Commodity commodity) {
		commodityDAO.save(commodity);//������ݱ���
	}
	public Result findAllCommodity(Page page) {
		page = PageUtil.createPage(page, 
				commodityDAO.findAllCount());	//������ҳ����
		List<Commodity> commodityes
				= commodityDAO.findAll(page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityes);//������Ʒ�����б�
		return result;
	}
	public void deleteCommodity(int commodityID) {
		commodityDAO.delete(commodityID);
	}
	public List<Commodity> queryByRegTime(int num) {
		return commodityDAO.findByTime(num);
	}
	public Commodity queryByCommodityID(int commodityID) {
		return commodityDAO.findByID(commodityID);
	}
	public Result queryByCommodityClass(CommodityClass commodityClass, Page page) {
		page = PageUtil.createPage(page, 
				commodityDAO.findAllCount(commodityClass));	//������ҳ����
		List<Commodity> commodityes
				= commodityDAO.findByClass(commodityClass, page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityes);//������Ʒ�����б�
		return result;
	}
}
