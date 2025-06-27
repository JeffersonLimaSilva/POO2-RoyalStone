// br.com.royalstone.repository.MineralMetalicoRepository.java
package br.com.royalstone.repository;
import br.com.royalstone.model.MineralMetalico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MineralMetalicoRepository extends JpaRepository<MineralMetalico, Long> {}