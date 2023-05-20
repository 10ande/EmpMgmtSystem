package com.emp.service;

import com.emp.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    List<Employee> findEmployeesByMaxSalary();

    List<Employee> findEmployeesByMinSalary();
}
