package br.com.royalstone;

import br.com.royalstone.model.Pessoa;
import br.com.royalstone.model.Endereco; // Importe Endereco, se for usá-lo
import br.com.royalstone.repository.PessoaRepository;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

// Não precisa mais de import java.time.LocalDate; se dataNasc for String

@SpringBootApplication
public class RoyalstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoyalstoneApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Optional<Pessoa> adminOptional = pessoaRepository.findByEmail("admin@royalstone.com");
            if (adminOptional.isEmpty()) {
                Pessoa adminUser = new Pessoa();
                adminUser.setEmail("admin@royalstone.com");
                adminUser.setSenha(passwordEncoder.encode("admin"));
                adminUser.setNome("Administrador");
                adminUser.setRole("ADMIN"); // <--- Garanta que a role seja "ADMIN"
                adminUser.setDataNasc("1990-01-01"); // Exemplo, ajuste conforme sua entidade
                adminUser.setEndereco(new Endereco("Rua Admin", "Cidade Admin")); // Exemplo, se Endereco for obrigatório
                pessoaRepository.save(adminUser);
                System.out.println("Usuário admin criado!");
            }
        };
    }
}