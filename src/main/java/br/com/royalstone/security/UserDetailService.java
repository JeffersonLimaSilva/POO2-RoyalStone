// br.com.royalstone.security.UserDetailService.java
package br.com.royalstone.security;

import br.com.royalstone.model.Pessoa;
import br.com.royalstone.repository.PessoaRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional; // Importar Optional

@Service
public class UserDetailService implements UserDetailsService {

    private final PessoaRepository pessoaRepository;

    public UserDetailService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Renomeie o parâmetro para 'username' para maior clareza,
        // pois ele representa o que o Spring Security está enviando (o email)
        Optional<Pessoa> pessoaOptional = pessoaRepository.findByEmail(username); // <-- BUSQUE PELO EMAIL AQUI

        Pessoa pessoa = pessoaOptional.orElseThrow(() ->
            new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + username));

        // Adiciona o prefixo "ROLE_" ao papel antes de criá-lo como SimpleGrantedAuthority
        String roleWithPrefix = "ROLE_" + pessoa.getRole().toUpperCase();

        return new User(
            pessoa.getEmail(), // O username do UserDetails do Spring Security deve ser o email
            pessoa.getSenha(), // A senha criptografada
            Collections.singletonList(new SimpleGrantedAuthority(roleWithPrefix))
        );
    }
}	