// br.com.royalstone.repository.MineralPreciosoRepository.java
package br.com.royalstone.repository;
import br.com.royalstone.model.MineralPrecioso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MineralPreciosoRepository extends JpaRepository<MineralPrecioso, Long> {}