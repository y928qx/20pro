package com.sanqing.serviceImpl;
import org.springframework.stereotype.Service;

import com.sanqing.dao.DaoSupport;
import com.sanqing.po.Product;
import com.sanqing.service.ProductService;

@Service
public class ProductServiceImpl extends DaoSupport<Product> implements ProductService {

}
