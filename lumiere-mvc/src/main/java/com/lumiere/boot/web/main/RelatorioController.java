package com.lumiere.boot.web.main;


import java.util.List;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Dispositivo;
import com.lumiere.boot.service.DispositivoService;
import com.lumiere.boot.service.ResidenciaService;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/Relatorio")
public class RelatorioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	RelatorioConsumoDao relatorioConsumoDao;
		
	@GetMapping("/Lista")
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
	
	
	@GetMapping("/Semanal/{cdResidencia}")
	public String relatorioSemanal(@PathVariable("cdResidencia") int cdResidencia, Model model) {		
		model.addAttribute("listaRelatorioSemanal", relatorioConsumoDao.callConsultaRelatorioSemanal(cdResidencia));
		
	    return "/Relatorio/Semanal";
	}
	
	@GetMapping("/Anual/{cdResidencia}")
	public String relatorioAnual(@PathVariable("cdResidencia") int cdResidencia, Model model) {		
		model.addAttribute("listaRelatorioAnual", relatorioConsumoDao.callConsultaRelatorioAnual(cdResidencia));
		
	    return "/Relatorio/Anual";
	}
	
	@GetMapping("/Mensal/{cdResidencia}")
	public String relatorioMensal(@PathVariable("cdResidencia") int cdResidencia, Model model) {		
		model.addAttribute("listaRelatorioMensal", relatorioConsumoDao.callConsultaRelatorioMensal(cdResidencia));
		
	    return "/Relatorio/Mensal";
	}
}
