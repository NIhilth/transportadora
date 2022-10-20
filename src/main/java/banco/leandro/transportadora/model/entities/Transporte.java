package banco.leandro.transportadora.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "transporte")
public class Transporte {
    @Id
    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(nullable = false)
    private Integer quantidadeAcentos;
}
