package br.com.royalstone;

import br.com.royalstone.model.Pessoa;
import br.com.royalstone.model.Endereco; // Importe Endereco, se for usá-lo
import br.com.royalstone.repository.PessoaRepository;
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
    public CommandLineRunner createDefaultAdminUser(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder) {
        return (args) -> {
            if (pessoaRepository.findByEmail("admin@royalstone.com").isEmpty()) {
                Pessoa adminUser = new Pessoa();
                
                adminUser.setNome("Administrador Royalstone"); 
                adminUser.setEmail("admin@royalstone.com"); 
                adminUser.setSenha(passwordEncoder.encode("admin")); 
                adminUser.setRole("ADMIN"); 

                // --- CORREÇÃO AQUI: Atribuindo a data como String ---
                adminUser.setCpf("000.000.000-00"); 
                adminUser.setTelefone("99999999999"); 
                adminUser.setDataNasc("1990-01-01"); // <--- Agora é uma String no formato YYYY-MM-DD

                // Se Endereco for obrigatório e não-nulo, você precisará criá-lo
                Endereco enderecoAdmin = new Endereco();
                enderecoAdmin.setRua("Rua do Admin");
                enderecoAdmin.setCidade("Cidade do Admin");
                adminUser.setEndereco(enderecoAdmin); 

                pessoaRepository.save(adminUser);
                System.out.println("Usuário 'admin' padrão criado com sucesso!");
            } else {
                System.out.println("Usuário 'admin@royalstone.com' já existe. Nenhuma ação necessária.");
            }
        };
    }
}