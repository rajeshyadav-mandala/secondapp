package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repo.IEmployeeRepo;

@Service
public class EmployeeMgmtService implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public Iterable<Employee> showEmployees() {
		
		return repo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		
		return "Employee Object is saved with the no: "+ repo.save(emp).getEno();
	}

	@Override
	public String delteEmployeeById(Integer no) {
		
		Boolean flag = repo.existsById(no);
		
		if(flag) {
			repo.deleteById(no);
			return "Employee found and deleted";
		} 	
		return "Employee not found";
	}

	@Override
	public String editEmployeeById(Employee emp) {
		
		repo.save(emp);
		
		return "Employee with the id: "+emp.getEno()+"is edited and the new values were inserted"; 
	}

	@Override
	public Employee findEmp(Integer no) {
	
		 return repo.findById(no).orElseThrow(()->new IllegalArgumentException("Employee not found"));
		
	}

	@Override
	public String updateEmployee(Employee emp) {
		repo.save(emp);
		return "Employee details are edited "+emp.getEno();
	}

}
