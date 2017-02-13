package com.sanqing.course.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


@SuppressWarnings("serial")
public class UserForm extends ActionForm {
	
	//����
	private String id;
	
	//�û���
	private String name;
	
	//�û�����
	private String password;
	
	//�����Ľ�ʦ
	private String teacherId;
	
	//�ռ��û���������Ҫ�û�����ɾ��
	private String[] selectFlag;
	
	//��ѯ����
	private String flag;
	
	//�ڼ�ҳ
	private int pageNo;
	
	private String checkcode;
	
	private String type;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		if(type.equals("1")) {
			if((name == null) || (name.length() < 1)) {
				errors.add("name", new ActionMessage("userForm.name.required"));
			}
			if((password == null) || (password.length() < 1)) {
				errors.add("password", new ActionMessage("userForm.password.required"));
			}
//			if((checkcode == null) || (checkcode.length() < 1)) {
//				errors.add("checkcode", new ActionMessage("userForm.checkcode.required"));
//			}
		}

		return errors;
	}
	

	/**
	 * @return the checkcode
	 */
	public String getCheckcode() {
		return checkcode;
	}

	/**
	 * @param checkcode the checkcode to set
	 */
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String[] getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String[] selectFlag) {
		this.selectFlag = selectFlag;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

}
