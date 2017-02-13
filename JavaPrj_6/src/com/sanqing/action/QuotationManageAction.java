package com.sanqing.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Customer;
import com.sanqing.po.Product;
import com.sanqing.po.Quotation;
import com.sanqing.service.CustomerService;
import com.sanqing.service.ProductService;
import com.sanqing.service.QuotationService;
@Controller("quotationManageAction")
@Scope("prototype")
public class QuotationManageAction extends BaseAction {
	@Resource
	private QuotationService quotationService;	//����ҵ���߼����
	@Resource
	private ProductService productService ;		//��Ʒҵ���߼����
	@Resource
	private CustomerService customerService;	//�ͻ�ҵ���߼����
	private String quotationNO;					// ���۱��
	private String quotationMan;				// ������
	private String otherInfo;					// ������Ϣ
	private Product product ;					//��Ʒ��Ϣ
	private Customer customer;					//�ͻ���Ϣ
	public String addUI() {						//��ת��������Ϣ����ҳ��
		HttpServletRequest request =
				ServletActionContext.getRequest();//���request����
		request.setAttribute("products", 
				productService.getScrollData().getResultlist());//�����Ʒ��Ϣ�б�
		request.setAttribute("customers",
				customerService.getScrollData().getResultlist());//����ͻ���Ϣ�б�
		return "add";
	}
	public String add() {					//��ɱ�����Ϣ��¼��
		Quotation quotation = new Quotation();//ʵ����һ��Quotation����
		quotation.setCustomer(customer);//���ÿͻ���Ϣ
		quotation.setOtherInfo(otherInfo);//����������Ϣ
		quotation.setProduct(product);//���ò�Ʒ��Ϣ
		quotation.setQuotationNO(quotationNO);//���ñ��۱��
		quotation.setQuotationMan(quotationMan);//���ñ�����
		quotationService.save(quotation);//���汨����Ϣ
		return "pub_add_success";//��ת��¼��ɹ�ҳ��
	}
	public String updateUI() {		//��ת��������Ϣ�޸�ҳ��
		HttpServletRequest 
			request = ServletActionContext.getRequest();//���request����
		request.setAttribute("products", 
				productService.getScrollData().getResultlist());//��ò�Ʒ��Ϣ������
		request.setAttribute("customers",
				customerService.getScrollData().getResultlist());//��ÿͻ���Ϣ������
		request.setAttribute("quotation", 
				quotationService.find(quotationNO));//��ñ�����Ϣ������
		return "update";
	}
	public String update() {
		Quotation quotation = new Quotation();//ʵ����һ��Quotation����
		quotation.setCustomer(customer);//���ÿͻ���Ϣ
		quotation.setOtherInfo(otherInfo);//����������Ϣ
		quotation.setProduct(product);//���ò�Ʒ��Ϣ
		quotation.setQuotationNO(quotationNO);//���ñ��۱��
		quotation.setQuotationMan(quotationMan);//���ñ�����
		quotationService.update(quotation);//���±�����Ϣ
		return "pub_update_success";//��ת�����³ɹ�ҳ��
	}
	public String del() {//ɾ��������Ϣ
		quotationService.delete(quotationNO);//����ҵ���߼�������ɾ��
		return "pub_del_success";//��ת��ɾ���ɹ�ҳ��
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	public String query() {
		return "query";
	}
	public String getQuotationNO() {
		return quotationNO;
	}
	public void setQuotationNO(String quotationNO) {
		this.quotationNO = quotationNO;
	}
	public String getQuotationMan() {
		return quotationMan;
	}
	public void setQuotationMan(String quotationMan) {
		this.quotationMan = quotationMan;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
