package com.sanqing.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.dao.CommodityDAO;
import com.sanqing.page.Page;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;

public class CommodityDAOImpl extends HibernateDaoSupport implements CommodityDAO{
	public List<Commodity> findAll(Page page) {
		Session session = getSession();		//���session����
		Query query = session.createQuery("from Commodity");//ִ�в�ѯ
		query.setFirstResult(page.getBeginIndex());	//���ò�ѯ���λ��
		query.setMaxResults(page.getEveryPage());	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public void save(Commodity commodity) {
		getHibernateTemplate().save(commodity);//����ʵ��
	}
	public int findAllCount() {
		List<CommodityClass> commodities  = 
			getHibernateTemplate().find("from Commodity");//��ѯ���м�¼
		return commodities.size();//���ؼ�¼��
	}
	public void delete(int commodityID) {	//ɾ����Ʒ��Ϣ
		Commodity commodity = (Commodity)getHibernateTemplate().
							load(Commodity.class, commodityID);//���ض���
		getHibernateTemplate().delete(commodity);//ɾ������
	}
	public List<Commodity> findByTime(int num) {
		Session session = getSession();		//���session����
		Query query = session.createQuery
			("from Commodity order by regTime desc");//ִ�в�ѯ
		query.setFirstResult(0);	//���ò�ѯ���λ��
		query.setMaxResults(num);	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public Commodity findByID(int commodityID) {
		return (Commodity)getHibernateTemplate().load(Commodity.class, commodityID);
	}
	public List<Commodity> findByClass(CommodityClass commodityClass, Page page) {
		Session session = getSession();		//���session����
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//ִ�в�ѯ
		query.setEntity("commodityClass", commodityClass);
		query.setFirstResult(page.getBeginIndex());	//���ò�ѯ���λ��
		query.setMaxResults(page.getEveryPage());	//���ò�ѯ���ֵ
		return query.list();		//���ز�ѯ���
	}
	public int findAllCount(CommodityClass commodityClass) {
		Session session = getSession();		//���session����
		Query query = session.createQuery("from Commodity where commodityClass =:commodityClass");//ִ�в�ѯ
		query.setEntity("commodityClass", commodityClass);
		return query.list().size();//���ؼ�¼��
	}
}
