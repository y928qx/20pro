package com.sanqing.course.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.course.dao.MarkDAO;
import com.sanqing.course.model.Course;
import com.sanqing.course.model.Mark;
import com.sanqing.course.model.Student;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;



/**
 * 
 * @author Administrator
 *
 */
public class MarkDAOImpl extends HibernateDaoSupport implements MarkDAO {

	/**
	 * ��ӳɼ�
	 * @param 
	 */
	public void addMark(Mark mark) throws Exception{
		
		this.getHibernateTemplate().save(mark);

	}

	/**
	 * �޸ĳɼ�
	 * @param 
	 */
	public void modifyMark(Mark mark) throws Exception {

		this.getHibernateTemplate().update(mark);
		
	}

	/**
	 * ɾ���ɼ�
	 * @param 
	 */
	public void deleteMark(String[] markIdList) throws Exception {
		
		for (int i=0; i<markIdList.length; i++) {
			Mark mark = (Mark)this.getHibernateTemplate().load(Mark.class, markIdList[i]);
			this.getHibernateTemplate().delete(mark);
		}		
	}

	/**
	 * ��ѯȫ���ɼ�
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findAllMarks() {

		List<Mark> markList = new ArrayList<Mark>();
	
		Session session = this.getSession();
		Query query = session.createQuery("from Mark m");
		markList = query.list();
	
		return markList;

	}
	
	
	/**
	 * ����Id��ѯ�ɼ�
	 * @param 
	 */
	public Mark findMarkById(String id) {

		Mark mark = (Mark)this.getHibernateTemplate().load(Mark.class, id);
		
		return mark;
	}

	/**
	 * ����������ѯ�ɼ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public PageModel listMark(int pageNo, Mark mark, Team team) {
		
		
		StringBuffer queryStr = new StringBuffer();
		boolean conditionFound = false;
		if(mark.getCourse() != null) {
			queryStr.append(" m.course=:course");
			conditionFound = true;
		}
		if(mark.getStudent() != null) {
			if(conditionFound) {
				queryStr.append(" and");
			}
			queryStr.append(" m.student=:student");
			conditionFound = true;
		}
		if(team != null) {
			if(conditionFound) {
				queryStr.append(" and");
			}
			//queryStr.append("m.student in(select t.students from Team where )");
			queryStr.append(" m.student.team=:team");
			conditionFound = true;
		}
		
		String fromClause = conditionFound ? "from Mark m where " : "from Mark m";
		queryStr.insert(0, fromClause);
		
		Query query = this.getSession().createQuery(queryStr.toString());
		
		if(mark.getCourse() != null) {
			query.setParameter("course", mark.getCourse());
		}
		
		if(mark.getStudent() != null) {
			query.setParameter("student", mark.getStudent());
		}
		
		if(team != null) {
			query.setParameter("team", team);
		}
		
		
		PageModel pageModel = null;
		List markList = query.setFirstResult((pageNo - 1) * PageModel.pageSize)
							 .setMaxResults(PageModel.pageSize)
							 .list();
		
		
		pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setList(markList);
		pageModel.setTotalRecords(getTotalRecords(mark, team));
		
		return pageModel;

	}

	/**
	 * ��ѯ��¼��
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getTotalRecords(Mark mark, Team team) {
		List markList = new ArrayList();
		
		StringBuffer queryStr = new StringBuffer();
		boolean conditionFound = false;
		if(mark.getCourse() != null) {
			queryStr.append(" m.course=:course ");
			conditionFound = true;
		}
		if(mark.getStudent() != null) {
			if(conditionFound) {
				queryStr.append(" and");
			}
			queryStr.append(" m.student=:student ");
			conditionFound = true;
		}
		if(team != null) {
			if(conditionFound) {
				queryStr.append(" and ");
			}
			//queryStr.append("m.student in(select t.students from Team where )");
			queryStr.append(" m.student.team=:team ");
			conditionFound = true;
		}
		
		String fromClause = conditionFound ? "from Mark m where " : "from Mark m ";
		queryStr.insert(0, fromClause);
		
		Query query = this.getSession().createQuery(queryStr.toString());
		
		if(mark.getCourse() != null) {
			query.setParameter("course", mark.getCourse());
		}
		
		if(mark.getStudent() != null) {
			query.setParameter("student", mark.getStudent());
		}
		
		if(team != null) {
			query.setParameter("team", team);
		}
		
		markList = query.list();
		
		return markList.size();	
	}
	
	
	/**
	 * ����ѧ����ѯ�ɼ�
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findMarkByStudent(Student student) {

		String hql = "select m from Mark m where m.student=:student";
		
		List<Mark> marks = this.getSession().createQuery(hql)
									        .setParameter("student", student)
									        .list();
		
		return marks;
	}
	
	/**
	 * ���ݰ༶�Ϳγ̼������β�ѯ�ɼ�
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findMarkByScore(Team team, Course course, Float min, Float max) {

		String hql = "select m from Mark m where m.course=:course " +
						" and m.student in(select s from Student s where s.team=:team)" +
						" and m.score>:min and m.score<:max";
		
		List<Mark> marks = this.getSession().createQuery(hql)
											.setParameter("course", course)
											.setParameter("team", team)
											.setParameter("min", min)
											.setParameter("max", max)
											.list();
		
		return marks;
	}
	
	/**
	 * ���ݰ༶�Ϳγ̲�ѯ�ɼ�
	 * @param 
	 */
	@SuppressWarnings("unchecked")
	public List<Mark> findMarkByCourse(Team team, Course course) {

		String hql = "select m from Mark m where m.course=:course " +
						" and m.student in(select s from Student s where s.team=:team) order by m.score desc";
		
		List<Mark> marks = this.getSession().createQuery(hql)
											.setParameter("course", course)
											.setParameter("team", team)
											.list();
		
		return marks;
	}

}
