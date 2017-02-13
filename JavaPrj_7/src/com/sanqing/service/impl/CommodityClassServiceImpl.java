package com.sanqing.service.impl;

import java.util.List;

import com.sanqing.dao.CommodityClassDAO;
import com.sanqing.page.Page;
import com.sanqing.page.PageUtil;
import com.sanqing.page.Result;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityClassService;

public class CommodityClassServiceImpl implements CommodityClassService{
	private CommodityClassDAO commodityClassDAO;//ע�����ݷ��ʲ�
	public void setCommodityClassDAO(CommodityClassDAO commodityClassDAO) {
		this.commodityClassDAO = commodityClassDAO;//�������ݷ��ʲ�
	}
	public void addCommodityClass(CommodityClass commodityClass) {
		commodityClassDAO.save(commodityClass);//������ݱ���
	}
	public Result findAllCommodityClass(Page page) {
		page = PageUtil.createPage(page, 
				commodityClassDAO.findAllCount());	//������ҳ����
		List<CommodityClass> commodityClasses
				= commodityClassDAO.findAll(page);	//ִ�в�ѯ
		Result result = new Result();	//�����������
		result.setPage(page);			//���÷�ҳ��Ϣ
		result.setList(commodityClasses);//������Ʒ�����б�
		return result;
	}
	public List<CommodityClass> findAllCommodityClass() {
		return commodityClassDAO.findAll();
	}
	public CommodityClass queryByID(int commodityClassID) {
		return commodityClassDAO.findByID(commodityClassID);
	}
}
