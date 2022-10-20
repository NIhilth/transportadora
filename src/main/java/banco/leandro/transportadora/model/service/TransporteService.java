package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Transporte;
import banco.leandro.transportadora.repository.TransporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransporteService {
    private TransporteRepository transporteRepository;

    public List<Transporte> findAll() {
        return transporteRepository.findAll();
    }

    public <S extends Transporte> S save(S entity) {
        return transporteRepository.save(entity);
    }

    public Optional<Transporte> findById(Integer integer) {
        return transporteRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return transporteRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        transporteRepository.deleteById(integer);
    }
}
