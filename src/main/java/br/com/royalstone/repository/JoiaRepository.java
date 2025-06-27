package br.com.royalstone.repository;

import br.com.royalstone.model.Joia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Long> {
	 List<Joia> findByEstoqueGreaterThan(int quantidade);
    // Métodos de busca adicionais se precisar (ex: findByNomeContainingIgnoreCase)
}