// br.com.royalstone.repository.PessoaRepository.java
package br.com.royalstone.repository;

import br.com.royalstone.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByEmail(String email); // Adicione ou confirme este método
    // Optional<Pessoa> findByNome(String nome); // Se não for mais usar, pode remover
}