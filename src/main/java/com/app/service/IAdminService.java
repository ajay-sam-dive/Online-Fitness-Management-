package com.app.service;

import javax.validation.Valid;

import com.app.pojos.Admin;

public interface IAdminService {

	
	Admin addAdminDetails(@Valid Admin admin);

	Admin authenticateAdmin(String email, String password);

}
