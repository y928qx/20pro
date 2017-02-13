package com.ibeifeng.action;

import java.util.List;
import java.util.Map;

import com.ibeifeng.dao.UserDAO;
import com.ibeifeng.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private String randCode;
	private boolean success;
	private String msg;
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRandCode() {
		return randCode;
	}
	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}
	
	public String execute() throws Exception {
		//��õĵ�ǰ��ȷ����֤��
		String rand = (String) ActionContext.getContext().getSession().get("rand");
		
		if(rand.equals(randCode)){
			//�ж��û��Ƿ����
			User user= userDAO.findById(username);
			if(user == null) {
				success = false;
				msg = "�û���������";
			} else {
				if(password.equals(user.getPassword())) {
					success = true;
					msg = "�û���¼�ɹ�";
					Map session = ActionContext.getContext().getSession();
					session.put("username", username);
				}else {
					success = false;
					msg = "���벻��ȷ";
				}
			}
		} else {
			success = false;
			msg = "��֤���������";
		}
		return this.SUCCESS;
	}
}
