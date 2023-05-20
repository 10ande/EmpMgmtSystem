package com.emp.repository;

import com.emp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    Employee findById(long id);

    List<Employee> findByDepartment(String department);

    List<Employee> findByEmailAddress(String emailAddress);

    List<Employee> findBySalaryOrderBySalaryDesc(double salary);

    List<Employee> findBySalaryOrderBySalaryAsc(double salary);

    List<Employee> findBySalary(double salary);

    @Query("SELECT MAX(e.salary) FROM Employee e")
    double findMaxSalary();

    @Query("SELECT MIN(e.salary) FROM Employee e")
    double findMinSalary();
}