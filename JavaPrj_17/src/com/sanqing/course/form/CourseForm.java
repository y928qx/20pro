package com.sanqing.course.form;

import org.apache.struts.action.ActionForm;


@SuppressWarnings("serial")
public class CourseForm extends ActionForm {
	
	//����
	private String id;
	
	//�ʲ���������
	private String name;
	

	//�ռ�Id����Ҫ�γ�����ɾ��
	private String[] selectFlag;
	
	
	//�ڼ�ҳ
	private int pageNo;
	

	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
