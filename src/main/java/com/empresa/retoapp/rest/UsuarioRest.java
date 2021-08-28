package com.empresa.retoapp.rest;

import com.empresa.retoapp.dto.OutRestResponse;
import com.empresa.retoapp.dto.UsuarioRestResponse;

public interface UsuarioRest {

	public OutRestResponse<UsuarioRestResponse> callApiUsers();
}
