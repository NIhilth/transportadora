package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.Trajeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepository extends JpaRepository<Trajeto, Integer> {

}
