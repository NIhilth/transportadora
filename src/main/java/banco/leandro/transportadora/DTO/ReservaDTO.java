package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Pessoa;

import java.util.Date;

public class ReservaDTO {
    private Integer idReserva;
    private Integer quantidadePassagens;
    private Double valorTotal;
    private Date dataIda;
    private Pessoa pessoa;
}
