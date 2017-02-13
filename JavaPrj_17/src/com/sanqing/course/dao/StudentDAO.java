package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Course;
import com.sanqing.course.model.Student;
import com.sanqing.course.model.Teacher;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public interface StudentDAO {
	
	/**
	 * ���ѧ��
	 * @param 
	 */
	public void addStudent(Student student) throws Exception;

	/**
	 * �޸�ѧ��
	 * @param 
	 */
	public void modifyStudent(Student student) throws Exception;

	/**
	 * ɾ��ѧ��
	 * @param 
	 */
	public void deleteStudent(String[] studentIdList) throws Exception;

	
	/**
	 * ����Id��ѯѧ��
	 * @param 
	 */
	public Student findStudentById(String id) throws Exception;
	
	/**
	 * ��ѯȫ��ѧ��
	 */
	public List<Student> findAllStudents() throws Exception;
	
	/**
	 * ����������ѯѧ��
	 */
	public PageModel listStudent(int pageNo, Student student) throws Exception;

	
	/**
	 * ��������ͳ��ѧ��
	 */
	public PageModel countStudent(int pageNo, Team team, Course course, Teacher teacher) throws Exception;

	
}
