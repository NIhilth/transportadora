package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Estado;
import banco.leandro.transportadora.model.entities.Passagem;
import banco.leandro.transportadora.model.entities.Transporte;
import lombok.Getter;

@Getter
public class PassagemTransporteDTO {
    private Estado estado;
    private Integer acento;
    private Passagem passagem;
    private Transporte transporte;
}