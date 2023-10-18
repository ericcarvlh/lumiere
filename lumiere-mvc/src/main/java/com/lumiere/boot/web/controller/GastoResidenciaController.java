package com.lumiere.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gastos")
public class GastoResidenciaController {

	@GetMapping("/cadastrar")
	public String registrar() {
		return "gasto/gastoresidencia";
	}
}
