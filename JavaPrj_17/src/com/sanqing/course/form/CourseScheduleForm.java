package com.sanqing.course.form;

import org.apache.struts.action.ActionForm;


@SuppressWarnings("serial")
public class CourseScheduleForm extends ActionForm {
	
	//����
	private String id;
	
	//ѧ��
	private String semester;
	
	//ѧ��
	private String score;
	
	//�༶
	private String teamId;
	
	//�ον�ʦ
	private String teacherId;
	
	//����γ�
	private String courseId;
	
	//�ռ�Id����Ҫ�γ�����ɾ��
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
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
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

	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	


}
