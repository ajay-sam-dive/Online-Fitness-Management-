package com.app.service;

import javax.validation.Valid;

import com.app.pojos.Enrollment;

public interface IEnrollmentService {

	Enrollment addEnrollment(@Valid Enrollment enrollment);

}
