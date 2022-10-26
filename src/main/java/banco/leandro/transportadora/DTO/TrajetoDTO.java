package banco.leandro.transportadora.DTO;

import banco.leandro.transportadora.model.entities.ParadaTrajeto;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class TrajetoDTO {

    @NotNull
    private List<ParadaTrajeto> parada;

}
