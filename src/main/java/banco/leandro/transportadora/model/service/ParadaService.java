package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Parada;
import banco.leandro.transportadora.repository.ParadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParadaService {
    private final ParadaRepository paradaRepository;

    public List<Parada> findAll() {
        return paradaRepository.findAll();
    }

    public Optional<Parada> findById(Integer idParada) {
        return paradaRepository.findById(idParada);
    }

    public boolean existsById(Integer idParada) {
        return paradaRepository.existsById(idParada);
    }

    public Parada save(Parada parada) {
        return paradaRepository.save(parada);
    }

    public void deleteById(Integer idParada) {
        paradaRepository.deleteById(idParada);
    }
}