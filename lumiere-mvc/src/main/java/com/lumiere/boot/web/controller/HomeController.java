package com.lumiere.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/public", "classpath:/static/")
                    .setCachePeriod(31556926);
    }
}
