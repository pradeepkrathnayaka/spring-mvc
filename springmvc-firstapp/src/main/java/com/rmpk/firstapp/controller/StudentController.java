package com.rmpk.firstapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rmpk.firstapp.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		System.out.println(request.getServletPath());
		return "index";
	}
	
	@RequestMapping("/helloResponse")
	@ResponseBody
	public String printHello() {
		return "Spring MVC hello response!!!!";
	}
	
	@ModelAttribute(name= "countrieslist")
	public List<String> populateCountries() {
		List<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("United States");
		countries.add("Japan");
		countries.add("Australia");
		countries.add("Canda");
		return countries;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model) {
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result";
	}

}
