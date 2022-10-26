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
    @Column(nullable = false)
    private Integer idPassagemTransporte;

    @Column(nullable = false)
    private Integer acento;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idPassagem", nullable = false)
    private Passagem passagem;

    @ManyToOne
    @JoinColumn(name = "idTransporte", nullable = false)
    private Transporte transporte;
}