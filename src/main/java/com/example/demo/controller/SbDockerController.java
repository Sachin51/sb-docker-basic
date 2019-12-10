package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/docker")
public class SbDockerController {
	
	@GetMapping
	public String index() {
		return "Spring Boot Docker basic example";
	}
}
