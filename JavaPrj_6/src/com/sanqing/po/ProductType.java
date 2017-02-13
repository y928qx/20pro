package com.sanqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="tb_producttype")
public class ProductType {			//��Ʒ�����Ϣ
	private String producttypeNO;	//��Ʒ�����
	private String producttypeName;	//��Ʒ�������
	public ProductType(){}			//Ĭ�Ϲ��췽��
	public ProductType(String producttypeNO) {//�Զ��幹�췽��
		this.producttypeNO = producttypeNO;
	}
	@Id @Column(length=15)
	public String getProducttypeNO() {//��ò�Ʒ�����
		return producttypeNO;
	}
	public void setProducttypeNO(String producttypeNO) {//���ò�Ʒ�����
		this.producttypeNO = producttypeNO;
	}
	@Column(length=20)
	public String getProducttypeName() {//��ò�Ʒ�������
		return producttypeName;
	}
	public void setProducttypeName(String producttypeName) {//���ò�Ʒ�������
		this.producttypeName = producttypeName;
	}
}
