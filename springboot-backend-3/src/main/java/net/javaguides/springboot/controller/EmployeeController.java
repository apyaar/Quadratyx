package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
 private  EmployeeService employeeService;

public EmployeeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}

//build create employee REST API
@PostMapping
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
}

//build get all employee REST API
@GetMapping
public List<Employee> getAllEmployees(){
	return employeeService.getAllEmployees();
}

//build get employee by id REST API
//htttp://localhost:8080/api/employees/1
@GetMapping("{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeid){
	return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid), HttpStatus.OK);
}

//build update employee REST API
//htttp://localhost:8080/api/employees/1
@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long employeeid, @RequestBody Employee employee){
	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeid),HttpStatus.OK);
	
}
	//build delete employee REST API
	//htttp://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")long employeeid){
		employeeService.deleteEmployee(employeeid);
		return new ResponseEntity<String>("Employee deleted" , HttpStatus.OK);

}
}