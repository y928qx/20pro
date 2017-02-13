package com.sanqing.action;

import java.util.List;

import com.sanqing.dao.PayOutDAO;
import com.sanqing.dao.UserDAO;
import com.sanqing.po.PayOut;
import com.sanqing.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserAction extends ActionSupport {
	private String id;
	private UserDAO userDAO;
	private PayOutDAO payOutDAO;
	
	private boolean success;
	private String msg;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String execute() throws Exception {
		User user = null;
		String[] ids = id.split(",");
		for(String strId : ids) {
			int intId = Integer.parseInt(strId);
			user = userDAO.findById(intId);
			//�����û���Ϣ�õ����û���Ӧ�����е�֧����¼
			List<PayOut> allPayOut = payOutDAO.findByProperty("user", user);
			//ѭ������ɾ��
			for(PayOut payOut : allPayOut) {
				payOutDAO.delete(payOut);
			}
			userDAO.delete(user);
		}
		success=true;
		msg = "ɾ���û���¼�ɹ�";
		return this.SUCCESS;
	}

	public PayOutDAO getPayOutDAO() {
		return payOutDAO;
	}

	public void setPayOutDAO(PayOutDAO payOutDAO) {
		this.payOutDAO = payOutDAO;
	}

}
