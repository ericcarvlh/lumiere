package com.lumiere.boot.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiere.boot.dao.UsuarioDaoImpl;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.EstadoService;
import com.lumiere.boot.service.IconeResidenciaService;

@Controller
@RequestMapping("/Residencia")
public class ResidenciaController {	
	@Autowired
	UsuarioDaoImpl usuarioDaoImpl;
	
	@Autowired
	private IconeResidenciaService iconeResidenciaService;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/Residencias") 
	public String residencias(@AuthenticationPrincipal UserDetails currentUser) {
		// coleta os dados do usuario logado
		Usuario user = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
		
		return "/Residencia/Residencias";
	}
	
	@GetMapping("/Cadastrar")
	public String registrar(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		model.addAttribute("iconesResidencia", iconeResidenciaService.buscarTodos());
		model.addAttribute("estados", estadoService.buscarUFeIdEstado());
		
		return "/Residencia/Cadastrar";
	}
	
	@PostMapping("/Cadastrar")
	public String registrar(Residencia residencia, @AuthenticationPrincipal UserDetails currentUser) {
		
		return "/Residencia/Cadastrar";
	}
}
