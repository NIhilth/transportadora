package banco.leandro.transportadora.model.service;

import banco.leandro.transportadora.model.entities.Reserva;
import banco.leandro.transportadora.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReservaService {
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public <S extends Reserva> S save(S entity) {
        return reservaRepository.save(entity);
    }

    public Optional<Reserva> findById(Integer integer) {
        return reservaRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reservaRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        reservaRepository.deleteById(integer);
    }
}
