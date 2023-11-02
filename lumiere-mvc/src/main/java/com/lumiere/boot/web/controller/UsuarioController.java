package com.lumiere.boot.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastrar")
	public String cadastraUsuario(Usuario usuario) {
		return "/Cadastro/usuario";
	}
	
	@GetMapping("/login")
	public String logarUsuario(Usuario usuario) {
		return "/Login/login";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		usuario.setDataDeCadastro(Calendar.getInstance().getTime());
		
		usuarioService.salvar(usuario);
		return "redirect:/usuario/login";
	}
	
	@GetMapping("/entrar")
	public String entrar(Usuario usuario) {
		if (usuario.getEmailUsuario().length() > 0) 
		{
			if (usuario.getSenhaUsuario().length() > 0) 
			{
				
			}
		}
		
		return "redirect:/usuario/login";
	}
}
