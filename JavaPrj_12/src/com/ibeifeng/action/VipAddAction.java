package com.ibeifeng.action;

import java.text.SimpleDateFormat;

import com.ibeifeng.dao.VipDAO;
import com.ibeifeng.po.Vip;
import com.opensymphony.xwork2.ActionSupport;

public class VipAddAction extends ActionSupport{
	private boolean success;
	private String msg;
	
	private String name;
	private Integer age;
	private String profession;
	private String joinTime;
	
	private VipDAO vipDAO;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public VipDAO getVipDAO() {
		return vipDAO;
	}

	public void setVipDAO(VipDAO vipDAO) {
		this.vipDAO = vipDAO;
	}

	public String execute() throws Exception {
		//ֱ�ӱ���
		Vip vip = new Vip();
		vip.setName(name);
		vip.setAge(age);
		vip.setProfession(profession);
		vip.setJoinTime(new SimpleDateFormat("yyyy��MM��dd��").parse(joinTime));
		vipDAO.save(vip);
		success = true;
		msg = "VIP��Ϣ¼��ɹ�";
		return this.SUCCESS;
	}
	
}
