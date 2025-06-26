package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // Mapeia a URL raiz da sua aplicação (localhost:8080/)
    public String showHomePage() {
        
        return "cliente/index"; 
    }

    @GetMapping("/contato")
    public String showContatoPage() {
        
        return "cliente/contato"; 
    }

    @GetMapping("/categoria")
    public String showCategoriasPage() {
        
        return "cliente/categoria";
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
    	return "cliente/login";
    }
}