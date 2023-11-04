package com.lumiere.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiere.boot.dao.UsuarioDaoImpl;
import com.lumiere.boot.domain.Usuario;

@Controller
@RequestMapping("/Residencia")
public class ResidenciaController {	
	@Autowired
	UsuarioDaoImpl usuarioDaoImpl;
	
	@GetMapping("/Cadastrar")
	public String registrar(Model model, @AuthenticationPrincipal UserDetails currentUser) {	
		
		Usuario user = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
		 
		System.out.println(user.getId());
		 
		return "/Residencia/Cadastrar";
	}
}
