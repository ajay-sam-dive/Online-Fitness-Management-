package com.app.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.validation.Valid;

import com.app.pojos.Customer;

public interface ICustomerService {

	String addCustDetails(Customer customer) throws GeneralSecurityException, IOException;

	Customer authenticateCustomer(String em, String pass) throws GeneralSecurityException, IOException;
	
	List<Customer> getAllCustomers();
	
	
//update customer details
	String updateCustomerDetails(int custId, @Valid Customer customerDetails);

	Customer getCustomerById(int custId);
	
	 
}
