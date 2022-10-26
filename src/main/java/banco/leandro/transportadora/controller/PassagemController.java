package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.PassagemDTO;
import banco.leandro.transportadora.model.entities.Passagem;
import banco.leandro.transportadora.model.service.PassagemService;
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
@RequestMapping("/transportadora/passagem")
public class PassagemController {
    private PassagemService passagemService;

    @GetMapping
    public ResponseEntity<List<Passagem>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.findAll());
    }

    @GetMapping("/{idPassagem}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idPassagem") Integer idPassagem) {
        if(!passagemService.existsById(idPassagem)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma passagem com este ID");
        }

        return ResponseEntity.status(HttpStatus.OK).body(passagemService.findById(idPassagem));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PassagemDTO passagemDTO) {
        Passagem passagem = new Passagem();
        BeanUtils.copyProperties(passagemDTO, passagem);
        Passagem passagemNova = passagemService.save(passagem);

        return ResponseEntity.status(HttpStatus.OK).body(passagemNova);
    }

    @PutMapping("/{idPassagem}")
    public ResponseEntity<Object> update(@RequestBody @Valid PassagemDTO passagemDTO, @PathVariable(value = "idPassagem") Integer idPassagem) {
        if(!passagemService.existsById(idPassagem)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi encontrada nenhuma passagem com este ID");
        }

        Passagem passagem = passagemService.findById(idPassagem).get();
        BeanUtils.copyProperties(passagemDTO, passagem);
        passagem.setIdPassagem(idPassagem);

        return ResponseEntity.status(HttpStatus.OK).body(passagemService.save(passagem));
    }

    @DeleteMapping("/{idPassagem}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idPassagem") Integer idPassagem) {
        if(!passagemService.existsById(idPassagem)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma passagem com este ID");
        }

        passagemService.deleteById(idPassagem);
        return ResponseEntity.status(HttpStatus.OK).body("Passagem deletada");
    }
}
