package com.sanqing.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Product;
import com.sanqing.po.ProductType;
import com.sanqing.service.ProductService;
import com.sanqing.service.ProductTypeService;
/**
 * ��Ʒ����
 */
@Controller("productManageAction")
@Scope("prototype")
public class ProductManageAction extends BaseAction {

	@Resource
    private	ProductService productService;
    @Resource
    private ProductTypeService productTypeService;
    
    /* ��Ʒ��� */
	private String productNO;
	// ��Ʒ���ͱ��
	private String producttypeNO;
	/* ��Ʒ���� */
	private String productName;
	/* ��Ʒ�������� */
	private String producingArea;
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
    /**
     * ��Ӳ�Ʒ�������
     * @return
     */
	public String addUI() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<ProductType> producttypes = productTypeService.getScrollData().getResultlist();
		request.setAttribute("producttypes", producttypes);
		return "add";
	}
    /**
     * ��Ӳ�Ʒ
     * @return
     */
	public String add() {
		Product product = new Product();
		product.setProductNO(productNO);
		product.setProductType(new ProductType(producttypeNO));
		product.setOtherInfo(otherInfo);
		product.setPrice(price);
		product.setProducingArea(producingArea);
		product.setProductName(productName);
		product.setProductOwner(productOwner);
		product.setQuantity(quantity);
		product.setUnit(unit);
		productService.save(product);
		return "pub_add_success";
	}
	/**
	 * �޸Ĳ�Ʒ�������
	 * @return
	 */
	public String updateUI() {
		Product product = productService.find(productNO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("product", product);
		List<ProductType> producttypes = productTypeService.getScrollData().getResultlist();
		request.setAttribute("producttypes", producttypes);
		return "update";
	}
	/**
	 * �޸Ĳ�Ʒ
	 * @return
	 */
	public String update() {
		Product product = new Product();
		product.setProductNO(productNO);
		product.setProductType(new ProductType(producttypeNO));
		product.setOtherInfo(otherInfo);
		product.setPrice(price);
		product.setProducingArea(producingArea);
		product.setProductName(productName);
		product.setProductOwner(productOwner);
		product.setQuantity(quantity);
		product.setUnit(unit);
		productService.update(product);
		return "pub_update_success";
	}
	/**
	 * ɾ����Ʒ
	 * @return
	 */
	public String del() {
		productService.delete(productNO);
		return "pub_del_success";
	}
	/**
	 * ��Ʒ��ѯ
	 * @return
	 */
	public String query() {
		return "query";
	}
	public String getProductNO() {
		return productNO;
	}
	public void setProductNO(String productNO) {
		this.productNO = productNO;
	}
	public String getProducttypeNO() {
		return producttypeNO;
	}
	public void setProducttypeNO(String producttypeNO) {
		this.producttypeNO = producttypeNO;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProducingArea() {
		return producingArea;
	}
	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
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
	
}
