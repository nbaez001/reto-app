package com.empresa.retoapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.empresa.retoapp.dto.OutRestResponse;
import com.empresa.retoapp.dto.UsuarioRestResponse;

@Component
public class UsuarioRestImpl implements UsuarioRest {

	@Value("${services.api.users}")
	private String apiUsers;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public OutRestResponse<UsuarioRestResponse> callApiUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity entity = new HttpEntity<>(headers);
		@SuppressWarnings("rawtypes")
		ResponseEntity<OutRestResponse> responseEntity = restTemplate.exchange(apiUsers, HttpMethod.GET, entity,
				OutRestResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		OutRestResponse<UsuarioRestResponse> outRest = mapper.convertValue(responseEntity.getBody(),
				new TypeReference<OutRestResponse<UsuarioRestResponse>>() {
				});

		return outRest;
	}

}
