package com.project.service;


import java.util.List;
import java.util.stream.Collectors;
import java.sql.Connection;
import java.time.LocalDate;

import com.project.util.DbConnection;
import com.project.daos.EmployeeDaosImp;
import com.project.entity.Employee;
import com.project.exception.EmployeeNotFoundException;
import com.project.exception.NameNotFoundException;
import com.project.ifaces.CRUDRepository;

public class EmployeeService {
	Connection con = null;
	CRUDRepository repo;
	public EmployeeService() {
		con = DbConnection.getOracleConnection();
		repo = new EmployeeDaosImp(con);
	}
	public boolean addEmployee(Employee employee) {
		return repo.addEmployee(employee);
	}
	public List<Employee> getEmployee(String name) throws NameNotFoundException{
		return repo.getEmployee(name);
	}
	public Employee getEmployeeByID(int id) throws EmployeeNotFoundException {
		return repo.getEmployeeByID(id);
	}
	public boolean editEmployee(Employee employee) {
		return repo.editEmployee(employee);
	}
	public List<Object> getEmployeeOfGivenBirthDate(LocalDate date){
		List<Employee> list = repo.getEmployeeOfGivenBirthDate(date);
		return list.stream().map(emp -> ("Name=> " + emp.getFirstName() +" email=> "+emp.getEmailAddress())).collect(Collectors.toList());
	}
	
	
	public List<Object> getEmployeeOfGivenAnniversary(LocalDate date) {
		List<Employee> list = repo.getEmployeeOfGivenAnniversary(date);
		return list.stream().map(emp -> ("Name=> " +emp.getFirstName()+" email=> "+emp.getPhoneNumber())).collect(Collectors.toList());
	}
	public List<Employee> getAllEmployees(){
		return repo.getAllEmployees();
	}
	
}
