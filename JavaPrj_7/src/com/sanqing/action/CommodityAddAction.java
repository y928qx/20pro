package com.sanqing.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Commodity;
import com.sanqing.po.CommodityClass;
import com.sanqing.service.CommodityClassService;
import com.sanqing.service.CommodityService;
import com.sanqing.util.FileToByte;

public class CommodityAddAction extends ActionSupport {
	private CommodityClassService commodityClassService;// ҵ���߼���
	private List<CommodityClass> commodityClasses;// ��Ʒ�����б�
	private CommodityService commodityService;//��Ʒҵ���߼����
	private CommodityClass commodityClass;	//��Ʒ����
	private Integer commodityClassID;		//��Ʒ������
	private String commodityName;			//��Ʒ����
	private String manufacturer;			//��������
	private String commodityDepict;			//��Ʒ����
	private Double commodityPrice;			//��Ʒ�۸�
	private Double fcPrice;					//�������۸�
	private Integer commodityAmount;		//��Ʒ������
	private File uploadImage;					//�ϴ�ͼƬ�ļ�
	private String uploadImageContentType;		//�ϴ�ͼƬ�ļ�����
	private String uploadImageFileName;			//�ϴ�ͼƬ�ļ���

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public CommodityClass getCommodityClass() {
		return commodityClass;
	}

	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}

	public Integer getCommodityClassID() {
		return commodityClassID;
	}

	public void setCommodityClassID(Integer commodityClassID) {
		this.commodityClassID = commodityClassID;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCommodityDepict() {
		return commodityDepict;
	}

	public void setCommodityDepict(String commodityDepict) {
		this.commodityDepict = commodityDepict;
	}

	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Double getFcPrice() {
		return fcPrice;
	}

	public void setFcPrice(Double fcPrice) {
		this.fcPrice = fcPrice;
	}

	public Integer getCommodityAmount() {
		return commodityAmount;
	}

	public void setCommodityAmount(Integer commodityAmount) {
		this.commodityAmount = commodityAmount;
	}

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	public void setCommodityClassService(
			CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}

	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}

	public String addBefore() {// ������Ʒ֮ǰ���ȵ��ø÷���
		commodityClasses = commodityClassService.findAllCommodityClass();// ��ѯ���е���Ʒ����
		return "success";
	}

	public String execute() throws Exception {
		Commodity commodity = new Commodity();		//ʵ����һ����Ʒ��Ϣ����
		commodity.setCommodityClass
				(new CommodityClass(commodityClassID));//������Ʒ����
		commodity.setCommodityDepict(commodityDepict);//������Ʒ����
		commodity.setCommodityLeaveNum(commodityAmount);//������Ʒʣ������
		commodity.setCommodityAmount(commodityAmount);//������Ʒ������
		commodity.setCommodityPrice(commodityPrice);//������Ʒ�۸�
		commodity.setFcPrice(fcPrice);//���÷������۸�
		commodity.setManufacturer(manufacturer);//�������ɳ���
		commodity.setCommodityName(commodityName);//������Ʒ����
		commodity.setRegTime(new Date());//������Ʒ�ϼ�ʱ��
		File file = getUploadImage();
		if(file != null && file.exists()) {
			commodity.setImage(FileToByte.getBytesFromFile(file));
		}
		commodityService.addCommodity(commodity);//������Ʒ
		return SUCCESS;
	}
}
