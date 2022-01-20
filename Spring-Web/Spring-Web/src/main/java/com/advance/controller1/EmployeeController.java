package com.advance.controller1;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.advance.model1.Employee;
import com.advance.service1.EmployeeRepository;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@GetMapping("/")
	public ModelAndView getEmployee() {
		
		List<Employee> employee=employeeRepository.findAll();
		HashMap<String, List<Employee>> model=new HashMap<String, List<Employee>>();
		model.put("list", employee);
		return new ModelAndView("employeeList",model);
	}
	
	
	@DeleteMapping("/{id}")
	public  ModelAndView deleteEmployee(@PathVariable Long id) {
		
		employeeRepository.deleteById(id);
		List<Employee> employee=employeeRepository.findAll();
		HashMap<String, List<Employee>> model=new HashMap<String, List<Employee>>();
		model.put("list", employee);
		return new ModelAndView("employeeList",model);
	}
	
	
	
//	@GetMapping("/{id}")
//	public ModelAndView getEmployeeById(@PathVariable Long id) {
//		
//		Employee emp= employeeRepository.findById(id).orElse(null);
//		HashMap<String, List<Employee>> model=new HashMap<String, List<Employee>>();
//		model.put("list", emp);
//			return new ModelAndView("employeeList",model);
//	}
//	
//	
	@PutMapping("/")
	public ModelAndView addEmployee(@RequestBody Employee employee) {

	Employee emp =employeeRepository.save(new Employee());
		
	List<Employee> e=employeeRepository.findAll();
	HashMap<String, List<Employee>> model=new HashMap<String, List<Employee>>();
	model.put("list", e);
	return new ModelAndView("employeeList",model);
		
	}
	
	@PostMapping("/{id}")
	public ModelAndView updateEmployee(@RequestBody List<Employee> employee) {
		employeeRepository.saveAll(employee);
		HashMap<String, List<Employee>> model=new HashMap<String, List<Employee>>();
		model.put("list", employee);
		
		
		return new ModelAndView("employeeList",model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
