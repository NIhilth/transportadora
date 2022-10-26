package banco.leandro.transportadora.DTO;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ParadaDTO {

    @NotBlank
    private String endereco;
}