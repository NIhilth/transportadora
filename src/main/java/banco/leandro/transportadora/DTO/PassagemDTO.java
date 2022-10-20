package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Reserva;
import lombok.Getter;

@Getter
public class PassagemDTO {
    private Integer idPassagem;
    private Integer portaoEmbarque;
    private Reserva reserva;
}