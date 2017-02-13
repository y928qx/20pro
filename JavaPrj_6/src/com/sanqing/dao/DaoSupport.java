package com.sanqing.dao;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sanqing.util.GenericsUtils;
import com.sanqing.util.QueryResult;

@SuppressWarnings("unchecked")
@Transactional
public abstract class DaoSupport<T> implements DAO<T>{
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());//��ø���ĸ���ķ��Ͳ�����ʵ������
	@PersistenceContext protected EntityManager em;
	public void clear(){//���һ�����������
		em.clear();
	}
	public void delete(Serializable ... entityids) {//ɾ����¼
		for(Object id : entityids){
			em.remove(em.getReference(this.entityClass, id));
		}
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Serializable entityId) {//ͨ��������ü�¼
		if(entityId==null) throw new RuntimeException(this.entityClass.getName()+ ":�����ʵ��id����Ϊ��");
		return em.find(this.entityClass, entityId);
	}
	public void save(Object entity) {//�����¼
		em.persist(entity);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public long getCount() {	//��ü�¼����
		return (Long)em.createQuery("select count("+ getCountField(this.entityClass) +") from "+ getEntityName(this.entityClass)+ " o").getSingleResult();
	}
	
	protected static <E> String getCountField(Class<E> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				Method method = propertydesc.getReadMethod();
				if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){					
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return out;
	}
	
	protected static void setQueryParams(Query query, Object[] queryParams){
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	protected static String buildOrderby(LinkedHashMap<String, String> orderby){//��װorder by���
		StringBuffer orderbyql = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			orderbyql.append(" order by ");
			for(String key : orderby.keySet()){
				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length()-1);
		}
		return orderbyql.toString();
	}
	protected static <E> String getEntityName(Class<E> clazz){//��ȡʵ�������
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
	
	public void update(Object entity) {//���¼�¼
		em.merge(entity);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, 
				int maxresult, LinkedHashMap<String, String> orderby) {//��÷�ҳ��¼
		return getScrollData(firstindex,maxresult,null,null,orderby);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, 
			int maxresult, String wherejpql, Object[] queryParams) {//��÷�ҳ��¼
		return getScrollData(firstindex,maxresult,wherejpql,queryParams,null);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult) {//��÷�ҳ��¼
		return getScrollData(firstindex,maxresult,null,null,null);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql,
			Object[] queryParams,LinkedHashMap<String, String> orderby) {//��÷�ҳ��¼
		QueryResult qr = new QueryResult<T>();//��ѯ��¼���
		String entityname = getEntityName(this.entityClass);//���ʵ������
		Query query = em.createQuery("select o from "+ 
				entityname+ " o "+(wherejpql==null 
				|| "".equals(wherejpql.trim())? "":
				"where "+ wherejpql)+ buildOrderby(orderby));//ִ�в�ѯ
		setQueryParams(query, queryParams);//���ò�ѯ����
		if(firstindex!=-1 && maxresult!=-1) //��������������-1��ʱ��ŷ�ҳ
			query.setFirstResult(firstindex).
			setMaxResults(maxresult);//���ò�ѯ��¼����ʼλ�úͲ�ѯ�����
		qr.setResultlist(query.getResultList());//���ò�ѯ�ļ�¼
		query = em.createQuery("select count(" +
				getCountField(this.entityClass)+ ") " +
				"from "+ entityname+ " o "+(wherejpql==null ||
				"".equals(wherejpql.trim())? "": "where "+ wherejpql));
		setQueryParams(query, queryParams);//���ò�ѯ����
		qr.setTotalrecord((Long)query.getSingleResult());//���ò�ѯ��¼����
		return qr;//���ز�ѯ��¼���
	}

	
}
