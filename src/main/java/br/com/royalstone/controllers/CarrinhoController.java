package br.com.royalstone.controllers;

import br.com.royalstone.model.Joia;
import br.com.royalstone.model.ItemCarrinho;
import br.com.royalstone.repository.JoiaRepository;
import br.com.royalstone.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;
    private final JoiaRepository joiaRepository;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService, JoiaRepository joiaRepository) {
        this.carrinhoService = carrinhoService;
        this.joiaRepository = joiaRepository;
    }

    @GetMapping // Exibe o conteúdo do carrinho
    public String exibirCarrinho(Model model) {
        model.addAttribute("itensCarrinho", carrinhoService.getItens());
        model.addAttribute("totalCarrinho", carrinhoService.getTotalCarrinho());
        return "cliente/carrinho"; // Nome do template: src/main/resources/templates/carrinho.html
    }

    @PostMapping("/adicionar") // Processa a adição de um item ao carrinho
    public String adicionarAoCarrinho(@RequestParam("joiaId") Long joiaId,
                                      @RequestParam(value = "quantidade", defaultValue = "1") int quantidade,
                                      RedirectAttributes redirectAttributes) {
        
        if (quantidade <= 0) {
            redirectAttributes.addFlashAttribute("mensagemErro", "A quantidade deve ser pelo menos 1.");
            return "redirect:/loja"; // Redireciona de volta à loja
        }

        Joia joia = joiaRepository.findById(joiaId)
                                  .orElse(null);

        if (joia == null) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Joia não encontrada!");
            return "redirect:/loja";
        }

        if (joia.getEstoque() < quantidade) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Estoque insuficiente para a quantidade desejada de " + joia.getNome() + ".");
            return "redirect:/loja";
        }

        ItemCarrinho item = new ItemCarrinho(joia.getId(), joia.getNome(), joia.getPreco(), quantidade, joia.getImagemUrl());
        carrinhoService.adicionarItem(item);
        
        redirectAttributes.addFlashAttribute("mensagemSucesso", joia.getNome() + " adicionado(a) ao carrinho!");
        return "redirect:/loja"; // Redireciona de volta à loja após adicionar
    }

    @PostMapping("/remover") // Remove um item do carrinho
    public String removerDoCarrinho(@RequestParam("joiaId") Long joiaId,
                                    RedirectAttributes redirectAttributes) {
        carrinhoService.removerItem(joiaId);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Item removido do carrinho.");
        return "redirect:/carrinho"; // Redireciona de volta para a página do carrinho
    }

    @PostMapping("/limpar") // Limpa o carrinho
    public String limparCarrinho(RedirectAttributes redirectAttributes) {
        carrinhoService.limparCarrinho();
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Carrinho limpo com sucesso.");
        return "redirect:/carrinho";
    }

    // Futuramente, você adicionaria métodos para finalizar compra (checkout) aqui
}