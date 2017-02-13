package com.sanqing.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Customer;
import com.sanqing.service.CustomerService;
/**
 * �ͻ�����action
 */
@Controller("customerManageAction")
@Scope("prototype")
public class CustomerManageAction extends BaseAction {
	@Resource
	private CustomerService customerService;//ע��ͻ�ҵ���߼����
	private String customerNO;				//�ͻ����
	private String customerName;			//�ͻ�����
	private String phone;					//�ͻ��绰
	private String address;					//�ͻ���ַ
	private String relationman;				//�ͻ���ϵ��
	private String otherInfo;				//������Ϣ
	public String addUI() {					//�����ͻ��������
		return "add";
	}
	public String add() {				//�����ͻ�����
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setCustomerNO(customerNO);
		customer.setCustomerName(customerName);
		customer.setOtherInfo(otherInfo);
		customer.setPhone(phone);
		customer.setRelationman(relationman);
		customerService.save(customer);
		return "pub_add_success";
	}
	public String updateUI() {	//�÷���������ת���ͻ���Ϣ���±�
		Customer customer = customerService.find(customerNO);//��ѯ�ÿͻ���Ŷ�Ӧ�Ŀͻ�
		HttpServletRequest request = ServletActionContext.getRequest();//���request����
		request.setAttribute("customer", customer);//���ͻ���Ϣ������request��Χ
		return "update";//��ת���ͻ���Ϣ���±�ҳ
	}
	
	public String update() {
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setCustomerNO(customerNO);
		customer.setCustomerName(customerName);
		customer.setOtherInfo(otherInfo);
		customer.setPhone(phone);
		customer.setRelationman(relationman);
		customerService.update(customer);//���¿ͻ���Ϣ
		return "pub_update_success";//��ת�����³ɹ�ҳ��
	}
	/**
	 * ɾ���ͻ�
	 * @return
	 */
	public String del() {		//ɾ���ͻ���Ϣ
		customerService.delete(customerNO);//���ݿͻ����ɾ���ͻ�
		return "pub_del_success";//��ת��ɾ���ɹ�ҳ
	}
	/**
	 * ��ѯ�ͻ���Ϣ
	 * @return
	 */
	public String query() {
		return "query";
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
