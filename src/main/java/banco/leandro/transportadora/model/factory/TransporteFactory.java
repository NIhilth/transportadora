package banco.leandro.transportadora.model.factory;

import banco.leandro.transportadora.model.entities.Aviao;
import banco.leandro.transportadora.model.entities.Onibus;
import banco.leandro.transportadora.model.entities.Transporte;
import banco.leandro.transportadora.model.entities.Trem;

public class TransporteFactory {
    public Transporte getTransporte(Integer tipo) {
        switch (tipo) {
            case 1 -> {
                return new Aviao();
            }
            case 2 -> {
                return new Onibus();
            }
            case 3 -> {
                return new Trem();
            }
            default -> {
                return null;
            }
        }
    }
}
