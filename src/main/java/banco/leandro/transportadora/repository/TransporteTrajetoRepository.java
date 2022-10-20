package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.TransporteTrajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteTrajetoRepository extends JpaRepository<TransporteTrajeto, Integer> {

}
