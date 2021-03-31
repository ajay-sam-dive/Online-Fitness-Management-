package com.app.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.util.AESAlgorithm;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private EntityManager mgr;
	
	public CustomerDaoImpl() {
	System.out.println("in ctor of " +getClass().getName());
	}
	
	
	public String addCustDetails(Customer customer) throws GeneralSecurityException, IOException {
		String mesg="Customer registration failed";
		String encryptedPass=AESAlgorithm.en(customer.getCustPassword());
		customer.setCustPassword(encryptedPass);
		mgr.persist(customer);
		mesg="Customer registration Sucessfull ";
		
		return mesg;
		
	}

	@Override
	public Customer authenticateCustomer(String em, String pass) throws GeneralSecurityException, IOException {
		String encryptedPass=AESAlgorithm.en(pass);
		String jpql = "select c from Customer c where c.custEmail = :em and c.custPassword=:encryptedPass";
		return mgr.createQuery(jpql, Customer.class).
				setParameter("em", em).setParameter("encryptedPass", encryptedPass)
				.getSingleResult();
	}


	@Override
	public List<Customer> getAllCustomers() {
		String jpql="select c from Customer c ";
		return mgr.createQuery(jpql,Customer.class).getResultList();
	}


	@Override
	public String updateCustomerDetails(int custId, @Valid Customer customerDetails) {
	String mesg="Customer update unsuccessfull";
		Customer customer = mgr.find(Customer.class,custId);
		customer.setAddress(customerDetails.getAddress());
	    customer.setAge(customerDetails.getAge());
	    customer.setGender(customerDetails.getGender());
	    customer.setHeight(customerDetails.getHeight());
	    customer.setWeight(customerDetails.getWeight());
	    customer.setInterest(customerDetails.getInterest());
	    customer.setBodyFat(customerDetails.getBodyFat());
	    customer.setFitnessLevel(customerDetails.getFitnessLevel());
	    customer.setActivityLeval(customerDetails.getActivityLeval());
	    customer.setFoodPreference(customerDetails.getFoodPreference());
	    customer.setGoals(customerDetails.getGoals());
	    customer.setStartTime(customerDetails.getStartTime());
	    customer.setEndTime(customerDetails.getEndTime());
	    customer.setBirthDate(customerDetails.getBirthDate());
	    mgr.merge(customer);
	    mesg="Customer updated successfully";
	    return mesg;
	}


	@Override
	public Customer getCustomerById(int custId) {
		return mgr.find(Customer.class, custId);
	}
	
	

}
