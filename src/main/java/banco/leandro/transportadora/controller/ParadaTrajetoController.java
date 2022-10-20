package banco.leandro.transportadora.controller;


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

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ParadaTrajetoDTO paradaTrajetoDTO) {
        ParadaTrajeto trajetoModel = new ParadaTrajeto();
        BeanUtils.copyProperties(paradaTrajetoDTO, trajetoModel);

        return ResponseEntity.status(HttpStatus.OK).body(paradaTrajetoService.save(trajetoModel));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<ParadaTrajeto> trajetoOptional = paradaTrajetoService.findById(id);

        if (paradaTrajetoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trajetoOptional.get());
    }

    public boolean existsById(Integer integer) {
        return paradaTrajetoService.existsById(integer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (!paradaTrajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        paradaTrajetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Trajeto deletado");
    }
}
