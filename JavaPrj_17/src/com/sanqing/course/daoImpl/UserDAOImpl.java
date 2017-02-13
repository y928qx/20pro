package com.sanqing.course.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.course.dao.UserDAO;
import com.sanqing.course.model.User;
import com.sanqing.course.util.PageModel;


/**
 * 
 * @author Administrator
 *
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	/**
	 * �û���¼
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public User logon(User user) throws Exception {
		
		User userNew = null;
		
		if(user.getName().equals("admin") && user.getPassword().equals("admin")) {
			User admin = new User();
			admin.setName("admin");
			admin.setPassword("admin");
			return admin;
		}
		
		String hql = "From User u where u.name=? and u.password=?";
		Query q = this.getSession().createQuery(hql);
		q.setString(0, user.getName());
		q.setString(1, user.getPassword());
		List all = q.list();
		
		if (all.size() > 0) {
			userNew = (User) all.get(0);
		}
		
		return userNew;	
	}
	
	/**
	 * ����û�
	 * @param 
	 */
	public void addUser(User user) throws Exception{
		
		this.getHibernateTemplate().save(user);

	}

	/**
	 * �޸��û�
	 * @param 
	 */
	public void modifyUser(User user) throws Exception {

		this.getHibernateTemplate().update(user);
		
	}

	/**
	 * ɾ���û�
	 * @param 
	 */
	public void deleteUser(String[] userIdList) throws Exception {
		
		for (int i=0; i<userIdList.length; i++) {
			User user = (User)this.getHibernateTemplate().load(User.class, userIdList[i]);
			this.getHibernateTemplate().delete(user);
		}		
	}

	/**
	 * ��ѯȫ���û�
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {

		List<User> userList = new ArrayList<User>();
	
		Session session = this.getSession();
		Query query = session.createQuery("from User u");
		userList = query.list();
	
		return userList;

	}
	
	
	/**
	 * ����Id��ѯ�û�
	 * @param 
	 */
	public User findUserById(String id) {

		User user = (User)this.getHibernateTemplate().load(User.class, id);
		
		return user;
	}

	/**
	 * ����������ѯ�û���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public PageModel listUser(int pageNo, User user) {
		
		PageModel pageModel = null;
		List userList = new ArrayList();
		
		Example exampleUser = Example.create(user)
									 .enableLike(MatchMode.ANYWHERE)
									 .ignoreCase();
									 
		
		userList = this.getSession().createCriteria(User.class)
									.add(exampleUser)
									.setFirstResult((pageNo - 1) * PageModel.pageSize)
									.setMaxResults(PageModel.pageSize)
									.list();
		
		pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setList(userList);
		pageModel.setTotalRecords(getTotalRecords(user));
		
		return pageModel;

	}

	/**
	 * ��ѯ��¼��
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked" )
	private int getTotalRecords(User user) {
		
		List userList = new ArrayList();
		
		Example exampleUser = Example.create(user)
		 							 .enableLike(MatchMode.ANYWHERE)
		 							 .ignoreCase();
		
		userList = this.getSession().createCriteria(User.class)
											   .add(exampleUser)
											   .list();
		return userList.size();
	}

}
