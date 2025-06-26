package br.com.royalstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.royalstone.model.Mineral;

@Repository
public interface MineralRepository extends JpaRepository<Mineral, Long> {
    // Aqui você pode adicionar métodos personalizados se quiser
}
