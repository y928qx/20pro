package com.sanqing.course.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sanqing.course.dao.CourseScheduleDAO;
import com.sanqing.course.dao.TeamDAO;
import com.sanqing.course.form.TeamForm;
import com.sanqing.course.model.CourseSchedule;
import com.sanqing.course.model.Team;
import com.sanqing.course.util.PageModel;


public class TeamAction extends BaseDispatchAction {

	private TeamDAO teamDao;
	private CourseScheduleDAO courseScheduleDao;


	/**
	 * @param teamDao the teamDao to set
	 */
	public void setTeamDao(TeamDAO teamDao) {
		this.teamDao = teamDao;
	}
	
	/**
	 * @param courseScheduleDAO the courseScheduleDAO to set
	 */
	public void setCourseScheduleDao(CourseScheduleDAO courseScheduleDao) {
		this.courseScheduleDao = courseScheduleDao;
	}

	/**
	 * ��̬�����༶
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
		TeamForm tf = (TeamForm)form;
		Team team = new Team();
		String flag = request.getParameter("flag");
		
		if("true".equals(flag)) {
			BeanUtils.copyProperties(team, form); 
			request.getSession().setAttribute("teamTem", team);
		} else {
			team = (Team) request.getSession().getAttribute("teamTem");
		}
		
		//����ҵ���߼�����
		PageModel pageModel = teamDao.listTeam(tf.getPageNo(), team);
	
		//����ѯ����ŵ�request��
		request.setAttribute("pageModel", pageModel);
	
		return mapping.findForward("list");
	}
	
	/**
	 * �������еİ༶
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Team> list = teamDao.findAllTeams();
		
		request.setAttribute("teams", list);
		
		return mapping.findForward("list");
	}

	/**
	 * ɾ���༶
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
		TeamForm tf = (TeamForm)form;
		
		try {
			//����ҵ���߼�����
			teamDao.deleteTeam(tf.getSelectFlag());
			saveMessage(request, "teamForm.deleted");	
		} catch(Exception e) {
			e.printStackTrace();
			saveMessage(request, "teamForm.deleted.error");	
		}

		
		ActionForward af = new ActionForward("team.do?p=list&pageNo=1", true);
		
		return af;
	}

	
	/**
	 * �༭�༶:�����½�ҳ��,�������ҳ��
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
			
			Team team = teamDao.findTeamById(id);
			
			//��course��ֵ���Ƹ�form
			if(team != null) {
				request.setAttribute("team", team);
			}
		}
		
		return mapping.findForward("edit");
	}

	/**
	 * ����༶:����,����
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
		
		
		TeamForm tf = (TeamForm) form;
		Team team = new Team();
		BeanUtils.copyProperties(team, tf); 

		if(tf.getId() == null || tf.getId().trim().length() == 0) {
			teamDao.addTeam(team);
			saveMessage(request, "teamForm.added", team.getName());
		} else {
			teamDao.modifyTeam(team);
			saveMessage(request, "teamForm.updated", team.getName());
		}
		
		ActionForward af = new ActionForward("team.do?p=list&pageNo=1", true);
		return af;
	}

	/**
	 * �鿴�༶��ϸ��Ϣ
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

		Team team = teamDao.findTeamById(id);
		
		List<CourseSchedule> courseSchedules = courseScheduleDao.findCourseScheduleByTeam(team);

		request.setAttribute("courseSchedules", courseSchedules);
		request.setAttribute("team", team);
		
		return mapping.findForward("detail");
	}
	

}
