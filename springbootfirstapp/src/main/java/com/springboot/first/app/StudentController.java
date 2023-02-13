package com.springboot.first.app;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//http://localhost:8080/student 
	@GetMapping("/student")
public Student getStudent() {
	return new Student("Ayushi" , "Pal");
}
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("kiwi" , "Kumari"));
		students.add(new Student("Cheeku" , "Chauhan"));
		students.add(new Student("Papaya" , "Pal"));
		students.add(new Student("Mango" , "Malhotra"));
		students.add(new Student("Jackfruit" , "Jadhav"));
	 return students;
	}
	//http://localhost:8080/student/1
	// @PathVariable annotation 
	@GetMapping("/student/{firstName}/{lastName}/")
        public Student studentPathVariabe(@PathVariable("firstName") String firstName , @PathVariable("lastName") String lastName) {
        return new Student(firstName , lastName);
        }
        // build rest API to handle query parameters
        // http://localhost:8080/student/query?firstName=Ayushi&lastName=Pal
	@GetMapping("/student/query")
	public Student studentQueryParam(@RequestParam(name = "firstName") String firstName ,@RequestParam(name="lastName") String lastName) {
	return new Student(firstName , lastName);
	} 
}

