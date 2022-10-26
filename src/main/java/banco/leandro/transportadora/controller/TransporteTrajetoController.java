package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.TransporteDTO;
import banco.leandro.transportadora.DTO.TransporteTrajetoDTO;
import banco.leandro.transportadora.model.entities.Transporte;
import banco.leandro.transportadora.model.entities.TransporteTrajeto;
import banco.leandro.transportadora.model.factory.TransporteFactory;
import banco.leandro.transportadora.model.service.TransporteService;
import banco.leandro.transportadora.model.service.TransporteTrajetoService;
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
@RequestMapping("/transportadora/transporteTrajeto")
public class TransporteTrajetoController {
    private TransporteTrajetoService transporteTrajetoService;

    @GetMapping
    public ResponseEntity<List<TransporteTrajeto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transporteTrajetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        if (!transporteTrajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte de um trajeto com o id informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transporteTrajetoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TransporteTrajetoDTO transporteTrajetoDTO) {
        TransporteTrajeto transporteTrajeto = new TransporteTrajeto();
        BeanUtils.copyProperties(transporteTrajetoDTO, transporteTrajeto);
        return ResponseEntity.status(HttpStatus.OK).body(transporteTrajetoService.save(transporteTrajeto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@PathVariable(value = "id") Integer id, @RequestBody @Valid TransporteTrajetoDTO transporteTrajetoDTO) {
        if (!transporteTrajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte de um trajeto com o id informado");
        }
        TransporteTrajeto transporteTrajeto = transporteTrajetoService.findById(id).get();
        BeanUtils.copyProperties(transporteTrajetoDTO, transporteTrajeto);

        return ResponseEntity.status(HttpStatus.OK).body(transporteTrajetoService.save(transporteTrajeto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (!transporteTrajetoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte de um trajeto com o id informado");
        }
        transporteTrajetoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transporte de trajeto deletado com sucesso");
    }
}
