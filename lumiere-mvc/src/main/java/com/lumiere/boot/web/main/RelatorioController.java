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
	
	@Autowired 
	private ResidenciaService residenciaService;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	private static final Logger logger = LoggerFactory.getLogger(RelatorioController.class);
	
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
	
	/*@GetMapping("/Selecionar")
	public String escolherRelatorio() {
		return "/Relatorio/Selecionar";
	}  */
	
	
	@GetMapping("/Semanal/{cdResidencia}")
	public String relatorioSemanal(@PathVariable("cdResidencia") int cdResidencia, Model model) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String relatorioSemanal = formatter.format(relatorioConsumoDao.callConsultaRelatorioSemanal(cdResidencia).getConsumoTotal());
		Residencia residencia = residenciaService.buscarResidenciaPorCdResidencia(cdResidencia);
		Dispositivo dispositivo = (Dispositivo) dispositivoService.consultarDispositivosPorCdResidencia(cdResidencia);
	    
		// Logs
	    logger.info("Data returned from DAO: " + relatorioSemanal);
	    
	    String valorPorKWh = formatter.format(dispositivo.getNomeDispositivo());
		String faturaAtual = formatter.format(relatorioConsumoDao.callConsultaFaturaAtual(cdResidencia).getConsumoTotal());
		String consumoMedio = formatter.format(relatorioConsumoDao.callConsultaConsumoMedio60Dias(cdResidencia).getConsumoTotal());
		
		model.addAttribute("UFEstado", residencia.getEstado().getUFEstado());
		model.addAttribute("precoKWh", valorPorKWh);
		model.addAttribute("faturaAtual", faturaAtual);
		model.addAttribute("consumoMedio", consumoMedio);
	    
	    return "/Relatorio/Semanal";
	}
	
	
	
}
