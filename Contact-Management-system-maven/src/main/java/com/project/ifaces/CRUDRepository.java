package com.project.ifaces;

import java.time.LocalDate;
import java.util.List;

import com.project.entity.Employee;
import com.project.exception.EmployeeNotFoundException;
import com.project.exception.NameNotFoundException;

public interface CRUDRepository {
    boolean addEmployee(Employee employee);
    List<Employee> getEmployee(String name) throws NameNotFoundException;
    Employee getEmployeeByID(int id) throws EmployeeNotFoundException ;
    boolean editEmployee(Employee employee);
    List<Employee> getEmployeeOfGivenBirthDate(LocalDate date);
    List<Employee> getEmployeeOfGivenAnniversary(LocalDate date);
    List<Employee> getAllEmployees();
    
}
