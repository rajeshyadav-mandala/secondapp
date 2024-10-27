package com.nt.controller;

import java.util.Map;

//import org.antlr.v4.runtime.misc.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeMgmtController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	
	@GetMapping("/employee_list")
	public String showEmployee(Map<String, Object> map) {
		
		Iterable<Employee> it = service.showEmployees();
		
		it.forEach(System.out::println);
		
		map.put("list", it);
		
		return "report";
	}
	
	
	@GetMapping("/emp_add")
	public String formPageEmployee(@ModelAttribute("emp") Employee emp) {
		
		return "add_emp_form";
		
	}
	
	@PostMapping("/emp_add")
	public String registerEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs ) {
			
		String messageString = service.addEmployee(emp);
		
		attrs.addFlashAttribute("messageString",messageString);
		
			return "redirect:employee_list";
			
		}
	
	@GetMapping("/emp_delete")
	public String removeEmployee(@RequestParam("no") Integer no, RedirectAttributes attrs) {
	
		String messageString = service.delteEmployeeById(no);
		
		attrs.addFlashAttribute("messageString", messageString);
		
		return "redirect:employee_list";
	}
	
	@GetMapping("/emp_edit")
	public String showEditFormPage(@RequestParam("no") Integer no, @ModelAttribute("emp") Employee emp) {
		
		Employee emp1 = service.findEmp(no);
		
		BeanUtils.copyProperties(emp1, emp);
		
		return "edit_form_page";
		
	}
	
	@PostMapping("/emp_edit")
	public String updateEmployeeData(@RequestParam("no") Integer no, @ModelAttribute("emp") Employee emp,
			
									RedirectAttributes attrs) {
		
		String messageString = service.updateEmployee(emp);
		
		attrs.addFlashAttribute("messageString", messageString);
		
		return "redirect:employee_list";
		
	}
	

}
