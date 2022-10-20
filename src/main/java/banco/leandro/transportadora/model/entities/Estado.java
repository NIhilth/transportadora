package banco.leandro.transportadora.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Estado {
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível");
    String nome;
}
