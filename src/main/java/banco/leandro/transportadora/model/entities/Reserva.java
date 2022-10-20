package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idReserva;

    @Column(nullable = false)
    private Integer quantidadePassagens;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private Date dataIda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;
}
