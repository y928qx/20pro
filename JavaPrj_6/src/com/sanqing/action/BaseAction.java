package com.sanqing.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ������action
 */
public class BaseAction extends ActionSupport {
	public Integer page;	//��ǰҳ��Ϣ
	public String query;	//�Ƿ�Ϊ������ѯ
	public Integer getPage() {//��õ�ǰҳ��Ϣ
		return page = (page==null || page<1)? 1 : page;
	}
	public void setPage(Integer page) {//���õ�ǰҳ��Ϣ
		this.page = page;
	}
	public String getQuery() {//���query��Ϣ
		return query;
	}
	public void setQuery(String query) {//����query��Ϣ
		this.query = query;
	}
}
