package com.app.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITrainerRepository;
import com.app.pojos.ApprovalStatus;
import com.app.pojos.Customer;
import com.app.pojos.Trainer;
import com.app.util.AESAlgorithm;

@Service
@Transactional
public class TrainerServiceImpl implements ITrainerService{

	@Autowired
	private ITrainerRepository trainerRepo;

	@Override
	public Trainer addTrainerDetails(Trainer trainer) {
		trainer.setStatus(ApprovalStatus.UNAPPROVED);
		return trainerRepo.save(trainer);
	}

	@Override
	public List<Trainer> getTrianerList() {
		return trainerRepo.getTrainerList();
	}

	
	  public Trainer authenticateTrainer(String email, String password) { return
	  trainerRepo.authenticateTrainer( email, password); }

	
	@Override
	public Optional<Trainer> getTrainerById(int trainerId) {
	return trainerRepo.findById(trainerId);
	}

	@Override
	public List<Trainer> getUnApprovedTrianerList() {
		
		return trainerRepo.getUnApprovedTrianerList();
	}

	@Override
	public int approveTrainerById(int trainerId) {
		// TODO Auto-generated method stub
		return trainerRepo.approveTrainerById(trainerId);
	}

	
	

	
}
