package com.emp.service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findEmployeesByMaxSalary() {
        double maxSalary = employeeRepository.findMaxSalary();
        return employeeRepository.findBySalaryOrderBySalaryDesc(maxSalary);
    }

    @Override
    public List<Employee> findEmployeesByMinSalary() {
        double minSalary = employeeRepository.findMinSalary();
        return employeeRepository.findBySalaryOrderBySalaryAsc(minSalary);
    }
}

