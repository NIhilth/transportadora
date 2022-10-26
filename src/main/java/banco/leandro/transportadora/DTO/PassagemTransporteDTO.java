package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Estado;
import banco.leandro.transportadora.model.entities.Passagem;
import banco.leandro.transportadora.model.entities.Transporte;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
public class PassagemTransporteDTO {

    @NotNull
    private Estado estado;

    @Digits(integer = 4, fraction = 0)
    private Integer acento;

    @NotNull
    private Passagem passagem;

    @NotNull
    private Transporte transporte;
}