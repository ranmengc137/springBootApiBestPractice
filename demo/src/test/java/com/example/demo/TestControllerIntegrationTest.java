package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_square_success() throws Exception {
		mockMvc.perform(post("/test")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"num\":5,\"type\":\"square\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(2001))
				.andExpect(jsonPath("$.data").value(25.0));
	}

	@Test
	void test_business_error() throws Exception {
		mockMvc.perform(post("/test")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"num\":0,\"type\":\"square\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(2003)) // COMMON_FAILED
				.andExpect(jsonPath("$.message").exists());
	}
}