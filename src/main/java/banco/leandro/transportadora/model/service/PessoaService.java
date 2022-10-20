package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Pessoa;
import banco.leandro.transportadora.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public <S extends Pessoa> S save(S entity) {
        return pessoaRepository.save(entity);
    }

    public Optional<Pessoa> findById(Integer integer) {
        return pessoaRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return pessoaRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        pessoaRepository.deleteById(integer);
    }
}
