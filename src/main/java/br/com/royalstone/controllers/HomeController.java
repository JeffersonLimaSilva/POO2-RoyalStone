package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	    @GetMapping({"/", "/home"})
	    public String mostrarHome() {
	        return "home/index"; // 
	}
}
