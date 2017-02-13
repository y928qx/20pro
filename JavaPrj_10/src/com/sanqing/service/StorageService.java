package com.sanqing.service;

import java.util.Map;





import com.sanqing.dao.IStorageDAO;
import com.sanqing.util.PageResult;

public class StorageService {
	private IStorageDAO storage=null;
	
	//查询数据
	public PageResult findAll(Map paramMap){

		return storage.findAll(paramMap);
		
	}
	public IStorageDAO getStorage() {
		return storage;
	}

	public void setStorage(IStorageDAO storage) {
		this.storage = storage;
	}
	

	
}
