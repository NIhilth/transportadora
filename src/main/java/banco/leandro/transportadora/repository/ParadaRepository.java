package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParadaRepository extends JpaRepository<Parada, Integer> {

}