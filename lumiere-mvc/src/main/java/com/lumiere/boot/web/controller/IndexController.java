package com.lumiere.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controller para a pagina index

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
}
