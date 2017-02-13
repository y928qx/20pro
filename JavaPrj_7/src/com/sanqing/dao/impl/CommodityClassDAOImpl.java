package com.sanqing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.dao.CommodityClassDAO;
import com.sanqing.page.Page;
import com.sanqing.po.CommodityClass;

public class CommodityClassDAOImpl extends HibernateDaoSupport implements CommodityClassDAO{
	
	public List<CommodityClass> findAll(Page page) {
		Session session = getSession();		//���session����
		Query query = session.createQuery("from CommodityClass ");//ִ�в�ѯ
		query.setFirstResult(page.getBeginIndex());	//���ò�ѯ���λ��
		query.setMaxResults(page.getEveryPage());	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public void save(CommodityClass commodityclass) {
		getHibernateTemplate().save(commodityclass);//����ʵ��
	}
	public int findAllCount() {
		List<CommodityClass> commodityClasses  = 
			getHibernateTemplate().find("from CommodityClass ");//��ѯ���м�¼
		return commodityClasses .size();//���ؼ�¼��
	}
	public List<CommodityClass> findAll() {
		return getHibernateTemplate().find("from CommodityClass");
	}
	public CommodityClass findByID(int commodityClassID) {
		return (CommodityClass)getHibernateTemplate().load(CommodityClass.class, commodityClassID);
	}
}
