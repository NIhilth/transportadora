package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.ParadaDTO;
import banco.leandro.transportadora.model.entities.Parada;
import banco.leandro.transportadora.model.service.ParadaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/transportadora/parada")
public class ParadaController {
    private final ParadaService paradaService;

    public ParadaController(ParadaService paradaService) {
        this.paradaService = paradaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Parada>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(paradaService.findAll());
    }

    @GetMapping("/listar/{idParada}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idParada") Integer idParada) {
        if (!paradaService.existsById(idParada)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma parada com o ID informado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(paradaService.findById(idParada));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> save(@RequestBody @Valid ParadaDTO paradaDto) {
        if (paradaService.existsById(paradaDto.getIdParada())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ID já cadastrado");
        }

        Parada parada = new Parada();
        BeanUtils.copyProperties(paradaDto, parada);

        paradaService.save(parada);
        return ResponseEntity.status(HttpStatus.OK).body("Parada cadastrada com sucesso!");
    }

    @PutMapping("/editar/{idParada}")
    public ResponseEntity<Object> update(@PathVariable(value = "idParada") Integer idParada, @Valid @RequestBody ParadaDTO paradaDto) {
        if (!paradaService.existsById(idParada)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma parada com o ID informado");
        }

        Parada parada = paradaService.findById(paradaDto.getIdParada()).get();
        BeanUtils.copyProperties(paradaDto, parada);

        paradaService.save(parada);
        return ResponseEntity.status(HttpStatus.OK).body("Parada editada com sucesso!");
    }

    @DeleteMapping("/excluir/{idParada}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idParada") Integer idParada) {
        if (!paradaService.existsById(idParada)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma parada com o ID informado!");
        }

        paradaService.deleteById(idParada);
        return ResponseEntity.status(HttpStatus.OK).body("Parada deletada com sucesso!");
    }
}