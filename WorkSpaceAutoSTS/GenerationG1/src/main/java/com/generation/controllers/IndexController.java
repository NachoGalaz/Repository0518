package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Usuario;

@Controller
public class IndexController {
	//http://localhost:8080/
	@RequestMapping("/")//anotacion para capturar las rutas
	public String index(Model model) {
		model.addAttribute("apellidos","Galaz Farias");
		model.addAttribute("nombres","Ignacio");
		model.addAttribute("edad",42);
		
		//instancia de usuario
		Usuario usuario = new Usuario("Ignacio","Galaz",29,"Admin1234");
		//pasando el objeto a la vista (JSP)
		model.addAttribute("usuario",usuario);
		
		System.out.println(usuario.getNombre());
		
		return "index.jsp";
	}
	
	
}
