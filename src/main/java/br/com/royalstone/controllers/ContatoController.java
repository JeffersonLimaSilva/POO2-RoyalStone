package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContatoController {
	
   @GetMapping("/contato")
    public String mostrarPaginaContato() {
        return "contato/contato"; // Thymeleaf vai procurar contato.html em /templates
    }
}
