package com.lumiere.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller para a pagina index

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
}
