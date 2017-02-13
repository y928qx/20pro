package com.sanqing.course.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.course.dao.TeamDAO;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;



/**
 * 
 * @author Administrator
 *
 */
public class TeamDAOImpl extends HibernateDaoSupport implements TeamDAO {

	/**
	 * ��Ӱ༶
	 * @param 
	 */
	public void addTeam(Team team) throws Exception{
		
		this.getHibernateTemplate().save(team);

	}

	/**
	 * �޸İ༶
	 * @param 
	 */
	public void modifyTeam(Team team) throws Exception {

		this.getHibernateTemplate().update(team);
		
	}

	/**
	 * ɾ���༶
	 * @param 
	 */
	public void deleteTeam(String[] teamIdList) throws Exception {
		
		for (int i=0; i<teamIdList.length; i++) {
			Team team = (Team)this.getHibernateTemplate().load(Team.class, teamIdList[i]);
			this.getHibernateTemplate().delete(team);
		}		
	}

	/**
	 * ��ѯȫ���༶
	 */
	@SuppressWarnings("unchecked")
	public List<Team> findAllTeams() {

		List<Team> teamList = new ArrayList<Team>();
	
		Session session = this.getSession();
		Query query = session.createQuery("from Team t");
		teamList = query.list();
	
		return teamList;

	}
	
	
	/**
	 * ����Id��ѯ�༶
	 * @param 
	 */
	public Team findTeamById(String id) {

		Team team = (Team)this.getHibernateTemplate().load(Team.class, id);
		
		return team;
	}

	/**
	 * ����������ѯ�༶��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public PageModel listTeam(int pageNo, Team team) {
		
		PageModel pageModel = null;
		List teamList = new ArrayList();
		
		Example exampleTeam = Example.create(team)
									 .enableLike(MatchMode.ANYWHERE)
									 .ignoreCase();

		
		teamList = this.getSession().createCriteria(Team.class)
									.add(exampleTeam)
									.setFirstResult((pageNo - 1) * PageModel.pageSize)
									.setMaxResults(PageModel.pageSize)
									.list();
		
		pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setList(teamList);
		pageModel.setTotalRecords(getTotalRecords(team));
		
		return pageModel;

	}

	/**
	 * ��ѯ��¼��
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getTotalRecords(Team team) {
		List teamList = new ArrayList();
		
		Example exampleTeam = Example.create(team)
		 							 .enableLike(MatchMode.ANYWHERE)
		 							 .ignoreCase();

		
		teamList = this.getSession().createCriteria(Team.class)
											   .add(exampleTeam)
											   .list();
		return teamList.size();
	}

}
