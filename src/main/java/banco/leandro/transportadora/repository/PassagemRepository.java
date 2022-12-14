package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}