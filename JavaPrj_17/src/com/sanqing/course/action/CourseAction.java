package com.sanqing.course.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sanqing.course.dao.CourseDAO;
import com.sanqing.course.dao.CourseScheduleDAO;
import com.sanqing.course.form.CourseForm;
import com.sanqing.course.model.Course;
import com.sanqing.course.model.CourseSchedule;
import com.sanqing.course.util.PageModel;


public class CourseAction extends BaseDispatchAction {

	private CourseDAO courseDao;
	private CourseScheduleDAO courseScheduleDao;


	/**
	 * ��̬�����γ�
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
		CourseForm cf = (CourseForm)form;
		String flag = request.getParameter("flag");
		Course course = new Course();
		
		if("true".equals(flag)) {
			BeanUtils.copyProperties(course, form); 
			request.getSession().setAttribute("courseCou", course);
		} else {
			course = (Course) request.getSession().getAttribute("courseCou");
		}
		
		//����ҵ���߼�����
		PageModel pageModel = courseDao.listCourse(cf.getPageNo(), course);
	
		//����ѯ����ŵ�request��
		request.setAttribute("pageModel", pageModel);
	
		return mapping.findForward("list");
	}
	
	/**
	 * �������еĿγ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Course> list = courseDao.findAllCourses();
		
		request.setAttribute("courses", list);
		
		return mapping.findForward("list");
	}

	/**
	 * ɾ���γ�
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
		CourseForm cf = (CourseForm)form;
		
		try {
			//����ҵ���߼�����
			courseDao.deleteCourse(cf.getSelectFlag());
			saveMessage(request, "courseForm.deleted");	
		} catch(Exception e) {
			saveMessage(request, "courseForm.deleted.error");	
		}
		
		ActionForward af = new ActionForward("course.do?p=list&pageNo=1", true);
		
		return af;
	}

	
	/**
	 * �༭�γ�:�����½�ҳ��,�������ҳ��
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
			
			Course course = courseDao.findCourseById(id);
			
			//��course��ֵ���Ƹ�form
			if(course != null) {
				request.setAttribute("course", course);
			}
		}
		
		return mapping.findForward("edit");
	}

	/**
	 * ����γ�:����,����
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
		
	
		CourseForm cf = (CourseForm) form;
		Course course = new Course();
		BeanUtils.copyProperties(course, cf); 

		if(cf.getId() == null || cf.getId().trim().length() == 0) {
			courseDao.addCourse(course);
			saveMessage(request, "courseForm.added", course.getName());
		} else {
			courseDao.modifyCourse(course);
			saveMessage(request, "courseForm.updated", course.getName());
		}
		
		ActionForward af = new ActionForward("course.do?p=list&pageNo=1", true);
		return af;
	}
	
	/**
	 * �鿴�γ���ϸ��Ϣ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");

		Course course = courseDao.findCourseById(id);
		
		List<CourseSchedule> courseSchedules = courseScheduleDao.findCourseScheduleByCourse(course);

		request.setAttribute("courseSchedules", courseSchedules);
		request.setAttribute("course", course);
		
		return mapping.findForward("detail");
	}

	/**
	 * @param courseDao the courseDao to set
	 */
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	public void setCourseScheduleDao(CourseScheduleDAO courseScheduleDao) {
		this.courseScheduleDao = courseScheduleDao;
	}
	
}
