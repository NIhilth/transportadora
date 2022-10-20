package banco.leandro.transportadora.repository;

import banco.leandro.transportadora.model.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}