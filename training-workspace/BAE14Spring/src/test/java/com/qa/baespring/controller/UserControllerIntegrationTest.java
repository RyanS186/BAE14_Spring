package com.qa.baespring.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.baespring.domain.User;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql","classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) // Runs these scripts before EVERY test method
@ActiveProfiles("test") // Treats the application.properties file as if the profile were set to test
public class UserControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		User entry = new User("Jim", "Jones", 15, "JJones1", "JJones1@gmail.com");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		User result = new User(2L, "Jim", "Jones", 15, "JJones1", "JJones1@gmail.com");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/user/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		User user = new User(1L, "Ryan", "Sharp", 26, "RyanS186", "RyanSharp186@gmail.com");
		List<User> output = new ArrayList<>();
		output.add(user);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/user/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));

	}
	
	// getByID Test
	@Test
	public void getByIdTest() throws Exception {
		User user = new User(1L, "Ryan", "Sharp", 26, "RyanS186", "RyanSharp186@gmail.com");
		String userAsJSON = mapper.writeValueAsString(user);
		
		mvc.perform(get("/user/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(userAsJSON));

	}
	
	// updateTest
	@Test
	public void updateTest() throws Exception {
		User entry = new User("Jim", "Jones", 15, "JJones1", "JJones1@gmail.com");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		User result = new User(1L, "Jim", "Jones", 15, "JJones1", "JJones1@gmail.com");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(put("/user/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}

	
	// deleteReqiest
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/user/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
