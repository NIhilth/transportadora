package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Estado;
import banco.leandro.transportadora.model.entities.Reserva;
import banco.leandro.transportadora.model.entities.Transporte;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
public class PassagemDTO {

    @Digits(integer = 3, fraction = 0)
    private Integer portaoEmbarque;

    @Digits(integer = 4, fraction = 0)
    private Integer acento;

    @NotNull
    private Estado estado;

    @NotNull
    private Reserva reserva;

    @NotNull
    private Transporte transporte;

}