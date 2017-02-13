package com.sanqing.service;

import java.util.List;

import com.sanqing.page.Page;
import com.sanqing.page.Result;
import com.sanqing.po.CommodityClass;

public interface CommodityClassService {
	public void addCommodityClass(CommodityClass commodityClass);//������Ʒ����
	public Result findAllCommodityClass(Page page);//��ҳ��ѯ��Ʒ����
	public List<CommodityClass> findAllCommodityClass();//��ѯ������Ʒ����
	public CommodityClass queryByID(int commodityClassID);
}
