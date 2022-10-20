package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.repository.TrajetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrajetoService {
    TrajetoRepository trajetoRepository;

    public List<Trajeto> findAll() {
        return trajetoRepository.findAll();
    }

    public <S extends Trajeto> S save(S entity) {
        return trajetoRepository.save(entity);
    }

    public Optional<Trajeto> findById(Integer integer) {
        return trajetoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return trajetoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        trajetoRepository.deleteById(integer);
    }
}
