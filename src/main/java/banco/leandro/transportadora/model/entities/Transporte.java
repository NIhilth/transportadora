package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "transporte")
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idTransporte;

    @Column(nullable = false)
    private Integer quantidadeAcentos;
}
