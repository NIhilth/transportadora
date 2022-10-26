package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Parada;
import banco.leandro.transportadora.model.entities.Trajeto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class ParadaTrajetoDTO {

    @NotNull
    private Trajeto trajeto;

    @NotNull
    private Parada parada;

    @Digits(integer = 2, fraction = 0)
    private Integer etapa;
}
