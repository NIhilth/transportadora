package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Pessoa;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class ReservaDTO {

    @Positive
    private Double valorTotal;

    @FutureOrPresent
    private Date dataIda;

    @NotNull
    private Pessoa pessoa;
}
