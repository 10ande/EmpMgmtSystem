package com.emp.controller;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/max-salary")
    public ResponseEntity<List<Employee>> findEmployeesByMaxSalary() {
        List<Employee> employees = employeeService.findEmployeesByMaxSalary();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/min-salary")
    public ResponseEntity<List<Employee>> findEmployeesByMinSalary() {
        List<Employee> employees = employeeService.findEmployeesByMinSalary();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}