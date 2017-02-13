package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Course;
import com.sanqing.course.util.PageModel;


public interface CourseDAO {
	
	/**
	 * ��ӿγ�
	 * @param 
	 */
	public void addCourse(Course course) throws Exception;

	/**
	 * �޸Ŀγ�
	 * @param 
	 */
	public void modifyCourse(Course course) throws Exception;

	/**
	 * ɾ���γ�
	 * @param 
	 */
	public void deleteCourse(String[] courseIdList) throws Exception;

	
	/**
	 * ����Id��ѯ�γ�
	 * @param 
	 */
	public Course findCourseById(String id) throws Exception;
	
	/**
	 * ��ѯȫ���γ�
	 */
	public List<Course> findAllCourses() throws Exception;
	
	/**
	 * ����������ѯ�γ�
	 */
	public PageModel listCourse(int pageNo, Course course) throws Exception;

}
