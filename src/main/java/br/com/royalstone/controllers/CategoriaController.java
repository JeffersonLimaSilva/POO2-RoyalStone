package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CategoriaController {
	
   @GetMapping("/categoria")
    public String mostrarPaginaCategoria() {
        return "categoria/categoria"; 
    }
}
