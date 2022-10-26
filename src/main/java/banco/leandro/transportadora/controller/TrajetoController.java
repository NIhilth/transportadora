package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.ReservaDTO;
import banco.leandro.transportadora.DTO.TrajetoDTO;
import banco.leandro.transportadora.model.entities.Reserva;
import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.model.service.TrajetoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/transportadora/trajeto")

public class TrajetoController {
    private TrajetoService trajetoService;

    @GetMapping
    public ResponseEntity<List<Trajeto>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(trajetoService.findAll());
    }

    @GetMapping("/{idTrajeto}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idTrajeto") Integer idTrajeto) {
        Optional<Trajeto> trajetoOptional = trajetoService.findById(idTrajeto);

        if (!trajetoService.existsById(idTrajeto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trajetoOptional.get());
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TrajetoDTO trajetoDTO) {
        Trajeto trajetoModel = new Trajeto();
        BeanUtils.copyProperties(trajetoDTO, trajetoModel);

        return ResponseEntity.status(HttpStatus.OK).body(trajetoService.save(trajetoModel));
    }

    @PutMapping("/{idTrajeto}")
    public ResponseEntity<Object> update(@RequestBody @Valid ReservaDTO reservaDTO, @PathVariable(value = "idTrajeto") Integer idTrajeto) {
        if (!trajetoService.existsById(idTrajeto)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi encontrada nenhuma reserva com este ID");
        }

        Trajeto trajeto = trajetoService.findById(idTrajeto).get();
        BeanUtils.copyProperties(reservaDTO, trajeto);
        trajeto.setIdTrajeto(idTrajeto);

        return ResponseEntity.status(HttpStatus.OK).body(trajetoService.save(trajeto));
    }

    @DeleteMapping("/{idTrajeto}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idTrajeto") Integer idTrajeto) {
        if (!trajetoService.existsById(idTrajeto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        trajetoService.deleteById(idTrajeto);
        return ResponseEntity.status(HttpStatus.OK).body("Trajeto deletado");
    }
}
