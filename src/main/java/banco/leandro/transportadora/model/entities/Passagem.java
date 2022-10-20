package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Passagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer idPassagem;

    @Column(nullable = false)
    private Integer portaoEmbarque;

    @ManyToOne
    @JoinColumn(name = "idReserva", nullable = false)
    private Reserva reserva;
}