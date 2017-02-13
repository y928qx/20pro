/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.sanqing.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sanqing.struts.form.RoleEditorForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-18-2008
 * 
 * XDoclet definition:
 * @struts.action path="/roleEditor" name="roleEditorForm" input="/form/systemManage/roleEditor.jsp" scope="request" validate="true"
 */
public class RoleEditorAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		RoleEditorForm roleEditorForm = (RoleEditorForm) form;// TODO Auto-generated method stub
		try{
			PrintWriter out = response.getWriter();
			try{
				String oper = request.getParameter("oper");
				com.sanqing.bll.BRoleMaster B_V = new com.sanqing.bll.BRoleMaster();
				if(oper.equals("add"))
				{
					B_V.RoleMasterAdd(roleEditorForm);
				}
				else if(oper.equals("edit"))
				{
					B_V.RoleMasterEdit(roleEditorForm);
				}
				else if(oper.equals("delete"))
				{
					B_V.RoleMasterDelete(roleEditorForm.getRole_id());
				}
				out.print(B_V.RoleMasterConvertToHTMLTable());	
				
			}
			catch(Exception e){
				out.print(e.getMessage());
			}
		
		}catch(IOException e1){
			e1.printStackTrace();
		}
		return null;
	}
}