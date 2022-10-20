package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.Trajeto;
import banco.leandro.transportadora.model.entities.Transporte;

import java.sql.Date;
import java.sql.Time;

public class TransporteTrajetoDTO {

    private Transporte transporte;

    private Trajeto trajeto;

    private Time horarioIda;

    private Date dataIda;

    private Double valorPassagem;
}
