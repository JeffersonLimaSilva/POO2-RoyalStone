package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatoController {
	
	@GetMapping("/")
	public ModelAndView contato() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/contatos");
		mv.addObject("msg", "Este é um teste");
		return mv;
	}
}
