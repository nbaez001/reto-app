package com.empresa.retoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.empresa.retoapp.dto.OutRestResponse;
import com.empresa.retoapp.dto.UsersResponse;
import com.empresa.retoapp.dto.UsuarioRestResponse;
import com.empresa.retoapp.rest.UsuarioRest;

@RunWith(SpringJUnit4ClassRunner.class)
public class RetoAppUnitTests {

	@Mock
	UsuarioRest usuarioRest;

	private UsuarioService usuarioService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		usuarioService = new UsuarioServiceImpl(usuarioRest);

		List<UsuarioRestResponse> lur = new ArrayList<>();
		UsuarioRestResponse ur = new UsuarioRestResponse();
		ur.setId(1);
		ur.setFirst_name("Nerio");
		ur.setLast_name("Baez");
		lur.add(ur);
		OutRestResponse<UsuarioRestResponse> out = new OutRestResponse<>();
		out.setPage(1);
		out.setPerPage(6);
		out.setTotal(6);
		out.setTotalPages(1);
		out.setData(lur);
		
		Mockito.when(usuarioRest.callApiUsers()).thenReturn(out);
	}

	@Test
	public void whenGetUser_ThenReturnUser() {
		UsersResponse retorno = usuarioService.obtenerUsuarios();
		Assertions.assertThat(retorno.getData().size()==1);
	}
}
