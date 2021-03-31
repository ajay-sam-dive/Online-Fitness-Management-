package com.app.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.pojos.Trainer;
import com.app.service.ICustomerService;
import com.app.service.ITrainerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private ITrainerService trainerService;
	
	public CustomerController() {
	System.out.println("in ctor of " +getClass().getName());
	}
	
	@GetMapping
	public String registerPage() {
		System.out.println("in register page");
		return "/customer/customerRegister";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		System.out.println("in register page");
		return "/signin";
	}
	
	@GetMapping("/AllCustomer")
	public List<Customer> getAllCustomerDetail()
	{
		System.out.println("process is to get all customer detail");
		List<Customer> customers=new ArrayList();
				return customers=custService.getAllCustomers();
	}
	
	@PostMapping("/register")
	public String addUserDetails(@Valid Customer customer,BindingResult result,Model flashMap) throws GeneralSecurityException, IOException {
		System.out.println("in add customer details " + customer);
		if(result.hasErrors())
		{  
		
			return "/customer/customerRegister";
		}
		try {			
		custService.addCustDetails(customer);
		flashMap.addAttribute("message",customer.getCustName()+" register Sucessfully");
		return "/signin";
		}catch (Exception e) {
			e.printStackTrace();
		    flashMap.addAttribute("message", "Error");
			return "/customer/customerRegister";
			}
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password,
			Model map,HttpSession session,RedirectAttributes flashMap) throws GeneralSecurityException, IOException {
		System.out.println("in process login form " + email + " " + password);
		
		try {
			Customer validatedCustomer = custService.authenticateCustomer(email, password);
			flashMap.addFlashAttribute("message", validatedCustomer.getCustName()+ "login successful!");
			session.setAttribute("customer_details", validatedCustomer);
				return "/customer/customerProfile";
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			map.addAttribute("message", "Invalid Login , Please Retry");
			return "/signin";
		}

	}

	  @PostMapping("/update")	
	     public String updateCustomerProfile(@Valid Customer customerDetails,Model map,HttpSession session) 
	     {
				System.out.println("in update Customer details " + customerDetails.getStartTime() + " "
						+ customerDetails.getEndTime() +" "+customerDetails.getFoodPreference() );
	    	 try {
	    		 
	    		 int custId=customerDetails.getCustId();
	    		 custService.updateCustomerDetails(custId,customerDetails);
	    		 Customer customer=custService.getCustomerById(custId);
	    		 session.setAttribute("customer_details", customer);
	    		 return "/customer/customerProfile";
	    	 }catch (RuntimeException e) {
	    		 e.printStackTrace();
	    		 
	    		 return "/customer/customerProfile";
	    		 
			}
	     }
     
     @GetMapping("/getTrainerList")
     public String getApprovedTrainerList(Model map)
     {
    	 System.out.println("in get Trainer List by your interest");
    	     List<Trainer> trainers= new ArrayList<>();
    	     trainers=trainerService.getTrianerList();
    	     map.addAttribute("trainerList", trainers);
    		 return "/customer/getTrainerList";
		
     }
    
       @GetMapping("/trainerById")
       public String getTrainerById(@RequestParam  int trainerId,Model map)
       {
    	 System.out.println("in get Trainer by id");
    	
    	    try { 
    	    	 System.out.println(trainerId);
    	     Optional<Trainer> trainer=trainerService.getTrainerById(trainerId);
    	     System.out.println("trainer details ..."+trainer);
    	     String startTime=(trainer.get().getTrainerSchedule().getStartTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
    	     String endTime=(trainer.get().getTrainerSchedule().getEndTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
    	     map.addAttribute("startTime",startTime);
    	     map.addAttribute("endTime",endTime);
    	     map.addAttribute("trainer",trainer.get());
    		 return "/customer/trainerDetails";
    	    }catch (Exception e) {
				e.printStackTrace();
				return "/customer/getTrainerList";
			}
     }
    
     @GetMapping("/logout")
 	public String logout(HttpSession session,Model map,HttpServletRequest request)
 	{
 		System.out.println("in logout "+map);
 		map.addAttribute("details",session.getAttribute("customer_details"));
 		session=request.getSession();
	 	   if(request.isRequestedSessionIdValid() && session != null)
	        {
	 		session.invalidate();
	        }
 		return "/signin"; 
 	}

     
	
}
	