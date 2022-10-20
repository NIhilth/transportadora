package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passagemTransporte")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class PassagemTransporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer idPassagemTransporte;

    @Column(nullable = false)
    private Integer acento;

    @Column
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idPassagem", nullable = false)
    private Passagem passagem;

    @ManyToOne
    @JoinColumn(name = "idTransporte", nullable = false)
    private Transporte transporte;
}