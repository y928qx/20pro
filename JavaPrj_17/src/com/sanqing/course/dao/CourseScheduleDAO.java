package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Course;
import com.sanqing.course.model.CourseSchedule;
import com.sanqing.course.model.Teacher;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public interface CourseScheduleDAO {
	
	/**
	 * ��ӿα�
	 * @param 
	 */
	public void addCourseSchedule(CourseSchedule courseSchedule) throws Exception;

	/**
	 * �޸Ŀα�
	 * @param 
	 */
	public void modifyCourseSchedule(CourseSchedule courseSchedule) throws Exception;

	/**
	 * ɾ���α�
	 * @param 
	 */
	public void deleteCourseSchedule(String[] courseScheduleIdList) throws Exception;

	
	/**
	 * ����Id��ѯ�α�
	 * @param 
	 */
	public CourseSchedule findCourseScheduleById(String id) throws Exception;
	
	
	/**
	 * ��ѯĳ����ʦ��ĳ���༶���̵�ĳ�ſεĿα����
	 * @param teacher
	 * @param team
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public CourseSchedule findCourseSchedule(CourseSchedule courseSchedule) throws Exception;
	
	
	/**
	 * ���ݰ༶��ѯ�α�
	 * @param 
	 */
	public List<CourseSchedule> findCourseScheduleByTeam(Team team) throws Exception;
	
	/**
	 * ���ݰ༶��ѯ�γ�
	 * @param 
	 */
	public List<Course> findCourseByTeam(Team team) throws Exception;
	
	
	/**
	 * ���ݿγ̲�ѯ�α�
	 * @param 
	 */
	public List<CourseSchedule> findCourseScheduleByCourse(Course course) throws Exception;
	
	
	/**
	 * ���ݽ�ʦ���������̵İ༶
	 * @param teacher
	 * @param team
	 * @return
	 * @throws Exception
	 */
	public List<Team> findTeamByTeacher(Teacher teacher) throws Exception;
	
	
	/**
	 * ���ݽ�ʦ��ѯ�α�
	 * @param 
	 */
	public List<CourseSchedule> findCourseScheduleByTeacher(Teacher teacher) throws Exception;
	
	/**
	 * ���ݽ�ʦ�Ͱ༶�����α�
	 * @param teacher
	 * @param team
	 * @return
	 * @throws Exception
	 */
	public List<CourseSchedule> findCourseScheduleByTeacherAndTeam(Teacher teacher, Team team) throws Exception;
	
	
	/**
	 * ��ѯȫ���α�
	 */
	public List<CourseSchedule> findAllCourseSchedules() throws Exception;
	
	
	/**
	 * ����������ѯ�α�
	 */
	public PageModel listCourseSchedule(int pageNo, CourseSchedule courseSchedule) throws Exception;

}
