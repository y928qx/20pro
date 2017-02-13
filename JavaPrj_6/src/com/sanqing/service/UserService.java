package com.sanqing.service;

import com.sanqing.dao.DAO;
import com.sanqing.po.User;

/**
 * �û�ҵ��ӿ�
 */
public interface UserService extends DAO<User> {
	
	/**
	 * �ж��û��Ƿ����
	 * @param username �û���
	 * @param password ����
	 * @return
	 */
	public boolean login(String username, String password) ;
}
