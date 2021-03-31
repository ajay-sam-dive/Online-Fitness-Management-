package com.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEnrollmentRepository;
import com.app.pojos.Enrollment;

@Service
@Transactional

public class EnrollmentServiceImpl implements IEnrollmentService {

	@Autowired
	private IEnrollmentRepository enrollRepo;
	
	@Override
	public Enrollment addEnrollment(@Valid Enrollment enrollment) {
		return enrollRepo.save(enrollment);
	}

}
