package com.app.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;

public interface ICustomerDao {

	public String addCustDetails(Customer customer) throws GeneralSecurityException, IOException;

	Customer authenticateCustomer(String em, String pass) throws GeneralSecurityException, IOException;

	public List<Customer> getAllCustomers();

	public String updateCustomerDetails(int custId, @Valid Customer customerDetails);

	public Customer getCustomerById(int custId);
}
