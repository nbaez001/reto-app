package com.empresa.retoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.retoapp.dto.UsersResponse;
import com.empresa.retoapp.dto.UsuarioRestResponse;
import com.empresa.retoapp.rest.UsuarioRest;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRest usuarioRest;
	
	public UsuarioServiceImpl(UsuarioRest usuarioRest) {
		this.usuarioRest = usuarioRest;
	}

	@Override
	public UsersResponse obtenerUsuarios() {
		List<UsuarioRestResponse> lUsuario = usuarioRest.callApiUsers().getData();

		List<String> arrUsuario = new ArrayList<>();
		for (UsuarioRestResponse us : lUsuario) {
			arrUsuario.add(us.getId() + "|" + us.getLast_name() + "|" + us.getEmail());
		}

		UsersResponse uReponse = new UsersResponse();
		uReponse.setData(arrUsuario);
		return uReponse;
	}

}
