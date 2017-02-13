package com.sanqing.serviceImpl;

import org.springframework.stereotype.Service;

import com.sanqing.dao.DaoSupport;
import com.sanqing.po.ProductType;
import com.sanqing.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl extends DaoSupport<ProductType> implements
		ProductTypeService {
}
