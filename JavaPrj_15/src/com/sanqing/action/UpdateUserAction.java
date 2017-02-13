package com.sanqing.action;

import com.sanqing.dao.UserDAO;
import com.sanqing.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserAction extends ActionSupport {
	private int id;
	private String field;
	private String value;
	private UserDAO userDAO;
	private boolean success;
	private String msg;

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

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String execute() throws Exception {
		//ȡ�ø�id��Ӧ���û�
		User user = userDAO.findById(id);
		//�жϸ�id��Ӧ���û��Ƿ����
		if(user == null) {
			success = false;
			msg = "�����û���Ϣʧ��!";
		} else {
			//����field��֪����Ҫ�����ĸ�����
			if("username".equals(field)) {
				user.setUsername(value);
				if(userDAO.findByUsername(value).size()!= 0) {
					success = false;
					msg = "�û���������ʧ�ܣ����û��Ѿ���ռ��!";
				}else {
					//�����û���Ϣ
					userDAO.attachDirty(user);
					success = true;
					msg = "�û��������ݳɹ�!";
				}
			} else if("password".equals(field)) {
				user.setPassword(value);
				//�����û���Ϣ
				userDAO.attachDirty(user);
				success = true;
				msg = "�û��������ݳɹ�!";
			}
		}
		return this.SUCCESS;
	}
}
