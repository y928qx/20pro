package com.sanqing.action;

import java.util.List;

import com.sanqing.dao.UserDAO;
import com.sanqing.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserAction extends ActionSupport {
	private UserDAO userDAO;
	private List<User> allUser;
	private int start;
	private int limit;
	private int recordSize;

	public int getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String execute() throws Exception {
		//1.�ٷ�ҳ
//		allUser = userDAO.findAll();
//		//��¼��
//		setRecordSize(allUser.size());
//		//�ж��Ƿ�Խ��
//		int end = start + limit;
//		if(end >= allUser.size()) {
//			end = allUser.size();
//		}
//		//ȡ����List
//		allUser = allUser.subList(start, end);
		
		//2.���ҳ
		allUser = userDAO.findAll(start, limit);
		//��¼��
		setRecordSize(userDAO.findAll().size());
		
		return this.SUCCESS;
	}
}
