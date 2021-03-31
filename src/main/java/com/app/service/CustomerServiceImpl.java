package com.app.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao custDao;
	
	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String addCustDetails(Customer customer) throws GeneralSecurityException, IOException {
	
		return custDao.addCustDetails(customer);
	}

	
	public Customer authenticateCustomer(String em, String pass) throws GeneralSecurityException, IOException {
		// TODO Auto-generated method stub
		return custDao.authenticateCustomer(em, pass);
	}


	
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return custDao.getAllCustomers();
	}


	@Override
	public String updateCustomerDetails(int custId, @Valid Customer customerDetails) {
		
		return custDao.updateCustomerDetails(custId,customerDetails);
	}


	@Override
	public Customer getCustomerById(int custId) {
		
		return custDao.getCustomerById(custId);
	}
	
	
}
