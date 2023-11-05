package com.lumiere.boot.web.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		org.springframework.security.crypto.password.PasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		String senha = encoder.encode(usuario.getSenhaUsuario());
		usuario.setSenhaUsuario(senha);
		
		usuario.setDataDeCadastro(Calendar.getInstance().getTime());
		
		usuarioService.salvar(usuario);
				
		return "redirect:/usuario/login";
	}
	//Coloquei o retorno como login/login pq no meu tava dando erro, antes tava Login/login
	@GetMapping("/login")
	public String logarUsuario(Usuario usuario) {
		return "/login/login";
	}
}
