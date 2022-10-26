package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.TransporteDTO;
import banco.leandro.transportadora.model.entities.Transporte;
import banco.leandro.transportadora.model.factory.TransporteFactory;
import banco.leandro.transportadora.model.service.TransporteService;
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
@RequestMapping("/transportadora/transporte")
public class TransporteController {
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<List<Transporte>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if (!transporteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.findById(id));
    }

    @PostMapping("/{dtype}")
    public ResponseEntity<Object> save(@PathVariable(value = "dtype") Integer tipo, @RequestBody @Valid TransporteDTO transporteDTO) {
        Transporte transporteModel = new TransporteFactory().getTransporte(tipo);
        BeanUtils.copyProperties(transporteDTO, transporteModel);
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.save(transporteModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@PathVariable(value = "id") Integer id, @RequestBody @Valid TransporteDTO transporteDTO) {
        if (!transporteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        Transporte transporte = transporteService.findById(id).get();
        BeanUtils.copyProperties(transporteDTO, transporte);

        return ResponseEntity.status(HttpStatus.OK).body(transporteService.save(transporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (!transporteService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        transporteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transporte deletado com sucesso");
    }
}
