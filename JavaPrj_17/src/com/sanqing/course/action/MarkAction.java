package com.sanqing.course.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sanqing.course.dao.CourseDAO;
import com.sanqing.course.dao.CourseScheduleDAO;
import com.sanqing.course.dao.MarkDAO;
import com.sanqing.course.dao.StudentDAO;
import com.sanqing.course.dao.TeamDAO;
import com.sanqing.course.form.MarkForm;
import com.sanqing.course.model.Course;
import com.sanqing.course.model.Mark;
import com.sanqing.course.model.Student;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public class MarkAction extends BaseDispatchAction {

	private MarkDAO markDao;
	private CourseDAO courseDao;
	private StudentDAO studentDao;
	private TeamDAO teamDao;
	private CourseScheduleDAO courseScheduleDao;
	
	
	/**
	 * @param courseScheduleDao the courseScheduleDao to set
	 */
	public void setCourseScheduleDao(CourseScheduleDAO courseScheduleDao) {
		this.courseScheduleDao = courseScheduleDao;
	}

	/**
	 * @param markDao the markDao to set
	 */
	public void setMarkDao(MarkDAO markDao) {
		this.markDao = markDao;
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
	 * @param studentDao the studentDao to set
	 */
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * ��̬�����ɼ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//��ȡ��ҳ������ύ������ֵ
		MarkForm mf = (MarkForm)form;
		Mark mark = new Mark();
		String flag = request.getParameter("flag");
		String teamId = request.getParameter("teamId");

		Team team = null;
		
		PageModel pageModel = new PageModel();
			
		if("true".equals(flag)) {
			if(mf != null) {
				if(mf.getCourseId() != null && mf.getCourseId().trim().length() > 0) {
					Course course = courseDao.findCourseById(mf.getCourseId());
					mark.setCourse(course);
				}
				
				if(mf.getStudentId() != null && mf.getStudentId().trim().length() > 0) {
					Student student = studentDao.findStudentById(mf.getStudentId());
					mark.setStudent(student);
				}
				
				BeanUtils.copyProperties(mark, form); 
				request.getSession().setAttribute("markMar", mark);
			} else {
				request.getSession().setAttribute("markMar", null);
			}
			
			if(null != teamId && teamId.trim().length() > 0) {
				team = teamDao.findTeamById(teamId);
				request.getSession().setAttribute("teamMark", team);
			} else {
				request.getSession().setAttribute("teamMark", null);
			}

		} else {
			mark = (Mark) request.getSession().getAttribute("markMar");
			team = (Team)request.getSession().getAttribute("teamMark");
		}
		
		//����ҵ���߼�����
		pageModel = markDao.listMark(mf.getPageNo(), mark, team);
		
		//����ѯ����ŵ�request��
		request.setAttribute("pageModel", pageModel);
	
		return mapping.findForward("list");
	}
	
	/**
	 * �������еĳɼ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Mark> list = markDao.findAllMarks();
		
		request.setAttribute("marks", list);
		
		return mapping.findForward("list");
	}

	/**
	 * ɾ���ɼ�
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
		MarkForm mf = (MarkForm)form;
		
		//����ҵ���߼�����
		markDao.deleteMark(mf.getSelectFlag());
		saveMessage(request, "markForm.deleted");	
		
		ActionForward af = new ActionForward("mark.do?p=list&pageNo=1", true);
		
		return af;
	}

	
	/**
	 * �༭�ɼ�:�����½�ҳ��,�������ҳ��
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
			
			Mark mark = markDao.findMarkById(id);
			
			//��Mark��ֵ���Ƹ�form
			if(mark != null) {
				request.setAttribute("mark", mark);
			}
		}
		
		return mapping.findForward("edit");
	}

	/**
	 * ����ɼ�:����,����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Mark> marks = (List<Mark>)request.getSession().getAttribute("marks");
		
		for(int i=0; i<marks.size(); i++) {
			Mark mark = marks.get(i);
			markDao.addMark(mark);
		}
		
		saveMessage(request, "markForm.added");
		
		request.getSession().removeAttribute("marks");
		
		ActionForward af = new ActionForward("courseSchedule.do?p=input&flag=added", true);
		return af;
	}
	
	/**
	 * ��ȡ�û�������Ϣ,��װ�ɼ�,ת����ȷ�ϳɼ�ҳ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public ActionForward confirm(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String num = request.getParameter("num");
		int total = Integer.valueOf(num);
		
		List<Mark> marks = new ArrayList<Mark>();
		
		String courseId = request.getParameter("courseId");
		Course course = courseDao.findCourseById(courseId);
		
		try {
			for(int i=1; i<=total; i++) {
				String studentId = request.getParameter("studentId"+i);
				Float score = Float.valueOf(request.getParameter("score"+i));
				Student student = studentDao.findStudentById(studentId);
				Mark mark = new Mark();
				mark.setStudent(student);
				mark.setCourse(course);
				mark.setScore(score);
				marks.add(mark);
			}
		} catch(Exception e) {
			e.printStackTrace();
			saveMessage(request, "markForm.added.error");
			ActionForward af = new ActionForward("courseSchedule.do?p=input", true);
			return af;
		}
		
		request.getSession().setAttribute("marks", marks);
		
		return mapping.findForward("confirm");
	}
	
	/**
	 * �޸ĳɼ�:����,����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MarkForm markForm = (MarkForm) form;
		
		Mark mark = markDao.findMarkById(markForm.getId());
		mark.setScore(Float.valueOf(markForm.getScore()));
		
		markDao.modifyMark(mark);
		saveMessage(request, "markForm.updated");
		
		ActionForward af = new ActionForward("mark.do?p=list&pageNo=1&flag=true", true);
		return af;
		
	}
	
	/**
	 * �ɼ����ܷ���ת��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward analyse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("analyse");
	}
	
	/**
	 * �༶�ɼ�����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward analyseTeam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String teamId = request.getParameter("teamId");
		
		Team team = teamDao.findTeamById(teamId);
		
		List<Course> courses = courseScheduleDao.findCourseByTeam(team);
		
		request.setAttribute("courses", courses);
		
		Set<Student> students = team.getStudents(); 
		
		List marks = new ArrayList();

		for(Iterator iter=students.iterator(); iter.hasNext();) {
			Student student = (Student)iter.next();
			List marksNew = markDao.findMarkByStudent(student);
			marks.addAll(marksNew);
		}

		request.setAttribute("marks1", marks);
		
		return mapping.findForward("analyse");
	}

	
	/**
	 * �༶�ɼ�����(ĳ�ſγ�ָ�������εĿ��Գɼ�)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward analyseScore(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String teamId = request.getParameter("teamId");
		String courseId = request.getParameter("courseId");
		
		Float min = new Float(0);
		Float max = new Float(0);
		Team team = null;
		Course course = null;
		
		try {
			min = Float.valueOf(request.getParameter("min"));
			max = Float.valueOf(request.getParameter("max"));
		} catch(Exception e) {
			e.printStackTrace();
			saveMessage(request, "markForm.analyse.error");
		}

		if(null!= teamId && teamId.trim().length()>0) {
			team = teamDao.findTeamById(teamId);
		}
		
		if(null!= courseId && courseId.trim().length()>0) {
			course = courseDao.findCourseById(courseId);
		}
		
		List<Mark> marks = markDao.findMarkByScore(team, course, min, max);
		request.setAttribute("marks2", marks);

		return mapping.findForward("analyse");
	}
	
	/**
	 * �༶�ɼ�����(ĳ�ſ��Գɼ�)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward analyseCourse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Team team = null;
		Course course = null;
		
		String teamId = request.getParameter("teamId");
		String courseId = request.getParameter("courseId");
		
		if(null!= teamId && teamId.trim().length()>0) {
			team = teamDao.findTeamById(teamId);
		}
		
		if(null!= courseId && courseId.trim().length()>0) {
			course = courseDao.findCourseById(courseId);
		}

		List<Mark> marks = markDao.findMarkByCourse(team, course);
		request.setAttribute("marks3", marks);

		return mapping.findForward("analyse");
	}

}


