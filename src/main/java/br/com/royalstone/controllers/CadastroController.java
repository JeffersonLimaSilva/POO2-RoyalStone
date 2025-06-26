package br.com.royalstone.controllers;

import br.com.royalstone.model.Pessoa;
import br.com.royalstone.model.Endereco; // Importe a classe Endereco
import br.com.royalstone.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importe a classe Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class CadastroController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastro-cliente")
    public String showCadastroForm(Model model) {
        Pessoa pessoa = new Pessoa();
        pessoa.setEndereco(new Endereco()); // <<< Esta linha é a chave para o Thymeleaf
        model.addAttribute("pessoa", pessoa);
        // Verifique o caminho real do seu template. Se for direto em templates/, use "cadastro-cliente".
        // Se estiver em templates/cliente/, então "cliente/cadastro-cliente" está correto.
        return "cliente/cadastro-cliente"; 
    }

    @PostMapping("/processar-cadastro-cliente")
    public String processarCadastro(Pessoa pessoa, RedirectAttributes ra) {
        // ... (seus campos de validação, se houver)

        pessoa.setRole("CLIENTE");
        pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));

        pessoaRepository.save(pessoa);
        ra.addFlashAttribute("mensagemSucesso", "Cadastro realizado com sucesso! Faça login.");
        return "redirect:/login";
    }
}