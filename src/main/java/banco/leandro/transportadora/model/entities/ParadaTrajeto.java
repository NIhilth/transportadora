package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "paradaTrajeto")

public class ParadaTrajeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idParadaTrajeto;

    @ManyToOne
    @JoinColumn(name = "idParada", nullable = false)
    private Parada parada;

    @ManyToOne
    @JoinColumn(name = "idTrajeto", nullable = false)
    private Trajeto trajeto;

    @Column(nullable = false)
    private Integer etapa;
}
