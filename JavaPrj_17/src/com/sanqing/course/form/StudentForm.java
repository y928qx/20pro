package com.sanqing.course.form;

import org.apache.struts.action.ActionForm;


@SuppressWarnings("serial")
public class StudentForm extends ActionForm {
	
	//����
	private String id;
	
	//ѧ��
	private String code;
	
	//����
	private String name;
	
	//��ѧʱ��
	private String enrollDate;
	
	//��������
	private String birthday;
	
	 //�Ա�
	private String sex;  
	
	//�༶��
	private String teamId;
	

	//�ռ�Id����Ҫ����ɾ��
	private String[] selectFlag;
	
	//�ڼ�ҳ
	private int pageNo;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enrollDate
	 */
	public String getEnrollDate() {
		return enrollDate;
	}

	/**
	 * @param enrollDate the enrollDate to set
	 */
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the selectFlag
	 */
	public String[] getSelectFlag() {
		return selectFlag;
	}

	/**
	 * @param selectFlag the selectFlag to set
	 */
	public void setSelectFlag(String[] selectFlag) {
		this.selectFlag = selectFlag;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	


}
