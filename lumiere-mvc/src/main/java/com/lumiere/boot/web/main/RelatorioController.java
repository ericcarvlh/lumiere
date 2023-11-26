package com.lumiere.boot.web.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
	
	@GetMapping("/lista")
	public String listaRelatorio() {
		return "/relatorio/lista";
	}
	
}
