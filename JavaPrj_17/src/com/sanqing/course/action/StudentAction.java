package com.sanqing.course.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sanqing.course.dao.CourseDAO;
import com.sanqing.course.dao.StudentDAO;
import com.sanqing.course.dao.TeacherDAO;
import com.sanqing.course.dao.TeamDAO;
import com.sanqing.course.form.StudentForm;
import com.sanqing.course.model.Course;
import com.sanqing.course.model.Student;
import com.sanqing.course.model.Teacher;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public class StudentAction extends BaseDispatchAction {

	private StudentDAO studentDao;
	private TeamDAO teamDao;
	private CourseDAO courseDao;
	private TeacherDAO teacherDao;


	/**
	 * ��̬����ѧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward count(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Team team = null;
		Course course = null;
		Teacher teacher = null;
		
		String teamId = request.getParameter("teamId");
		String courseId = request.getParameter("courseId");
		String teacherId = request.getParameter("teacherId");
		//String pageNo = request.getParameter("pageNo");
		StudentForm sf = (StudentForm)form;
		
		String flag = request.getParameter("flag");
		
		if("true".equals(flag)) {

			if(null != teamId && teamId.trim().length() > 0) {
				team = teamDao.findTeamById(teamId);
				request.getSession().setAttribute("teamStu", team);
			} else {
				request.getSession().setAttribute("teamStu", null);
			}
			
				
			
			if(null != courseId && courseId.trim().length() > 0) {
				course = courseDao.findCourseById(courseId);
				request.getSession().setAttribute("courseStu", course);
			} else {
				request.getSession().setAttribute("courseStu", null);
			}
			
			if(null != teacherId && teacherId.trim().length() > 0) {
				teacher = teacherDao.findTeacherById(teacherId);
				request.getSession().setAttribute("teacherStu", teacher);
			} else {
				request.getSession().setAttribute("teacherStu", null);
			}

		} else {
			team = (Team) request.getSession().getAttribute("teamStu");
			course = (Course) request.getSession().getAttribute("courseStu");
			teacher = (Teacher) request.getSession().getAttribute("teacherStu");
		}
		
		//����ҵ���߼�����
		PageModel pageModel = studentDao.countStudent(sf.getPageNo(), team, course, teacher);
	
		//����ѯ����ŵ�request��
		request.setAttribute("pageModel", pageModel);
	
		return mapping.findForward("count");
	}
	
	/**
	 * ��̬ͳ��ѧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ȡ��ҳ������ύ������ֵ
		StudentForm sf = (StudentForm)form;
		Student student = new Student();
		
		String flag = request.getParameter("flag");
		
		if("true".equals(flag)) {
			BeanUtils.copyProperties(student, form); 
			request.getSession().setAttribute("studentStu", student);
		} else {
			student = (Student) request.getSession().getAttribute("studentStu");
		}
		
		//����ҵ���߼�����
		PageModel pageModel = studentDao.listStudent(sf.getPageNo(), student);
	
		//����ѯ����ŵ�request��
		request.setAttribute("pageModel", pageModel);
	
		return mapping.findForward("list");
	}
	
	/**
	 * �������е�ѧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Student> list = studentDao.findAllStudents();
		
		request.setAttribute("students", list);
		
		return mapping.findForward("list");
	}

	/**
	 * ɾ��ѧ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ȡ��ҳ������ύ������ֵ
		StudentForm sf = (StudentForm)form;
		try {
			//����ҵ���߼�����
			studentDao.deleteStudent(sf.getSelectFlag());
			saveMessage(request, "studentForm.deleted");
		} catch(Exception e) {
			e.printStackTrace();
			saveMessage(request, "studentForm.deleted.error");
		}

		ActionForward af = new ActionForward("student.do?p=list&pageNo=1", true);
		
		return af;
	}

	
	/**
	 * �༭ѧ��:�����½�ҳ��,�������ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		if(id != null && id.trim().length() > 0) {
			
			Student student = studentDao.findStudentById(id);
			
			//��Student��ֵ���Ƹ�form
			if(student != null) {
				request.setAttribute("student", student);
			}
		}
		
		List<Team> teams = teamDao.findAllTeams();
		request.setAttribute("teams", teams);
		
		return mapping.findForward("edit");
	}

	/**
	 * ����ѧ��:����,����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		StudentForm sf = (StudentForm) form;
		Student student = new Student();
		BeanUtils.copyProperties(student, sf); 
		
		Team team = new Team();
		team.setId(sf.getTeamId());
		student.setTeam(team);

		if(sf.getId() == null || sf.getId().trim().length() == 0) {
			studentDao.addStudent(student);
			saveMessage(request, "studentForm.added", student.getName());
		} else {
			studentDao.modifyStudent(student);
			saveMessage(request, "studentForm.updated", student.getName());
		}
		
		ActionForward af = new ActionForward("student.do?p=list&pageNo=1", true);
		return af;
	}

	/**
	 * @param studentDao the studentDao to set
	 */
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * @param teamDao the teamDao to set
	 */
	public void setTeamDao(TeamDAO teamDao) {
		this.teamDao = teamDao;
	}

	/**
	 * @param courseDao the courseDao to set
	 */
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	/**
	 * @param teacherDao the teacherDao to set
	 */
	public void setTeacherDao(TeacherDAO teacherDao) {
		this.teacherDao = teacherDao;
	}

}
