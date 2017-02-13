package com.sanqing.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.util.PageView;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {

	@Resource
	private UserService userService;
	/* �û��� */
	private String username;
	/* ���� */
	private String password;
	/* ���� */
	private int grade;
	@Override
	public String execute() throws Exception {
		PageView<User> pageView = new PageView<User>(5, getPage());
		if("true".equals(getQuery())) {
			if(username!=null && !"".equals(username)) {
				pageView.setQueryResult(userService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), " o.username like ?1", new Object[]{username}));
			}
		}else {
			pageView.setQueryResult(userService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pageView", pageView);
		return this.SUCCESS;
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
