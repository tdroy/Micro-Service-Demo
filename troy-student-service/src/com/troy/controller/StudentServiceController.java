package com.troy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.troy.pojo.Student;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();

	static {
		schooDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Rohit", "Class IV");
		lst.add(std);
		std = new Student("Sukumar", "Class V");
		lst.add(std);

		schooDB.put("icicischool", lst);

		lst = new ArrayList<Student>();
		std = new Student("Kaustav", "Class III");
		lst.add(std);
		std = new Student("Mayanak", "Class VI");
		lst.add(std);

		schooDB.put("osbschool", lst);

	}
	
	

	@RequestMapping(value = "/student/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schooDB.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}
