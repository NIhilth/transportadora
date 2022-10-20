package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "transporteTrajeto")
public class TransporteTrajeto {

    @ManyToOne
    @Column(nullable = false, unique = true)
    private Integer transporteNumero;

    @ManyToOne
    @Column(nullable = false, unique = true)
    private Integer linhaId;

    @Column(nullable = false)
    private Time horarioIda;

    @Column(nullable = false)
    private Date dataIda;

    @Column(nullable = false)
    private Double valorPassagem;

}
