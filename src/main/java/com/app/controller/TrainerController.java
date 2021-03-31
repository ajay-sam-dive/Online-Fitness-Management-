package com.app.controller;

import java.io.File;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Trainer;
import com.app.pojos.TrainerSchedule;
import com.app.service.ITrainerService;
import com.app.util.AESAlgorithm;
import com.app.util.FileUploadUtil;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private ITrainerService trainerService;
	
	
	public TrainerController() {
	System.out.println("in ctor of " +getClass().getName());	
	}
	
	@GetMapping
	public String trainerRegisterationPage()
	{
		System.out.println("in trainer registeration page");
		return "/trainer/trainerRegister";
	}

	@GetMapping("/loginPage")
	public String loginPage() {
		System.out.println("in register page");
		return "/trainer/trainerSignin";
	}
	
	@PostMapping("/register")   
	public String addTrainerDetails(@Valid Trainer trainer,BindingResult result,
			@RequestParam("photo1") MultipartFile photo,@RequestParam("certificate1") MultipartFile certificate,
			
			@Valid TrainerSchedule schedule,@Valid Address address,HttpSession session)
	{
		if(result.hasErrors())
		{
			return "redirect:/trainer/trainerRegister";
		}
		System.out.println("in save trainer with photo " +trainer+" "+photo.getOriginalFilename());
		try {
		     trainer.addAddress(address);
			trainer.addTrainerSchedule(schedule);
			trainer.setTrainerPass(AESAlgorithm.en(trainer.getTrainerPass()));
			
			
			String photoFileName= StringUtils.cleanPath(photo.getOriginalFilename());
			String certificateFileName=StringUtils.cleanPath(certificate.getOriginalFilename());
			if(photoFileName.contains("..") || certificateFileName.contains(".."))
			{
				System.out.println("not valid file");
				}
			trainer.setPhoto(photoFileName);
			trainer.setCertificate(certificateFileName);
		    Trainer SavedTrainer=trainerService.addTrainerDetails(trainer);
			String path=session.getServletContext().getRealPath("/")+ "static" +File.separator+"trainerImages";
			System.out.println(path);
	         
	        FileUploadUtil.saveFile(path, photoFileName, photo);
	        FileUploadUtil.saveFile(path, certificateFileName,certificate);
			return "trainer/trainerSignin";
			
		}catch (Exception e) {
			e.printStackTrace();
			return "/trainer/trainerRegister";
		}
	}
	
	@GetMapping("/login")
	public String trainerLoginForm()
	{
		System.out.println("in trainer login form ");
		return "/trainer/trainerSignin";
	}
	
	
	@PostMapping("/authenticate")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) throws GeneralSecurityException, IOException
	{
		System.out.println("in process login form " + email + " " + password);

		try {
			String encryptedPass = AESAlgorithm.en(password);

			Trainer validatedTrainer = trainerService.authenticateTrainer(email,encryptedPass);
			flashMap.addFlashAttribute("message", validatedTrainer.getTrainerName() + "login successful!");
			session.setAttribute("trainerDetails", validatedTrainer);
			return "/trainer/trainerProfile";

		} catch (RuntimeException e) {
			e.printStackTrace();
			map.addAttribute("message", "Invalid Login , Please Retry");
			return "/trainer/trainerSignin";
		}

	}

	 @GetMapping("/logout")
	 	public String logout(HttpSession session,Model map,HttpServletRequest request)
	 	{
	 		System.out.println("in logout "+map);
	 		map.addAttribute("details",session.getAttribute("trainerDetails"));
	 	    session=request.getSession();
	 	   if(request.isRequestedSessionIdValid() && session != null)
	        {
	 		session.invalidate();
	        }
	 		return "/trainer/trainerSignin"; 
	 	}





}
