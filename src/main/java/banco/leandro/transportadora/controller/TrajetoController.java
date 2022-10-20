package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.TrajetoDTO;
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

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TrajetoDTO trajetoDTO) {
        Trajeto trajetoModel = new Trajeto();
        BeanUtils.copyProperties(trajetoDTO, trajetoModel);

        return ResponseEntity.status(HttpStatus.OK).body(trajetoService.save(trajetoModel));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<Trajeto> trajetoOptional = trajetoService.findById(id);

        if (trajetoService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trajetoOptional.get());
    }

    public boolean existsById(Integer integer) {
        return trajetoService.existsById(integer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (!trajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " +
                    "nenhum trajeto com esse ID.");
        }
        trajetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Trajeto deletado");
    }
}
