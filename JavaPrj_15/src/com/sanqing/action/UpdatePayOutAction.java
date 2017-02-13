package com.sanqing.action;

import java.text.SimpleDateFormat;

import com.sanqing.dao.PayOutDAO;
import com.sanqing.po.PayOut;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePayOutAction extends ActionSupport {
	private int id;
	private String field;
	private String value;
	private PayOutDAO payOutDAO;
	private boolean success;
	private String msg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PayOutDAO getPayOutDAO() {
		return payOutDAO;
	}

	public void setPayOutDAO(PayOutDAO payOutDAO) {
		this.payOutDAO = payOutDAO;
	}

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

	public String execute() throws Exception {
		//ȡ�ø�id��Ӧ��֧����¼
		PayOut payOut = payOutDAO.findById(id);
		//�жϸ�id��Ӧ��֧����¼�Ƿ����
		if(payOut == null) {
			success = false;
			msg = "����֧����¼��Ϣʧ��!";
		} else {
			//����field��֪����Ҫ�����ĸ�����
			if("payOutName".equals(field)) {
				payOut.setPayOutName(value);
			} else if("payOutMoney".equals(field)) {
				payOut.setPayOutMoney(Double.parseDouble(value));
			} else if("payOutDate".equals(field)){
				payOut.setPayOutDate(new SimpleDateFormat("yyyy��MM��dd��").parse(value));
			}
			payOutDAO.attachDirty(payOut);
			success = true;
			msg = "֧����¼�������ݳɹ�!";
		}
		return this.SUCCESS;
	}

}
