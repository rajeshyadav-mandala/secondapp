package com.nt.service;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> showEmployees();
	
	public String addEmployee(Employee emp);
	
	public String delteEmployeeById(Integer no);
	
	public String editEmployeeById(Employee emp);
	
	public Employee findEmp(Integer no);
	
	public String updateEmployee(Employee emp);
}
