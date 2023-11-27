package com.lumiere.boot.web.main;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;
import com.lumiere.boot.web.api.APIController;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	APIController rankingConsumidorAPI;
	
	@GetMapping("/Cadastrar")
	public String cadastraUsuario(Usuario usuario) {
		return "/Cadastro/usuario";
	}
	
	@PostMapping("/Salvar")
	public String salvar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		org.springframework.security.crypto.password.PasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		String senha = encoder.encode(usuario.getSenhaUsuario());
		usuario.setSenhaUsuario(senha);
		
		usuario.setDataDeCadastro(Calendar.getInstance().getTime());
		
		usuarioService.salvar(usuario);
				
		return "redirect:/Usuario/Login";
	}
	//Coloquei o retorno como login/login pq no meu tava dando erro, antes tava Login/login
	@GetMapping("/Login")
	public String logarUsuario(Usuario usuario) {
		return "/Login/login";
	}
	
	@GetMapping("/Ranking")
	public String topConsumidores(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		Usuario usuario = (Usuario) usuarioService.buscarUsuarioPorEmail(currentUser.getUsername());
				
		model.addAttribute("infoUsuarioLogado", usuario);
		model.addAttribute("rankingConsumidor", rankingConsumidorAPI.obtemRankingConsumidor());
		
		return "/Usuario/Ranking";
	}
}
