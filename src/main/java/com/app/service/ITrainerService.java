package com.app.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.app.pojos.Customer;
import com.app.pojos.Trainer;

public interface ITrainerService {

Trainer addTrainerDetails(Trainer trainer);

List<Trainer> getTrianerList();


  Trainer authenticateTrainer(String email, String password) throws
  GeneralSecurityException, IOException;

   Optional<Trainer> getTrainerById(int trainerId);

   List<Trainer> getUnApprovedTrianerList();

int approveTrainerById(int trainerId);


 

	
	
}
