package factorymethod.ruokailijat;

import factorymethod.juomat.Juoma;
import factorymethod.juomat.Vesi;

public class Opettaja extends AterioivaOtus {

    public Juoma createJuoma() {
        return new Vesi();
    }

}
