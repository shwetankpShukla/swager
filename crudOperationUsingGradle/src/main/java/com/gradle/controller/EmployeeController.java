package com.gradle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradle.model.Employee;
import com.gradle.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/addEmployee")
	@ExceptionHandler(Exception.class)
	public ResponseEntity saveEmployee(@RequestBody(required = false) Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity("EmployeeRecord saved successfully", HttpStatus.CREATED);

	}

	@GetMapping("/getAllEmployee")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
		List<Employee> listEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);

	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeId(@PathVariable long id) {
		Optional<Employee> getById = employeeService.getEmployeeById(id);
		return new ResponseEntity<Optional<Employee>>(getById, HttpStatus.ACCEPTED);
	}
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping(value="/delete/{id}")
	    public ResponseEntity delete(@PathVariable Integer id){
		 employeeService.deleteEmployee(id);
	        return new ResponseEntity("Employee Record deleted successfully", HttpStatus.OK);
	    }


}
