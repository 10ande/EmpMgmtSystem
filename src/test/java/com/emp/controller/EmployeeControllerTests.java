package com.emp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.emp.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveEmployee_shouldReturnSavedEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("john.doe@example.com");
        employee.setDepartment("IT");
        employee.setSalary(50000.0);

        String requestBody = new ObjectMapper().writeValueAsString(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.emailAddress").value("john.doe@example.com"))
                .andExpect(jsonPath("$.department").value("IT"))
                .andExpect(jsonPath("$.salary").value(50000.0));
    }
}