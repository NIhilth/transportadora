package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.ParadaTrajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParadaTrajetoRepository extends JpaRepository<ParadaTrajeto, Integer> {
}
