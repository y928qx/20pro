package com.sanqing.dao;

import java.util.List;

import com.sanqing.page.Page;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;

public interface CommodityDAO {
	public void save(Commodity commodity);//������Ʒ��Ϣ
	public List<Commodity> findAll(Page page);//��ҳ��ѯ���е���Ʒ
	public int findAllCount();//��ѯ���м�¼��
	public void delete(int commodityID);//ɾ����Ʒ��Ϣ
	public List<Commodity> findByTime(int num);//��ʱ�䵹�����
	public Commodity findByID(int commodityID);//��ID����
	public List<Commodity> findByClass(CommodityClass commodityClass,Page page);
	public int findAllCount(CommodityClass commodityClass);//��ѯ�����¼��
}
