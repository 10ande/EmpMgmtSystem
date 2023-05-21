package com.emp;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeManagementSystemTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("john.doe@example.com");
        employee.setDepartment("IT");

        Employee savedEmployee = employeeService.saveEmployee(employee);

        Assertions.assertNotNull(savedEmployee.getId());
        Assertions.assertEquals("John", savedEmployee.getFirstName());
        Assertions.assertEquals("Doe", savedEmployee.getLastName());
        Assertions.assertEquals("john.doe@example.com", savedEmployee.getEmailAddress());
        Assertions.assertEquals("IT", savedEmployee.getDepartment());
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmailAddress("john.doe@example.com");
        employee.setDepartment("IT");

        Employee savedEmployee = employeeService.saveEmployee(employee);
        Long employeeId = savedEmployee.getId();

        Employee foundEmployee = employeeService.findEmployeeById(employeeId);

        Assertions.assertNotNull(foundEmployee);
        Assertions.assertEquals("John", foundEmployee.getFirstName());
        Assertions.assertEquals("Doe", foundEmployee.getLastName());
        Assertions.assertEquals("john.doe@example.com", foundEmployee.getEmailAddress());
        Assertions.assertEquals("IT", foundEmployee.getDepartment());
    }

    @Test
    public void testFindEmployeesByMaxSalary() {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setEmailAddress("john.doe@example.com");
        employee1.setDepartment("IT");
        employee1.setSalary(5000.0);

        Employee employee2 = new Employee();
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");
        employee2.setEmailAddress("jane.smith@example.com");
        employee2.setDepartment("HR");
        employee2.setSalary(7000.0);

        Employee employee3 = new Employee();
        employee3.setFirstName("Mike");
        employee3.setLastName("Johnson");
        employee3.setEmailAddress("mike.johnson@example.com");
        employee3.setDepartment("Finance");
        employee3.setSalary(6000.0);

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        employeeService.saveEmployee(employee3);

        List<Employee> employees = employeeService.findEmployeesByMaxSalary();

        Assertions.assertEquals(1, employees.size());
        Assertions.assertEquals("Jane", employees.get(0).getFirstName());
        Assertions.assertEquals("Smith", employees.get(0).getLastName());
        Assertions.assertEquals("jane.smith@example.com", employees.get(0).getEmailAddress());
        Assertions.assertEquals("HR", employees.get(0).getDepartment());
        Assertions.assertEquals(7000.0, employees.get(0).getSalary());
    }

    @Test
    public void testFindEmployeesByMinSalary() {
        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setEmailAddress("john.doe@example.com");
        employee1.setDepartment("IT");
        employee1.setSalary(5000.0);

        Employee employee2 = new Employee();
        employee2.setFirstName("Jane");
        employee2.setLastName("Smith");
        employee2.setEmailAddress("jane.smith@example.com");
        employee2.setDepartment("HR");
        employee2.setSalary(7000.0);

        Employee employee3 = new Employee();
        employee3.setFirstName("Mike");
        employee3.setLastName("Johnson");
        employee3.setEmailAddress("mike.johnson@example.com");
        employee3.setDepartment("Finance");
        employee3.setSalary(6000.0);

        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        employeeService.saveEmployee(employee3);

        List<Employee> employees = employeeService.findEmployeesByMinSalary();

        Assertions.assertEquals(1, employees.size());
        Assertions.assertEquals("John", employees.get(0).getFirstName());
        Assertions.assertEquals("Doe", employees.get(0).getLastName());
        Assertions.assertEquals("john.doe@example.com", employees.get(0).getEmailAddress());
        Assertions.assertEquals("IT", employees.get(0).getDepartment());
        Assertions.assertEquals(5000.0, employees.get(0).getSalary());
    }
}
