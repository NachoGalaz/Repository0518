package com.generation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		if(email == null || email.equals("")) {
			return "redirect:/registro/usuario/login";
		}else {
			return "home.jsp";
		}
		
		
	}

}