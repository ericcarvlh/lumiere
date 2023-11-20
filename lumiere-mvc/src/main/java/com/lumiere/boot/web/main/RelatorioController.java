package com.lumiere.boot.web.main;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lumiere.boot.dao.RelatorioConsumoDao;

import com.lumiere.boot.domain.RelatorioConsumo;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@GetMapping("/lista")
	public String listaRelatorio() {
		
		
		
		
		
		return "/relatorio/lista";
	}
	
	
	
}
