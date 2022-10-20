package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Passagem;
import banco.leandro.transportadora.repository.PassagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PassagemService {
    private final PassagemRepository passagemRepository;

    public List<Passagem> findAll() {
        return passagemRepository.findAll();
    }

    public Optional<Passagem> findById(Integer idPassagem) {
        return passagemRepository.findById(idPassagem);
    }

    public boolean existsById(Integer idPassagem) {
        return passagemRepository.existsById(idPassagem);
    }

    public Passagem save(Passagem passagem) {
        return passagemRepository.save(passagem);
    }

    public void deleteById(Integer idPassagem) {
        passagemRepository.deleteById(idPassagem);
    }
}