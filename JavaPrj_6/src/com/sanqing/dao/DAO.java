package com.sanqing.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.sanqing.util.QueryResult;


public interface DAO<T> {
	public long getCount();//��ü�¼����
	public void clear();//���һ�����������
	public void save(Object entity);//�����¼
	public void update(Object entity);//���¼�¼
	public void delete(Serializable ... entityids);//ɾ����¼
	public T find(Serializable entityId);//ͨ��������ü�¼
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, 
					Object[] queryParams,LinkedHashMap<String, String> orderby);//��÷�ҳ��¼
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
										String wherejpql, Object[] queryParams);//��÷�ҳ��¼
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
										LinkedHashMap<String, String> orderby);//��÷�ҳ��¼
	public QueryResult<T> getScrollData(int firstindex, int maxresult);		//��÷�ҳ��¼
	public QueryResult<T> getScrollData();//��÷�ҳ��¼
}
