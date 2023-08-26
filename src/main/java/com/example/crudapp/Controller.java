package com.example.crudapp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {
	@Autowired
	StudentRepository studentrepo;
	
	
	@RequestMapping("delete/{id}")
	List<Student>  deleteid(@PathVariable int id)
	{
		studentrepo.deleteById(id);
		return studentrepo.findAll();
	}
	
	@RequestMapping("getall")
	List<Student> getall(Student student) {
		return studentrepo.findAll();
	}
	
	@RequestMapping("Save")
	List<Student> Add(@Validated @RequestBody Student student) {
		studentrepo.save(student);
		return studentrepo.findAll();
	}
	
	@RequestMapping("Addz")
	String Addz(@RequestBody Student student) {
		 studentrepo.save(student);
		 return "done";
	}
}
