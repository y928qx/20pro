package com.sanqing.course.dao;

import java.util.List;

import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public interface TeamDAO {
	
	/**
	 * ��Ӱ༶
	 * @param 
	 */
	public void addTeam(Team team) throws Exception;

	/**
	 * �޸İ༶
	 * @param 
	 */
	public void modifyTeam(Team team) throws Exception;

	/**
	 * ɾ���༶
	 * @param 
	 */
	public void deleteTeam(String[] teamIdList) throws Exception;

	
	/**
	 * ����Id��ѯ�༶
	 * @param 
	 */
	public Team findTeamById(String id) throws Exception;
	
	/**
	 * ��ѯȫ���༶
	 */
	public List<Team> findAllTeams() throws Exception;
	
	/**
	 * ����������ѯ�༶
	 */
	public PageModel listTeam(int pageNo, Team team) throws Exception;

}
