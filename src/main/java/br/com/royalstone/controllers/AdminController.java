package br.com.royalstone.controllers;

import br.com.royalstone.model.Mineral;
import br.com.royalstone.repository.MineralRepository;
import br.com.royalstone.enums.CorMineral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/minerais")
public class AdminController {

    private final MineralRepository mineralRepository;

    @Autowired
    public AdminController(MineralRepository mineralRepository) {
        this.mineralRepository = mineralRepository;
    }

    // Método para exibir o formulário de NOVO mineral
    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("mineral", new Mineral());
        model.addAttribute("cores", CorMineral.values());
        return "admin/formulario";
    }

    // Método para exibir o formulário de EDIÇÃO de mineral
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Mineral mineral = mineralRepository.findById(id)
                                          .orElseThrow(() -> new IllegalArgumentException("ID de mineral inválido:" + id));
        model.addAttribute("mineral", mineral);
        model.addAttribute("cores", CorMineral.values());
        return "admin/formulario";
    }

    // Método para SALVAR ou ATUALIZAR um mineral

@PostMapping // Mapeia requisições POST para /admin/minerais
public String salvarMineral(Mineral mineral, RedirectAttributes redirectAttributes) {
    // --- NOVO PONTO DE DEBBUGAÇÃO MUITO CLARO ---
    System.out.println("########## MÉTODO SALVAR MINERAL INICIADO! ##########");
    System.out.println("DEBUG: Recebido Mineral para salvar: " + mineral.toString());

    try {
        mineralRepository.save(mineral);
        System.out.println("DEBUG: Mineral salvo com sucesso! ID: " + mineral.getId());
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Mineral salvo/atualizado com sucesso!");
    } catch (Exception e) {
        System.err.println("ERRO: Falha ao salvar mineral: " + e.getMessage());
        e.printStackTrace();
        redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao salvar mineral: " + e.getLocalizedMessage());
        return "redirect:/admin/minerais/novo";
    }

    return "redirect:/admin/minerais";
}

    // Método para listar todos os minerais
    @GetMapping
    public String listarMinerais(Model model) {
        System.out.println("DEBUG: Buscando todos os minerais para exibir na lista...");
        java.util.List<Mineral> minerais = mineralRepository.findAll();
        model.addAttribute("minerais", minerais);
        System.out.println("DEBUG: Total de minerais encontrados: " + minerais.size());
        return "admin/minerais"; // <--- ALTERADO AQUI PARA O NOME CORRETO DO SEU ARQUIVO HTML
    }

    // Método para excluir um mineral (opcional)
    @GetMapping("/excluir/{id}")
    public String excluirMineral(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            mineralRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Mineral excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao excluir mineral: " + e.getLocalizedMessage());
        }
        return "redirect:/admin/minerais";
    }
}