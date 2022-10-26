package banco.leandro.transportadora.DTO;

import lombok.Getter;

import javax.validation.constraints.Digits;

@Getter
public class TransporteDTO {

    @Digits(integer = 4, fraction = 0)
    private Integer quantidadeAcentos;
}
