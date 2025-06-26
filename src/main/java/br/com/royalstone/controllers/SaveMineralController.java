package br.com.royalstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.royalstone.model.Mineral;
import br.com.royalstone.repository.MineralRepository;

@Controller
@RequestMapping("/admin/index")
public class SaveMineralController {

    private MineralRepository mineralRepository = null;

    public void MineralController(MineralRepository mineralRepository) {
        this.mineralRepository = mineralRepository;
    }

    @PostMapping
    public String salvar(@ModelAttribute Mineral mineral) {
        mineralRepository.save(mineral);
        return "redirect:/admin/index";
    }

    // para exibir o formulário
    @GetMapping("/novo")
    public String mostrarFormulario(Mineral mineral) {
        return "index"; // nome da página HTML ou Thymeleaf
    }
}

