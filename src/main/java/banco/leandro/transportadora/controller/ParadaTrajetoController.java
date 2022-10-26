package banco.leandro.transportadora.controller;


import banco.leandro.transportadora.DTO.ParadaDTO;
import banco.leandro.transportadora.DTO.ParadaTrajetoDTO;
import banco.leandro.transportadora.DTO.TrajetoDTO;
import banco.leandro.transportadora.model.entities.Parada;
import banco.leandro.transportadora.model.entities.ParadaTrajeto;
import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.model.service.ParadaTrajetoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transportadora/paradaTrajeto")
public class ParadaTrajetoController {
    private ParadaTrajetoService paradaTrajetoService;

    @GetMapping
    public ResponseEntity<List<ParadaTrajeto>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(paradaTrajetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if (paradaTrajetoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhuma parada de trajeto com esse ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paradaTrajetoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ParadaTrajetoDTO paradaTrajetoDTO) {
        ParadaTrajeto paradaTrajeto = new ParadaTrajeto();
        BeanUtils.copyProperties(paradaTrajetoDTO, paradaTrajeto);

        return ResponseEntity.status(HttpStatus.OK).body(paradaTrajetoService.save(paradaTrajeto));
    }

    @PutMapping("/{idParadaTrajeto}")
    public ResponseEntity<Object> update(@PathVariable(value = "idParadaTrajeto") Integer idParadaTrajeto, @Valid @RequestBody ParadaTrajetoDTO paradaTrajetoDto) {
        if (!paradaTrajetoService.existsById(idParadaTrajeto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma parada de trajeto com o ID informado");
        }

        ParadaTrajeto paradaTrajeto = paradaTrajetoService.findById(idParadaTrajeto).get();
        BeanUtils.copyProperties(paradaTrajetoDto, paradaTrajeto);

        return ResponseEntity.status(HttpStatus.OK).body(paradaTrajetoService.save(paradaTrajeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (!paradaTrajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhuma parada de um trajeto com esse ID.");
        }

        paradaTrajetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Trajeto deletado");
    }
}
