package com.lumiere.boot.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lumiere.boot.domain.Dispositivo;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.TipoDispositivo;
import com.lumiere.boot.service.DispositivoServiceImpl;
import com.lumiere.boot.service.TipoDispositivoServiceImpl;

@Controller
@RequestMapping("/Dispositivo")
public class DispositivoController {
	@Autowired
	TipoDispositivoServiceImpl tipoDispositivoServiceImpl;
	
	@Autowired
	DispositivoServiceImpl dispositivoServiceImpl;
	
	@GetMapping("/Cadastrar/{cdResidencia}")
	public String cadastrar(@PathVariable("cdResidencia") int cdResidencia, Dispositivo dispositivo, Model model) {
		// coletar as categorias	
		model.addAttribute("tipoDispositivos", tipoDispositivoServiceImpl.buscarTodos());
		
		return "/Dispositivo/Cadastrar";
	}
	
	@PostMapping("/Cadastrar")
	public String cadastrar(Dispositivo dispositivo, @RequestParam(name = "categoriaSelect") int cdCategoria, int cdResidencia) {
		// coletando a categoria selecionada pelo usuário
		TipoDispositivo tipoDispositivo = new TipoDispositivo();
		tipoDispositivo.setId(cdCategoria);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		
		Residencia residencia = new Residencia();
		residencia.setId(cdResidencia);
		dispositivo.setResidencia(residencia);
		
		dispositivoServiceImpl.salvar(dispositivo);
				
		return "/Dispositivo/Cadastrar";
	}
}
