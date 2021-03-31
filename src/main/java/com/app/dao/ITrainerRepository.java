package com.app.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Trainer;

public interface ITrainerRepository extends JpaRepository<Trainer, Integer>{

	//Trainer save(Trainer trainer);
	
	  @Query(value
	  ="select t from Trainer t where t.trainerEmail=:email and t.trainerPass=:password"
	  )
	 Trainer authenticateTrainer(@Param(value = "email") String email,@Param(value = "password") String password);

	  
	@Query(value="select t from Trainer t where t.status='APPROVED'")  
	List<Trainer> getTrainerList();

    @Query(value="select t from Trainer t where t.status='UNAPPROVED'")
	List<Trainer> getUnApprovedTrianerList();

    @Modifying
    @Query(value="update Trainer t set t.status='APPROVED' where t.trainerId=:id")
	int approveTrainerById(@Param(value = "id") int trainerId);

   
	
	
}
