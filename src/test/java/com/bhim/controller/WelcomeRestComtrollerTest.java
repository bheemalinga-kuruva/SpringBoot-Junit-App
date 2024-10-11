package com.bhim.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bhim.service.WelComeservice;

@WebMvcTest(value = WelComeRestController.class)
public class WelcomeRestComtrollerTest {

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private WelComeservice welcomeervice;

	@Test
	public void saveUserTest() throws Exception {
		when(welcomeervice.welcome()).thenReturn("Welcome to karnataka");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

		MvcResult mvcResult = mockmvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		System.out.println("postive status"+status);
		assertEquals(201, status);

//		String contentAsString = response.getContentAsString();
//			System.out.println( "this positive "+contentAsString);
//		assertEquals("Welcome to karnataka", contentAsString);
//	
	
	
	}
	
	@Test
	public void saveUserTest2() throws Exception {
		when(welcomeervice.welcome()).thenReturn("welcome");

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

		MvcResult mvcResult = mockmvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
           
		int status = response.getStatus();
		System.out.println("nagative status     "+status);
		assertEquals(400, status);
		
//	         String contentAsString = response.getContentAsString();
//               System.out.println("this is nagative "+contentAsString);
//		assertNotEquals("Welcome to karnataka", contentAsString);
	
	}
	
	
	

}
