package com.empresa.retoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.retoapp.dto.UsersResponse;
import com.empresa.retoapp.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService helloService;

	@PostMapping("/usuarios")
	public UsersResponse hello() {
		return helloService.obtenerUsuarios();
	}
}
