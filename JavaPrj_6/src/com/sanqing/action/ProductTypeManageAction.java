package com.sanqing.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.ProductType;
import com.sanqing.service.ProductTypeService;

@Controller("productTypeManageAction")
@Scope("prototype")
public class ProductTypeManageAction extends BaseAction {

	@Resource
	private ProductTypeService productTypeService ;
	// ��Ʒ���ͱ��
	private String producttypeNO;
	// ��Ʒ��������
	private String producttypeName;
	/**
	 * ��Ӳ�Ʒ����������
	 * @return
	 */
	public String addUI() {
		return "add";
	}
	/**
	 * ��Ӳ�Ʒ���
	 * @return
	 */
	public String add() {
		ProductType productType = new ProductType();
		productType.setProducttypeNO(producttypeNO);
		productType.setProducttypeName(producttypeName);
		productTypeService.save(productType);
		return "pub_add_success";
	}
	/**
	 * �޸Ĳ�Ʒ����������
	 * @return
	 */
	public String updateUI() {
		ProductType productType = productTypeService.find(producttypeNO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productType", productType);
		return "update";
	}
	/**
	 * �޸Ĳ�Ʒ���
	 * @return
	 */
	public String update() {
		ProductType productType = new ProductType();
		productType.setProducttypeNO(producttypeNO);
		productType.setProducttypeName(producttypeName);
		productTypeService.update(productType);
		return "pub_update_success";
	}
	/**
	 * ɾ����Ʒ���
	 * @return
	 */
	public String del() {
		productTypeService.delete(producttypeNO);
		return "pub_del_success";
	}
	/**
	 * ��Ʒ����ѯ
	 * @return
	 */
	public String query() {
		return "query";
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
