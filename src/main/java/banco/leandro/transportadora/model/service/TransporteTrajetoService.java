package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.TransporteTrajeto;
import banco.leandro.transportadora.repository.TransporteTrajetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransporteTrajetoService {
    private TransporteTrajetoRepository transporteTrajetoRepository;

    public List<TransporteTrajeto> findAll() {
        return transporteTrajetoRepository.findAll();
    }

    public <S extends TransporteTrajeto> S save(S entity) {
        return transporteTrajetoRepository.save(entity);
    }

    public Optional<TransporteTrajeto> findById(Integer integer) {
        return transporteTrajetoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return transporteTrajetoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        transporteTrajetoRepository.deleteById(integer);
    }
}
