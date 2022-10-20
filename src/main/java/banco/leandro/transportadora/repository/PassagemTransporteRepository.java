package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.PassagemTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemTransporteRepository extends JpaRepository<PassagemTransporte, Integer> {
}
