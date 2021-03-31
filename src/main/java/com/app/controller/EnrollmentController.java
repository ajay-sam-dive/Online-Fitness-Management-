package com.app.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Customer;
import com.app.pojos.Enrollment;
import com.app.pojos.MemberShip;
import com.app.pojos.Trainer;
import com.app.service.IEnrollmentService;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

	public EnrollmentController() {
	System.out.println("In Enrollment Controller "+getClass().getName());
	}
	
	@Autowired
	private IEnrollmentService enrollmentService;
	
	@GetMapping
	public String enrollmentPage()
	{
		System.out.println("In Enrollment page");
		return "/enrollment/enroll";
	}
	
	
	@PostMapping("/enroll")
    public String processingEnrollment(@Valid Enrollment enrollment,@Valid Trainer trainer,@Valid Customer customer,BindingResult result,Model map)
    {
		
		System.out.println("in adding enrollment "+enrollment);
	    
		if(result.hasErrors())
		{
			System.out.println("P.L error");
			return "/enrollment/enroll";
		}
		
		try {
			
			  enrollment.setCustomer(customer);
			  enrollment.setTrainer(trainer);
			 
		if(enrollment.getMemberShip().equals(MemberShip.SIX_MONTHS))
		{
			enrollment.setDateOfEnrollment(LocalDate.now());
			enrollment.setEndOfEnrollment(enrollment.getDateOfEnrollment().plusMonths(6));
			Enrollment enrollments= enrollmentService.addEnrollment(enrollment);
			map.addAttribute("mesg", "You have enrolled successfully...!!");
			return "/customer/customerProfile";
		}
		else
		{
			enrollment.setDateOfEnrollment(LocalDate.now());
			enrollment.setEndOfEnrollment(enrollment.getDateOfEnrollment().plusMonths(3));
			Enrollment enrollments= enrollmentService.addEnrollment(enrollment);
			map.addAttribute("mesg", "You have enrolled successfully...!!");
			return "/customer/customerProfile";		
		}
		}catch (Exception e) {
			e.printStackTrace();
			return "/customer/trainerDetails";	
		}
		
		
    }
	
}
