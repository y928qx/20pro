package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Product;
import com.sanqing.service.ProductService;
import com.sanqing.util.PageView;
/**
 * ��ʾ��Ʒ
 */
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction {
	@Resource
	private ProductService productService;
	/* ��Ʒ��� */
	private String productNO;
	// ��Ʒ���ͱ��
	private String producttypeNO;
	//��Ʒ��������
	private String producttypeName;
	/* ��Ʒ���� */
	private String productName;
	/* ��Ʒ�������� */
	private String productArea;
	/* ��Ʒ������ */
	private String productOwner;
	/* ��Ʒ��λ */
	private String unit;
	/* ��Ʒ�۸� */
	private double price;
	/* ��Ʒ����*/
	private int quantity;
	/* ������Ϣ */
	private String otherInfo;
	
	@Override
	public String execute() throws Exception {
		PageView<Product> pageView = new PageView<Product>(5, getPage());
		StringBuffer jpql = new StringBuffer("");
		List<Object> params = new ArrayList<Object>();
		if("true".equals(getQuery())) {
			if(productNO!=null && !"".equals(productNO.trim())) {
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.productNO=?").append(params.size()+1);
				params.add(productNO);
			}
			if(producttypeName!=null && !"".equals(producttypeName.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.productType.producttypeName like ?").append(params.size()+1);
				params.add(producttypeName);
			}
			if(productName!=null && !"".equals(productName.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.productName like ?").append(params.size()+1);
				params.add(productName);
			}
			if(productArea!=null && !"".equals(productArea.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.productArea like ?").append(params.size()+1);
				params.add(productArea);
			}
			if(productOwner!=null && !"".equals(productOwner.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.productOwner like ?").append(params.size()+1);
				params.add(productOwner);
			}
			if(unit!=null && !"".equals(unit.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.unit like ?").append(params.size()+1);
				params.add(unit);
			}
			if(price>0) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.price=?").append(params.size()+1);
				params.add(price);
			}
			if(quantity>0) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.quantity=?").append(params.size()+1);
				params.add(quantity);
			}
			if(otherInfo!=null && !"".equals(otherInfo.trim())) {
				if(params.size()>0)jpql.append(" and ");
				jpql.append(" o.otherInfo like ?").append(params.size()+1);
				params.add(otherInfo);
			}
			pageView.setQueryResult(productService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),jpql.toString(), params.toArray()));
		}else{
			pageView.setQueryResult(productService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pageView", pageView);
		return this.SUCCESS;
	}
	public String getProductNO() {
		return productNO;
	}
	public void setProductNO(String productNO) {
		this.productNO = productNO;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductArea() {
		return productArea;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	public String getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getProducttypeNO() {
		return producttypeNO;
	}
	public void setProducttypeNO(String producttypeNO) {
		this.producttypeNO = producttypeNO;
	}
	public String getProducttypeName() {
		return producttypeName;
	}
	public void setProducttypeName(String producttypeName) {
		this.producttypeName = producttypeName;
	}

}
