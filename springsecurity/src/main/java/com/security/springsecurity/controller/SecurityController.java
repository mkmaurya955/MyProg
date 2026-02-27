package com.security.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class SecurityController {
	@GetMapping("/home")
	public String getHomePage() {
		return "homePage";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcomePage";
	}
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "adminPage";
	}
	
	@GetMapping("/emp")
	public String getEmployeePage() {
		return "empPage";
	}
	
	@GetMapping("/mgr")
	public String getManagerPage() {
		return "mgrPage";
	}
	
	@GetMapping("/common")
	public String getCommonPage() {
		return "commonPage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDeniedPage() {
		return "accessDeniedPage";
	}

}
