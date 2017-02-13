package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Teacher;
import com.sanqing.course.util.PageModel;


public interface TeacherDAO {
	
	/**
	 * ��ӽ�ʦ
	 * @param 
	 */
	public void addTeacher(Teacher teacher) throws Exception;

	/**
	 * �޸Ľ�ʦ
	 * @param 
	 */
	public void modifyTeacher(Teacher teacher) throws Exception;

	/**
	 * ɾ����ʦ
	 * @param 
	 */
	public void deleteTeacher(String[] teacherIdList) throws Exception;

	
	/**
	 * ����Id��ѯ��ʦ
	 * @param 
	 */
	public Teacher findTeacherById(String id) throws Exception;
	
	/**
	 * ��ѯȫ����ʦ
	 */
	public List<Teacher> findAllTeachers() throws Exception;
	
	/**
	 * ����������ѯ��ʦ
	 */
	public PageModel listTeacher(int pageNo, Teacher teacher) throws Exception;

}
