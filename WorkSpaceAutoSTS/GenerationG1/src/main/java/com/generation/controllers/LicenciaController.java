package com.generation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;
import com.generation.services.LicenciaService;
import com.generation.services.UsuarioService;
import com.generation.models.Usuario;

import java.util.List;

import javax.validation.Valid;



@Controller
@RequestMapping("/licencia")
public class LicenciaController {
    @Autowired // un autowired para acceder a metodos de licencia
    LicenciaService licenciaService;

    @Autowired //otro para acceder a los de usuariservice
    UsuarioService usuarioService;

    /**Para desplegar JSP */
    @RequestMapping("")
    public String despliegue(Model model){
        Licencia licencia = new Licencia();
        model.addAttribute("licencia", licencia);
       //lista de usuarios
        List<Usuario> listaUsuarios = usuarioService.findAll(); 
       //no existe el metodo por lo q en ese serivicio hay q crearlo
        model.addAttribute("listaUsuarios", listaUsuarios);

        //Enviar al jsp lista de Licencias
        List <Licencia> listaLicencias = licenciaService.findAll();
        model.addAttribute("listaLicencias",listaLicencias);
        return "licencia.jsp";
    }

    @PostMapping("/guardar")
    public String guardarLicencia(@Valid @ModelAttribute("licencia")Licencia licencia
    ){
        licenciaService.save(licencia);
        return "redirect:/licencia";

    }
}
