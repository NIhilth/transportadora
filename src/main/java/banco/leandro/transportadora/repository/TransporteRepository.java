package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Integer> {
}
