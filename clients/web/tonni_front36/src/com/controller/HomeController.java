package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	
	/* ############################# User Management ####################################### */
	
	 
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView indexPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("homepage", "message", message);
		
	}
	 
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("home", "message", message);
		
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView aboutPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("about", "message", message);
		
	}
	
	@RequestMapping(value = { "/academic" }, method = RequestMethod.GET)
	public ModelAndView academicPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("academic", "message", message);
		
	}
	@RequestMapping(value = { "/admission" }, method = RequestMethod.GET)
	public ModelAndView admissionPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("admission", "message", message);
		
	}
	@RequestMapping(value = { "/admissionList" }, method = RequestMethod.GET)
	public ModelAndView admissionListPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("admissionList", "message", message);
		
	}
	@RequestMapping(value = { "/admissionUpdate" }, method = RequestMethod.GET)
	public ModelAndView admissionUpdatePage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("admissionUpdate", "message", message);
		
	}
	@RequestMapping(value = { "/school" }, method = RequestMethod.GET)
	public ModelAndView schoolPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("school", "message", message);
		
	}
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public ModelAndView contactPage(ModelMap model) {
		String message = "Hello World, Spring MVC @ Javatpoint";
		return new ModelAndView("contact", "message", message);
		
	}
}
