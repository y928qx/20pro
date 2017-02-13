package com.sanqing.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.Customer;
import com.sanqing.po.Order;
import com.sanqing.po.Product;
import com.sanqing.service.CustomerService;
import com.sanqing.service.OrderService;
import com.sanqing.service.ProductService;

@Controller("orderManageAction")
@Scope("prototype")
public class OrderManageAction extends BaseAction {

	@Resource
	private OrderService orderService;
	@Resource
	private CustomerService customerService;
	@Resource
	private ProductService productService;
	
	/* �������� */
	private String orderNO;
	/* �ͻ����� */
	private Customer customer;
	/* ��Ʒ���� */
	private Product product;
	/* ��Ʒ���� */
	private int quantity;
	/* ������ʱ�� */
	private Date orderTime;
	/* ������Ϣ*/
	private String otherInfo;
	
	/**
	 * ��Ӷ����������
	 * @return
	 */
	public String addUI() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Customer> customers = customerService.getScrollData().getResultlist();
		List<Product> products = productService.getScrollData().getResultlist();
		request.setAttribute("customers", customers);
		request.setAttribute("products", products);
		return "add";
	}
	/**
	 * ��Ӷ���
	 * @return
	 */
	public String add() {
		Order order = new Order();
		order.setCustomer(customer);
		order.setOrderNO(orderNO);
		order.setOrderTime(orderTime);
		order.setOtherInfo(otherInfo);
		order.setProduct(product);
		order.setQuantity(quantity);
		orderService.save(order);
		return "pub_add_success";
	}
	/**
	 * �޸Ķ����������
	 * @return
	 */
	public String updateUI() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Customer> customers = customerService.getScrollData().getResultlist();
		List<Product> products = productService.getScrollData().getResultlist();
		Order order = orderService.find(orderNO);
		request.setAttribute("customers", customers);
		request.setAttribute("products", products);
		request.setAttribute("order", order);
		return "update";
	}
	/**
	 * �޸Ķ���
	 * @return
	 */
	public String update() {
		Order order = new Order();
		order.setCustomer(customer);
		order.setOrderNO(orderNO);
		order.setOrderTime(orderTime);
		order.setOtherInfo(otherInfo);
		order.setProduct(product);
		order.setQuantity(quantity);
		orderService.update(order);
		return "pub_update_success";
	}
	/**
	 * ɾ������
	 * @return
	 */
	public String del() {
		orderService.delete(orderNO);
		return "pub_del_success";
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Customer> customers = customerService.getScrollData().getResultlist();
		List<Product> products = productService.getScrollData().getResultlist();
		request.setAttribute("customers", customers);
		request.setAttribute("products", products);
		return "query";
	}
	
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
