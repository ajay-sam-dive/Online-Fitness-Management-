package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Enrollment;

public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}
