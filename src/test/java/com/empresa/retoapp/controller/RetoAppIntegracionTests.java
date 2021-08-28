package com.empresa.retoapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.empresa.retoapp.dto.UsersResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RetoAppIntegracionTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void whenGetUsuarios_returnUsuarios() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/hello");
		MvcResult result = mvc.perform(request).andReturn();

		String json = result.getResponse().getContentAsString();
		UsersResponse user = new ObjectMapper().readValue(json, UsersResponse.class);

		assertEquals(user.getData().size(), 6);
	}

}
