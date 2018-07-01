package com.siva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.siva.model.Employee;
import com.siva.service.InsertService;

@Controller
public class InsertController {

	@Autowired
	InsertService insertService;

	// Insert Employee
	@RequestMapping("/add")
	public ModelAndView callInsertPage() {
		return new ModelAndView("insertpage", "command", new Employee());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute Employee emp) {
		boolean flag = insertService.insertEmployee(emp);

		if (flag) {
			return new ModelAndView("success", "msg", "Inserted Successfully");
		} else {
			return new ModelAndView("failure", "msg", "Failed to insert employee data");
		}
	}
}
