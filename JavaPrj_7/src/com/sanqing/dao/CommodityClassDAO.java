package com.sanqing.dao;

import java.util.List;

import com.sanqing.page.Page;
import com.sanqing.po.CommodityClass;

public interface CommodityClassDAO {
	public void save(CommodityClass commodityclass);//保存商品种类
	public List<CommodityClass> findAll(Page page);//分页查询所有的商品种类
	public int findAllCount();//查询所有记录数
	public List<CommodityClass> findAll();//查询所有的商品种类
	public CommodityClass findByID(int commodityClassID);
}
