package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Course;
import com.sanqing.course.model.Mark;
import com.sanqing.course.model.Student;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public interface MarkDAO {
	
	/**
	 * ��ӳɼ�
	 * @param 
	 */
	public void addMark(Mark mark) throws Exception;

	/**
	 * �޸ĳɼ�
	 * @param 
	 */
	public void modifyMark(Mark mark) throws Exception;

	/**
	 * ɾ���ɼ�
	 * @param 
	 */
	public void deleteMark(String[] markIdList) throws Exception;

	
	/**
	 * ����Id��ѯ�ɼ�
	 * @param 
	 */
	public Mark findMarkById(String id) throws Exception;
	
	/**
	 * ��ѯȫ���ɼ�
	 */
	public List<Mark> findAllMarks() throws Exception;
	
	/**
	 * ����������ѯ�ɼ�
	 */
	public PageModel listMark(int pageNo, Mark mark, Team team) throws Exception;

	/**
	 * ����ѧ�����ҳɼ�
	 * @param team
	 * @return
	 * @throws Exception
	 */
	public List<Mark> findMarkByStudent(Student student) throws Exception;
	
	/**
	 * ���ݰ༶�Ϳγ̼������β�ѯ�ɼ�
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findMarkByScore(Team team, Course course, Float min, Float max) throws Exception;
	
	/**
	 * ���ݰ༶�Ϳγ̲�ѯ�ɼ�
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findMarkByCourse(Team team, Course course) throws Exception;
}
