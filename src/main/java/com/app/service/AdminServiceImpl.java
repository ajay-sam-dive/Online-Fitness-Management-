package com.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminRepository;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	
	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public Admin addAdminDetails(@Valid Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public Admin authenticateAdmin(String email,String password) {
	
		return adminRepo.authenticateAdmin(email,password);
	}
	
	
	
}
