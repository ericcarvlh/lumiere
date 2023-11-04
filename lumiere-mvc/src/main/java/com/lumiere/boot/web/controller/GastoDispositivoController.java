package com.lumiere.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Gasto")
public class GastoDispositivoController {

	@GetMapping("/Registrar")
	public String registrar() {
		return "/Gasto/Dispositivo";
	}
}
