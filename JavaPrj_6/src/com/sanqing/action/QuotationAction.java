package com.sanqing.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Customer;
import com.sanqing.po.Product;
import com.sanqing.po.Quotation;
import com.sanqing.service.QuotationService;
import com.sanqing.util.PageView;

@Controller("quotationAction")
@Scope("prototype")
public class QuotationAction extends BaseAction {
	@Resource
	private QuotationService quotationService;	//����ҵ���߼����
	// ���۱��
	private String quotationNO;
	// ������
	private String quotationMan;
	// ����ʱ��
	private Date quotationtime;
	// ����
	private String otherInfo;
	//��Ʒ
	private Product product ;
	private String productName;
	//�ͻ�
	private Customer customer;
	private String customerName;
	
	
	
	@Override
	public String execute() throws Exception {
		PageView<Quotation> pageView =
				new PageView<Quotation>(5, getPage());//���÷�ҳ��Ϣ
		StringBuffer jpql = new StringBuffer("");//��ʼ��������ѯ���
		List<Object> params = new ArrayList<Object>();//��ʼ����ѯ����
		if("true".equals(getQuery())) {	//��������ѯ
			if(quotationNO!=null && !"".equals(quotationNO)) {//���ݱ��۱�Ž��в�ѯ
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.quotationNO = ?").append(params.size()+1);
				params.add(quotationNO);
			}
			if(quotationMan!=null && !"".equals(quotationMan)) {//���ݱ����˽��в�ѯ
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.quotationMan like ?").append(params.size()+1);
				params.add(quotationMan);
			}
			if(otherInfo!=null && !"".equals(otherInfo)) {//����������Ϣ���в�ѯ
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.otherInfo like ?").append(params.size()+1);
				params.add(otherInfo);
			}
			if(productName!=null && !"".equals(productName)) {//���ݲ�Ʒ���ƽ��в�ѯ
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.product.productName like ?").append(params.size()+1);
				params.add(productName);
			}
			if(customerName!=null && !"".equals(customerName)) {//���ݿͻ����ƽ��в�ѯ
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.customer.customerName = ?").append(params.size()+1);
				params.add(customerName);
			}
			pageView.setQueryResult(quotationService.getScrollData(pageView.getFirstResult(),
						pageView.getMaxresult(),jpql.toString(),params.toArray()));//���������в�ѯ
		}else{
			pageView.setQueryResult(quotationService.getScrollData(
						pageView.getFirstResult(), pageView.getMaxresult()));//��ѯ���м�¼
		}
		HttpServletRequest request = ServletActionContext.getRequest();//���request����
		request.setAttribute("pageView", pageView);//���浽request��Χ
		return this.SUCCESS;
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
	public Date getQuotationtime() {
		return quotationtime;
	}
	public void setQuotationtime(Date quotationtime) {
		this.quotationtime = quotationtime;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
