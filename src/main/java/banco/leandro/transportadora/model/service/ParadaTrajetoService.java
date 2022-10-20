package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.ParadaTrajeto;
import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.repository.ParadaTrajetoRepository;
import banco.leandro.transportadora.repository.TrajetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParadaTrajetoService {
    ParadaTrajetoRepository paradaTrajetoRepository;

    public List<ParadaTrajeto> findAll() {
        return paradaTrajetoRepository.findAll();
    }

    public <S extends ParadaTrajeto> S save(S entity) {
        return paradaTrajetoRepository.save(entity);
    }

    public Optional<ParadaTrajeto> findById(Integer integer) {
        return paradaTrajetoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return paradaTrajetoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        paradaTrajetoRepository.deleteById(integer);
    }
}
