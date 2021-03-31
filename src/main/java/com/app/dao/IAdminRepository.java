package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	
	@Query(value="select a from Admin a where a.adminEmail=:email and a.adminPassword=:password")
	Admin authenticateAdmin(@Param(value = "email") String email,@Param(value = "password") String password);

}
