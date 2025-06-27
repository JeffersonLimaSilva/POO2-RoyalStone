package br.com.royalstone.controllers;

import br.com.royalstone.model.Joia; // Importe Joia
import br.com.royalstone.repository.JoiaRepository; // Importe JoiaRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loja")
public class LojaController {

    private final JoiaRepository joiaRepository; // Use JoiaRepository

    @Autowired
    public LojaController(JoiaRepository joiaRepository) { // Injetar JoiaRepository
        this.joiaRepository = joiaRepository;
    }

    @GetMapping
    public String listarJoias(Model model) {
        List<Joia> joiasDisponiveis = joiaRepository.findByEstoqueGreaterThan(0); // Assumindo que você adiciona findByEstoqueGreaterThan a JoiaRepository
        model.addAttribute("joias", joiasDisponiveis); // Mude o nome do atributo para 'joias'
        return "cliente/loja";
    }
}