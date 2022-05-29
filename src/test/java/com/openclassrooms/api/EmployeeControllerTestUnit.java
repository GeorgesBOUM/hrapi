package com.openclassrooms.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.api.controller.EmployeeController;
import com.openclassrooms.api.service.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTestUnit {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService es;
	
	
	@Test
	public void testGetEmployees() throws Exception{
		mockMvc.perform(get("/employees")).andExpect(status().isOk());	
	}
}
