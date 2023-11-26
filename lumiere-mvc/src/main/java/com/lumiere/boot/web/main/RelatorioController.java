package com.lumiere.boot.web.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;



@Controller
@RequestMapping("/Relatorio")
public class RelatorioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	RelatorioConsumoDao relatorioConsumoDao;
	
	@GetMapping("/lista")
	public String listaRelatorio() {
		return "/Relatorio/Lista";
	}
	
	@GetMapping("/Comparar")
	public String comparativoDeRelatorio(Model model) {
		
		model.addAttribute("primeiroRelatorio", null);
		model.addAttribute("segundoRelatorio", null);
		
		return "/Relatorio/Comparar";
	}
	
	@PostMapping("/Comparar")
	public String comparativoDeRelatorio(Model model, String primeiroDataInicial, String primeiroDataFinal, String segundoDataInicial, String segundoDataFinal, @AuthenticationPrincipal UserDetails currentUser) {
		Usuario usuario = (Usuario) usuarioService.buscarUsuarioPorEmail(currentUser.getUsername());
		
		RelatorioConsumo primeiroRelatorio = relatorioConsumoDao.callConsultaRelatorioPorPeriodo(usuario.getId(), primeiroDataInicial, primeiroDataFinal);
		RelatorioConsumo segundoRelatorio = relatorioConsumoDao.callConsultaRelatorioPorPeriodo(usuario.getId(), segundoDataInicial, segundoDataFinal);
				
		model.addAttribute("primeiroRelatorio", primeiroRelatorio);
		model.addAttribute("segundoRelatorio", segundoRelatorio);
		
		return "/Relatorio/Comparar";
	}
	
}
