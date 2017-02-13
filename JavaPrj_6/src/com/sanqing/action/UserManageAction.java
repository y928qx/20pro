package com.sanqing.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.User;
import com.sanqing.service.UserService;

@Controller("userManageAction")
@Scope("prototype")
public class UserManageAction extends BaseAction {

	@Resource
	private UserService userService;
	/* �û��� */
	private String username;
	/* ���� */
	private String password;
	/* ���� */
	private int grade;
	/**
	 * ����û��������
	 * @return
	 */
	public String addUI() {
		return "add";
	}
	/**
	 * ����û�
	 * @return
	 */
	public String add() {
		User user = new User();
		user.setGrade(grade);
		user.setPassword(password);
		user.setUsername(username);
		userService.save(user);
		return "pub_add_success";
	}
	/**
	 * �޸Ľ���
	 * @return
	 */
	public String updateUI() {
		User user = userService.find(username);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		return "update";
	}
	/**
	 * �޸Ľ���
	 * @return
	 */
	public String update() {
		User user = new User();
		user.setGrade(grade);
		user.setUsername(username);
		user.setPassword(password);
		userService.update(user);
		return "pub_update_success";
	}
	/**
	 * ɾ��
	 * @return
	 */
	public String del() {
		userService.delete(username);
		return "pub_del_success";
	}
	/**
	 * ��ѯ�û�
	 * @return
	 */
	public String query() {
		return "query";
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
