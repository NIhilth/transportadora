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

    @GetMapping("/{idTransporte}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer idTransporte) {
        if (!transporteService.existsById(idTransporte)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.findById(idTransporte));
    }

    @PostMapping("/{dtype}")
    public ResponseEntity<Object> save(@PathVariable(value = "dtype") Integer tipo, @RequestBody @Valid TransporteDTO transporteDTO) {
        Transporte transporteModel = new TransporteFactory().getTransporte(tipo);
        BeanUtils.copyProperties(transporteDTO, transporteModel);
        return ResponseEntity.status(HttpStatus.OK).body(transporteService.save(transporteModel));
    }

    @PutMapping("/{idTransporte}")
    public ResponseEntity<Object> edit(@PathVariable(value = "idTransporte") Integer idTransporte, @RequestBody @Valid TransporteDTO transporteDTO) {
        if (!transporteService.existsById(idTransporte)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        Transporte transporte = transporteService.findById(idTransporte).get();
        BeanUtils.copyProperties(transporteDTO, transporte);
        transporte.setIdTransporte(idTransporte);

        return ResponseEntity.status(HttpStatus.OK).body(transporteService.save(transporte));
    }

    @DeleteMapping("/{idTransporte}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idTransporte") Integer idTransporte) {
        if (!transporteService.existsById(idTransporte)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum transporte com o id informado");
        }
        transporteService.deleteById(idTransporte);
        return ResponseEntity.status(HttpStatus.OK).body("Transporte deletado com sucesso");
    }
}
