package com.sanqing.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sanqing.dao.PayOutDAO;
import com.sanqing.dao.UserDAO;
import com.sanqing.po.PayOut;
import com.sanqing.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetPayOutAction extends ActionSupport {
	private UserDAO userDAO;
	private PayOutDAO payOutDAO;

	private List<PayOut> allPayOut;
	private int start;
	private int limit;
	private int recordSize;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public PayOutDAO getPayOutDAO() {
		return payOutDAO;
	}

	public void setPayOutDAO(PayOutDAO payOutDAO) {
		this.payOutDAO = payOutDAO;
	}

	public List<PayOut> getAllPayOut() {
		return allPayOut;
	}

	public void setAllPayOut(List<PayOut> allPayOut) {
		this.allPayOut = allPayOut;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}

	public String execute() throws Exception {
		//����ȡ���û���Ϣ
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		User user = (User) userDAO.findByUsername(username).get(0);
		
		
		//�ܼ�¼��
		recordSize = payOutDAO.findByProperty("user", user).size();
		
		//�����û���Ϣȡ��֧����¼
		allPayOut = payOutDAO.findByProperty("user", user,start,limit);
		//����ܽ��
		double allMoney = 0.0;
		Date lastDate = new Date();
		for(PayOut payOut: allPayOut) {
			Date getDate = payOut.getPayOutDate();
			if(getDate.after(lastDate)) {
				lastDate = getDate;
			}
			allMoney = allMoney + payOut.getPayOutMoney();
		}
		//������֯һ��PayOut����
		PayOut totalPayOut = new PayOut();
		totalPayOut.setPayOutName("�ܽ��");
		totalPayOut.setPayOutMoney(allMoney);
		totalPayOut.setPayOutDate(lastDate);
		allPayOut.add(totalPayOut);
		
		return this.SUCCESS;
	}
}
