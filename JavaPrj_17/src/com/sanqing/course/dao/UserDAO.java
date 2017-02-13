package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.User;
import com.sanqing.course.util.PageModel;


public interface UserDAO {
	
	/**
	 * ����û�
	 * @param 
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * �û���¼
	 * @param 
	 */
	public User logon(User user) throws Exception;

	/**
	 * �޸��û�
	 * @param 
	 */
	public void modifyUser(User user) throws Exception;

	/**
	 * ɾ���û�
	 * @param 
	 */
	public void deleteUser(String[] userIdList) throws Exception;

	
	/**
	 * ����Id��ѯ�û�
	 * @param 
	 */
	public User findUserById(String id) throws Exception;
	
	/**
	 * ��ѯȫ���û�
	 */
	public List<User> findAllUsers() throws Exception;
	
	/**
	 * ����������ѯ�û�
	 */
	public PageModel listUser(int pageNo, User user) throws Exception;

}
