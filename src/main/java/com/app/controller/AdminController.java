package com.app.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.ApprovalStatus;
import com.app.pojos.Customer;
import com.app.pojos.Trainer;
import com.app.service.IAdminService;
import com.app.service.ITrainerService;
import com.app.util.AESAlgorithm;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	public AdminController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	@Autowired
	private IAdminService adminService;
	
	
	  @Autowired 
	  private ITrainerService trainerService;
	 
	  @GetMapping
		public String registerPage() {
			System.out.println("in register page");
			return "/admin/adminRegister";
		}
		
		@GetMapping("/loginPage")
		public String loginPage() {
			System.out.println("in Signin page");
			return "/admin/adminSignin";
		}
	
	@PostMapping("/register")
	public String addUserDetails(@Valid Admin admin,BindingResult result,Model flashMap) throws GeneralSecurityException, IOException {

		System.out.println("in add admin details " + admin);
		System.out.println(result);
		if(result.hasErrors())
		{  
		
			return "/admin/adminRegister";
		}
		try {			
		admin.setAdminPassword(AESAlgorithm.en(admin.getAdminPassword()));
		Admin registeredAdmin=adminService.addAdminDetails(admin);
		flashMap.addAttribute("message",registeredAdmin.getAdminName()+" registered Sucessfully");
		return "/admin/adminProfile";
		}catch (Exception e) {
			e.printStackTrace();
		    flashMap.addAttribute("message", "Something went wrong..!!");
			return "/admin/adminRegister";
			}
	}
	 

	@PostMapping("/login")
	public String processLoginForm(@RequestParam ("adminEmail") String email, @RequestParam ("adminPassword") String password,
			Model map,HttpSession session,RedirectAttributes flashMap) throws GeneralSecurityException, IOException {
		System.out.println("in process login form " + email + " " + password);
		
		try {
			String encryptedPass=AESAlgorithm.en(password);
			Admin validatedAdmin = adminService.authenticateAdmin(email, encryptedPass);
			flashMap.addFlashAttribute("logn", validatedAdmin.getAdminName()+ "login successful!");
			session.setAttribute("admin_details", validatedAdmin);
				return "/admin/adminProfile";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			map.addAttribute("logn", "Invalid Login , Please Retry");
			return "/admin/adminSignin";
		}

	}

	
	
	  @GetMapping("/unapprovedTrainerList") 
	  public String getTrainerList(HttpSession session)
	  { 
		  System.out.println("in get all unapproved Trainer  List "); 
		  List<Trainer> trainers= new ArrayList<>();
		  trainers=trainerService.getUnApprovedTrianerList();
	      session.setAttribute("trainerList", trainers); 
		  return "/admin/unapprovedTrainerList";
	  }
	 
	  @GetMapping("/approveTrainer")
      public String approveTrainer(@RequestParam  int trainerId,Model map)
      {
   	 System.out.println("in trainer approval process by id");
   	
   	    try { 
   	    	 System.out.println(trainerId);
   	    int trainer=trainerService.approveTrainerById(trainerId);
   	    if(trainer==1)
   	    {
   	    	System.out.println("trainer approved");
   	    	map.addAttribute("mesg","trainer Approved successfully");
   	    }
   	   
   	    return "redirect:/admin/unapprovedTrainerList";
   	    }catch (Exception e) {
				e.printStackTrace();
				return "/customer/getTrainerList";
			}
    }		
	  
	    
	     @GetMapping("/logout")
	 	public String logout(HttpSession session,Model map)
	 	{
	 		System.out.println("in logout "+map);
	 		map.addAttribute("details",session.getAttribute("admin_details"));
	 		session.invalidate();
	 		return "/admin/adminSignin"; 
	 	}
		   @GetMapping("/adminProfile")
		     public String getback() {
			return "/admin/adminProfile";

	}
		
}
