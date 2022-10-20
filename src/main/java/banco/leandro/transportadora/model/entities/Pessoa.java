package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idPessoa;

    @Column(length = 50, nullable = false)
    private String nome;
}
