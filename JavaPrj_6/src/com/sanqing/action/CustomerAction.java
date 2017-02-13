package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Customer;
import com.sanqing.service.CustomerService;
import com.sanqing.util.PageView;

/**
 * �ͻ���ʾaction
 */
@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends BaseAction{
	@Resource
	private CustomerService customerService;//ע��ͻ�ҵ�����
	private String customerNO;				//�ͻ����
	private String customerName;			//�ͻ�����
	private String phone;					//�ͻ��绰
	private String address;					//�ͻ���ַ
	private String relationman;				//�ͻ���ϵ��
	private String otherInfo;				//����
	@Override
public String execute() throws Exception {
	PageView<Customer> pageView = 
					new PageView<Customer>(5, getPage());//���÷�ҳ��Ϣ��ÿҳ��ʾ5����¼
	StringBuffer jpql = new StringBuffer("");			//��ʼ��������ѯ���
	List<Object> params = new ArrayList<Object>();		//��ʼ����ѯ�����б�
	if("true".equals(getQuery())) {						//�Ƿ�Ϊ������ѯ
		if(customerNO!=null && !"".equals(customerNO.trim())) {//���ݿͻ���Ž��в�ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.customerNO like ?").append(params.size()+1);
			params.add("%"+ customerNO +"%");
		}
		if(customerName!=null && !"".equals(customerName.trim())) {//���ݿͻ����Ʋ�ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.customerName like ?").append(params.size()+1);
			params.add("%"+customerName+"%");
		}
		if(phone!=null && !"".equals(phone.trim())) {//���ݵ绰�����ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.phone like ?").append(params.size()+1);
			params.add("%"+phone+"%");
		}
		if(address!=null && !"".equals(address.trim())) {//���ݵ�ַ��ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.address like ?").append(params.size()+1);
			params.add("%"+address+"%");
		}
		if(relationman!=null && !"".equals(relationman.trim())) {//������ϵ�˲�ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.relationman like ?").append(params.size()+1);
			params.add("%"+relationman+"%");
		}
		if(otherInfo!=null && !"".equals(otherInfo.trim())) {//����������Ϣ��ѯ
			if(params.size()>0) jpql.append(" and ");
			jpql.append(" o.otherInfo like ?").append(params.size()+1);
			params.add("%"+otherInfo+"%");
		}
		pageView.setQueryResult(customerService.getScrollData(
				pageView.getFirstResult(), pageView.getMaxresult(),
				jpql.toString(), params.toArray()));//��������ѯ
	}else{
		pageView.setQueryResult(customerService.getScrollData
				(pageView.getFirstResult(), pageView.getMaxresult()));//��ѯ���м�¼
	}
	HttpServletRequest request = ServletActionContext.getRequest();//���request����
	request.setAttribute("pageView", pageView);//���浽request��Χ
	return this.SUCCESS;
}

	public String getCustomerNO() {
		return customerNO;
	}
	public void setCustomerNO(String customerNO) {
		this.customerNO = customerNO;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRelationman() {
		return relationman;
	}
	public void setRelationman(String relationman) {
		this.relationman = relationman;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
