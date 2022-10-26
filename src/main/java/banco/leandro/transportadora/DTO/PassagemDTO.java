package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Reserva;
import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
public class PassagemDTO {

    @Digits(integer = 3, fraction = 0)
    private Integer portaoEmbarque;

    @NotNull
    private Reserva reserva;
}