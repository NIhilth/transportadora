package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.PassagemDTO;
import banco.leandro.transportadora.DTO.PassagemTransporteDTO;
import banco.leandro.transportadora.model.entities.Passagem;
import banco.leandro.transportadora.model.entities.PassagemTransporte;
import banco.leandro.transportadora.model.service.PassagemService;
import banco.leandro.transportadora.model.service.PassagemTransporteService;
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
@RequestMapping("/transportadora/passagemTransporte")
public class PassagemTransporteController {
    private PassagemTransporteService passagemTransporteService;

    @GetMapping
    public ResponseEntity<List<PassagemTransporte>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(passagemTransporteService.findAll());
    }

    @GetMapping("/{idPassagemTransporte}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idPassagemTransporte") Integer idPassagemTransporte) {
        if(!passagemTransporteService.existsById(idPassagemTransporte)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma passagem de um transporte com este ID");
        }

        return ResponseEntity.status(HttpStatus.OK).body(passagemTransporteService.findById(idPassagemTransporte));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PassagemTransporteDTO passagemTransporteDTO) {
        PassagemTransporte passagemTransporte = new PassagemTransporte();
        BeanUtils.copyProperties(passagemTransporteDTO, passagemTransporte);

        return ResponseEntity.status(HttpStatus.OK).body(passagemTransporteService.save(passagemTransporte));
    }

    @PutMapping("/{idPassagemTransporte}")
    public ResponseEntity<Object> update(@RequestBody @Valid PassagemTransporteDTO passagemTransporteDTO, @PathVariable(value = "idPassagemTransporte") Integer idPassagemTransporte) {
        if(!passagemTransporteService.existsById(idPassagemTransporte)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi encontrada nenhuma passagem de um transporte com este ID");
        }

        PassagemTransporte passagemTransporte = passagemTransporteService.findById(idPassagemTransporte).get();
        BeanUtils.copyProperties(passagemTransporteDTO, passagemTransporte);
        passagemTransporte.setIdPassagemTransporte(idPassagemTransporte);

        return ResponseEntity.status(HttpStatus.OK).body(passagemTransporteService.save(passagemTransporte));
    }

    @DeleteMapping("/{idPassagemTransporte}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idPassagemTransporte") Integer idPassagemTransporte) {
        if(!passagemTransporteService.existsById(idPassagemTransporte)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma passagem de um transporte com este ID");
        }

        passagemTransporteService.deleteById(idPassagemTransporte);
        return ResponseEntity.status(HttpStatus.OK).body("Passagem de transporte deletada");
    }
}
