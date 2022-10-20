package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idTransporteTrajeto;

    @ManyToOne
    @Column(nullable = false, unique = true)
    private Transporte transporte;

    @ManyToOne
    @Column(nullable = false, unique = true)
    private Trajeto trajeto;

    @Column(nullable = false)
    private Time horarioIda;

    @Column(nullable = false)
    private Date dataIda;

    @Column(nullable = false)
    private Double valorPassagem;

}
