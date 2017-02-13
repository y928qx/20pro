/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.sanqing.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.sanqing.po.SysRight;
import com.sanqing.po.SysRole;
import com.sanqing.po.SysRoleRight;
import com.sanqing.service.RoleService;
import com.sanqing.util.PageResult;
import com.sanqing.util.RightList;

public class RoleAction extends DispatchAction {
	private RoleService roleService = null;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// 如果没有传递actionType，默认执行这个方法
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("默认方法...");
		// 默认去入口
		PrintWriter out = response.getWriter();
		out.print("允许访问");
		return null;
	}

	// 查询客户服务信息
	public ActionForward doList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("查询客户服务信息");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 从页面接收参数
		LazyDynaBean ldb = new LazyDynaBean();
		BeanUtils.populate(ldb, request.getParameterMap());
		Map paramMap = ldb.getMap();
		PageResult pgr = (PageResult) roleService.findAllRole(paramMap);
		System.out.println("总共有" + pgr.getRowCount() + "条客户服务信息");
		// 转换成JSON数据
		String jsonString = JSONSerializer.toJSON(pgr).toString();
		System.out.println(jsonString);
		out.print(jsonString);
		return null;
	}

	// 找出所有的权限
	public ActionForward dofindAllRightName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("查所有的权限");
		PrintWriter out = response.getWriter();
		RightList rl1 = roleService.findAllRight();
		// 转换成JSON数据
		String str1 = JSONSerializer.toJSON(rl1).toString();
		System.out.println(str1);
		out.print(str1);
		return null;
	}

	// 根据角色找出它有或没有的权限
	public ActionForward dofindRightName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("查拥有的权限");
		PrintWriter out = response.getWriter();
		String roleId = request.getParameter("roleId");
		String type = request.getParameter("type");
		System.out.println("角色编号为：" + roleId);
		RightList rl1 = roleService.findRightByRoleId(Long.parseLong(roleId));
		// 转换成JSON数据
		String str1 = JSONSerializer.toJSON(rl1).toString();
		System.out.println(str1);
		out.print(str1);
		return null;
	}

	// 删除
	public ActionForward doDel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("编号：" + request.getParameter("roleId"));
		try {
			SysRole sysRole = roleService.findByRoleId(Long.parseLong(request
					.getParameter("roleId")));
			roleService.del(sysRole);
			out.print("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("系统异常,删除失败");
		}
		return null;
	}

	// 保存
	public ActionForward doSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("添加角色");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		SysRole sysRole = new SysRole();
		sysRole.setRoleName(request.getParameter("roleName"));
		sysRole.setRoleDesc(request.getParameter("roleDesc"));
		try {
			System.out.println("添加角色");
			roleService.add(sysRole);
			out.print("{success:true,msg:'保存成功'}");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{success:false,msg:'保存失败'}");
		}
		return null;
	}

	// 设置角色权限
	public ActionForward doUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		System.out.println("修改角色权限");
		Long roleId = Long.parseLong(request.getParameter("roleId"));
		System.out.println("角色编号：" + roleId);
		List<SysRoleRight> sysRR = roleService.findIdByRoleId(roleId);
		for (int i = 0; i < sysRR.size(); i++) {
			roleService.deleteRight(sysRR.get(i));
		}
		String rights = request.getParameter("rightSelector");
		System.out.println(rights);

		String[] str = rights.split(",");
		// for (int j = 0; j < str.length; j++) {
		// System.out.println("bbbb:" + str[j]);
		// }
		// for (int i = 0; i < rights.length(); i++) {
		// index=rights.lastIndexOf(",");
		// String right = rights.substring(index + 1);

		// String right1=rights.substring(0, arg1)
		// rights = rights.substring(0, index);
		// list.add(right);
		// System.out.println("aaaa:"+right);
		// }

		boolean isSuccess = false;
		SysRoleRight srr = null;
		for (int i = 0; i < str.length; i++) {
			System.out.println("权限编号：" + str[i]);
			srr = new SysRoleRight();
			SysRole role = new SysRole();
			role.setRoleId(roleId);
			srr.setSysRole(role);
			SysRight right = new SysRight();
			right.setRightCode(Long.parseLong(str[i]));
			System.out.println("要添加的编号:" + right.getRightCode());
			srr.setSysRight(right);
			try {
				roleService.updateRight(srr);
				isSuccess = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (isSuccess == true) {
			out.print("{success:true,msg:'保存成功'}");
		} else {
			out.print("{success:false,msg:'系统异常,保存失败'}");
		}

		return null;
	}
}