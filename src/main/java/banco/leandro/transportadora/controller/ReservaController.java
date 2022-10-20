package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.ReservaDTO;
import banco.leandro.transportadora.model.entities.Reserva;
import banco.leandro.transportadora.model.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/transportadora/reserva")
public class ReservaController {
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if(!reservaService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma reserva com este ID");
        }

        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaDTO, reserva);

        return ResponseEntity.status(HttpStatus.OK).body(reservaService.save(reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if(!reservaService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma reserva com este ID");
        }

        reservaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ReservaDTO reservaDTO, @PathVariable(value = "id") Integer id) {
        if(!reservaService.existsById(id)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi encontrada nenhuma reserva com este ID");
        }

        Reserva reserva = reservaService.findById(id).get();
        BeanUtils.copyProperties(reservaDTO, reserva);

        return ResponseEntity.status(HttpStatus.OK).body(reservaService.save(reserva));
    }

}
