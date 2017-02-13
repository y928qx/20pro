package com.sanqing.serviceImpl;

import org.springframework.stereotype.Service;

import com.sanqing.dao.DaoSupport;
import com.sanqing.po.Customer;
import com.sanqing.service.CustomerService;

@Service
public class CustomerServiceImpl extends DaoSupport<Customer> implements
		CustomerService {

}
