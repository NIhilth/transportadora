package banco.leandro.transportadora.controller;

import banco.leandro.transportadora.DTO.PessoaDTO;
import banco.leandro.transportadora.model.entities.Pessoa;
import banco.leandro.transportadora.model.service.PessoaService;
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
@RequestMapping("/transportadora/pessoa")
public class PessoaController {
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idPessoa") Integer idPessoa) {
        if(!pessoaService.existsById(idPessoa)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma pessoa com este ID");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(idPessoa));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Object> update(@RequestBody @Valid PessoaDTO pessoaDTO, @PathVariable(value = "idPessoa") Integer idPessoa) {
        if(!pessoaService.existsById(idPessoa)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi encontrada nenhuma pessoa com este ID");
        }

        Pessoa pessoa = pessoaService.findById(idPessoa).get();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoa.setIdPessoa(idPessoa);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "idPessoa") Integer idPessoa) {
        if(!pessoaService.existsById(idPessoa)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma pessoa com este ID");
        }

        pessoaService.deleteById(idPessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada");
    }
}
