package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.PassagemTransporte;
import banco.leandro.transportadora.repository.PassagemTransporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PassagemTransporteService {
    private PassagemTransporteRepository passagemTransporteRepository;

    public List<PassagemTransporte> findAll() {
        return passagemTransporteRepository.findAll();
    }

    public <S extends PassagemTransporte> S save(S entity) {
        return passagemTransporteRepository.save(entity);
    }

    public Optional<PassagemTransporte> findById(Integer integer) {
        return passagemTransporteRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return passagemTransporteRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        passagemTransporteRepository.deleteById(integer);
    }
}
