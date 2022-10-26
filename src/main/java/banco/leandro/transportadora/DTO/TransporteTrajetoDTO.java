package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.model.entities.Transporte;
import lombok.Getter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;
import java.sql.Time;

@Getter
public class TransporteTrajetoDTO {

    @NotNull
    private Transporte transporte;

    @NotNull
    private Trajeto trajeto;

    @NotNull
    private Time horarioIda;

    @FutureOrPresent
    private Date dataIda;

    @Positive
    private Double valorPassagem;
}
