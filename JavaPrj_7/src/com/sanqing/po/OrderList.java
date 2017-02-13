package com.sanqing.po;

public class OrderList implements java.io.Serializable {
	private Integer orderListId;	//�����б���
	private Commodity commodity;	//��Ʒ��Ϣ
	private OrderForm orderForm;	//������Ϣ
	private Integer amount;			//��Ʒ����

	public OrderList() {
	}

	public OrderList(Commodity commodity, OrderForm orderForm, Integer amount) {
		this.commodity = commodity;
		this.orderForm = orderForm;
		this.amount = amount;
	}

	public Integer getOrderListId() {
		return this.orderListId;
	}

	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public OrderForm getOrderForm() {
		return this.orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}