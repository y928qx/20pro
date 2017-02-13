package com.sanqing.course.util;

import java.util.List;

/**
 * ��ҳ���
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class PageModel {
	
	//�ܼ�¼��
	private int totalRecords;
	
	//�����
	private List list;
	
	//��ǰҳ
	private int pageNo;
	
    //ÿҳ��ʾ������
	public static int pageSize = 3; 
	
	
	public int getTotalRecords() {
		return totalRecords;
	}
	
	/**
	 * ȡ����ҳ��
	 * @return
	 */
	public int getTotalPages() {

		return (totalRecords + pageSize - 1) / pageSize;
	}
	
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * ȡ�õ�һҳ
	 * @return
	 */
	public int getTopPageNo() {
		
		return 1;
	}
	
	/**
	 * ȡ����һҳ
	 * @return
	 */
	public int getPreviousPageNo() {
		
		return pageNo <= 1? 1:pageNo-1;
	}
	
	/**
	 * ȡ����һҳ
	 * @return
	 */
	public int getNextPageNo() {
		
		if (pageNo >= getTotalPages()) {
			
			return getTotalPages() == 0 ? 1:getTotalPages();
		} else {
			
			return pageNo + 1;
		}	
	}
	
	/**
	 * ȡ�����һҳ
	 * @return
	 */
	public int getBottomPageNo() {
		
		return getTotalPages()==0 ? 1:getTotalPages();
		
	}
}
