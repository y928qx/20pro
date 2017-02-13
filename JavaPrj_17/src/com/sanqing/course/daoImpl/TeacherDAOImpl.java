package com.sanqing.course.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.course.dao.TeacherDAO;
import com.sanqing.course.model.Teacher;
import com.sanqing.course.util.PageModel;



/**
 * 
 * @author Administrator
 *
 */
public class TeacherDAOImpl extends HibernateDaoSupport implements TeacherDAO {

	/**
	 * ��ӽ�ʦ
	 * @param 
	 */
	public void addTeacher(Teacher teacher) throws Exception{
		
		this.getHibernateTemplate().save(teacher);

	}

	/**
	 * �޸Ľ�ʦ
	 * @param 
	 */
	public void modifyTeacher(Teacher teacher) throws Exception {

		this.getHibernateTemplate().update(teacher);
		
	}

	/**
	 * ɾ����ʦ
	 * @param 
	 */
	public void deleteTeacher(String[] teacherIdList) throws Exception {
		
		for (int i=0; i<teacherIdList.length; i++) {
			Teacher teacher = (Teacher)this.getHibernateTemplate().load(Teacher.class, teacherIdList[i]);
			this.getHibernateTemplate().delete(teacher);
		}		
	}

	/**
	 * ��ѯȫ����ʦ
	 */
	@SuppressWarnings("unchecked")
	public List<Teacher> findAllTeachers() {

		List<Teacher> teacherList = new ArrayList<Teacher>();
	
		Session session = this.getSession();
		Query query = session.createQuery("from Teacher c");
		teacherList = query.list();
	
		return teacherList;

	}
	
	
	/**
	 * ����Id��ѯ��ʦ
	 * @param 
	 */
	public Teacher findTeacherById(String id) {

		Teacher teacher = (Teacher)this.getHibernateTemplate().load(Teacher.class, id);
		
		return teacher;
	}

	/**
	 * ����������ѯ��ʦ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public PageModel listTeacher(int pageNo, Teacher teacher) {
		
		PageModel pageModel = null;
		List teacherList = new ArrayList();
		
		Example exampleTeacher = Example.create(teacher)
									 .enableLike(MatchMode.ANYWHERE)
									 .ignoreCase();
									 
		
		teacherList = this.getSession().createCriteria(Teacher.class)
									.add(exampleTeacher)
									.setFirstResult((pageNo - 1) * PageModel.pageSize)
									.setMaxResults(PageModel.pageSize)
									.list();
		
		pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setList(teacherList);
		pageModel.setTotalRecords(getTotalRecords(teacher));
		
		return pageModel;

	}

	/**
	 * ��ѯ��¼��
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getTotalRecords(Teacher teacher) {
		
		List teacherList = new ArrayList();
		
		Example exampleTeacher = Example.create(teacher)
		 							 .enableLike(MatchMode.ANYWHERE)
		 							 .ignoreCase();
		
		teacherList = this.getSession().createCriteria(Teacher.class)
											   .add(exampleTeacher)
											   .list();
		return teacherList.size();
	}

}
