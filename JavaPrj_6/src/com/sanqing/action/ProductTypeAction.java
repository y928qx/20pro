package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sanqing.po.ProductType;
import com.sanqing.service.ProductTypeService;
import com.sanqing.util.PageView;
/**
 * ��Ʒ�����ʾ
 */
@Controller("productTypeAction")
@Scope("prototype")
public class ProductTypeAction extends BaseAction {

	@Resource
	private ProductTypeService productTypeService;
	
	// ��Ʒ���ͱ��
	private String producttypeNO;
	// ��Ʒ��������
	private String producttypeName;
	
	@Override
	public String execute() throws Exception {
		PageView<ProductType> pageView = new PageView<ProductType>(5, getPage());
		StringBuffer jpql = new StringBuffer("");
		List<Object> params = new ArrayList<Object>();
		if("true".equals(getQuery())) {
			if(producttypeName!=null && !"".equals(producttypeName.trim())) {
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.producttypeName like ?").append(params.size()+1);
				params.add("%"+producttypeName+"%");
			}
			if(producttypeNO!=null && !"".equals(producttypeNO.trim())) {
				if(params.size()>0) jpql.append(" and ");
				jpql.append(" o.producttypeNO like ?").append(params.size()+1);
				params.add("%"+producttypeNO+"%");
			}
			pageView.setQueryResult(productTypeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), jpql.toString(), params.toArray()));
		}else{
			pageView.setQueryResult(productTypeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult()));
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pageView", pageView);
		return this.SUCCESS;
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
