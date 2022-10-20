package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parada")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( nullable = false)
    private Integer idParada;

    @Column(nullable = false)
    private String endereco;
}